package com.company.business.goods.security.authorization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.FormIdVo;
import com.company.business.goods.common.vo.PacketRuleVo;
import com.company.business.goods.moudle.entity.*;
import com.company.business.goods.moudle.service.*;
import com.company.business.goods.security.user.ITokenService;
import com.company.business.goods.security.user.ITomatoUserService;
import com.company.business.goods.security.user.TomatoUserEntity;
import com.company.business.goods.utils.*;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    private String ERROR_CODE_MESSAGE = "errcode";
    private String ERROR_MSG_MESSAGE = "errmsg";
    private String SESSION_KEY = "session_key";
    private String OPEN_ID_KEY = "openid";
    @Autowired
    private AuthenticationConfigProperties configProperties;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Resource
    private ITokenService tokenService;
    @Autowired
    private ITomatoUserService tomatoUserService;

    @Autowired
    private ITemplateService templateService;

    @Autowired
    private ITomatoCouponUserService tomatoCouponUserService;

    @Autowired
    private ICommissionDailyService commissionDailyService;

    @Autowired
    private IPacketUserService packetUserService;

    @Autowired
    private IPacketRuleService packetRuleService;//

    @Autowired
    private IPacketLimitService packetLimitService;//

    @Autowired
    private IPacketInviteLogService packetInviteLogService;


    private void resetUserCommission(String openId) {
        CommissionDailyEntity commissionDailyEntity = commissionDailyService.getCommissionDaily(openId);
        if (null == commissionDailyEntity) {
            return;
        } else if (DateUtils.isNotOneDay(commissionDailyEntity.getCommission_date(), new Date()) > TomatoConstant.Common.NUMBER_0) {
            commissionDailyEntity.setCommission_times(TomatoConstant.Common.NUMBER_0);
            commissionDailyService.insertCommissionEntity(commissionDailyEntity);
        }
    }

    //fixme 从用户第一次领取红包开始的30天后红包金额清0
    private void resetUserPacket(String openId) {

        PacketUserEntity packetUserEntity = packetUserService.getPacketUserEntity(openId);
        if (null == packetUserEntity) {
            return;
        }
        if (DateUtils.isNotOneDay(packetUserEntity.getPacket_first_date(), new Date()) >= TomatoConstant.Common.NUMBER_30) {
            packetUserEntity.setPacket_first_date(null);
            packetUserEntity.setPacket_recent_date(null);
            packetUserEntity.setPacket_amounts(new BigDecimal("0.00"));
            packetUserEntity.setPacket_times(TomatoConstant.Common.NUMBER_0);
            packetUserService.insertUpdatePacketUser(packetUserEntity);
        }


    }

    /**
     * 重置用户的每日数据
     */

    private void resetDaily(String openId) {

        resetUserCommission(openId);
        resetUserPacket(openId);
    }

    @Override
    public AuthorizationVo authentication(ServletRequest request, String inviteOpenId, String code) {
        AuthorizationVo authorizationVo = this.requestWxAuthtication(request, code);

        //fixme 登录成功
        if (TextUtils.isEmpty(authorizationVo.getErrorMsg())) {
            Date date = new Date();
            String openId = authorizationVo.getOpenId();
            resetDaily(openId);//重置用户的每日数据
            //fixme 注册用户到数据库
            insertUserInfo(date, openId, inviteOpenId);
            //fixme 实例化全局用户信息
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(openId, openId);


            Authentication authentication = authenticationManager.authenticate(upToken);//调用loadUserByUsername--ProviderManager实现类中
            SecurityContextHolder.getContext().setAuthentication(authentication);//实例化全局Authentication对象--登录成功后会实例化UserDetails实例
            UserDetails userDetails = userDetailsService.loadUserByUsername(openId);
            String token = tokenService.generateToken(userDetails);

            authorizationVo.setToken(token);

            tokenService.storeToken(token, getAccessToken(request));//保存token到redis

        }
        return authorizationVo;
    }

    @Override
    public AuthorizationVo getUserInfo(ServletRequest request, String code) {

        return this.requestWxAuthtication(request, code);
    }

    /**
     * 解析出
     *
     * @param request
     * @param json
     * @return
     */
    @Override
    public JSONObject decodeUserInfo(ServletRequest request, JSONObject json) {
        JSONObject result = null;
        String encryptedData = json.getString("encryptedData");
        String iv = json.getString("iv");
        String code = json.getString("code");

        int category = json.getIntValue("category");

        AuthorizationVo wxAuthorizationVo = this.getUserInfo(request, code);
        try {
            result = AesCbcUtils.decrypt(encryptedData, wxAuthorizationVo.getSessionKey(), iv, "UTF-8");
            if (category == TomatoConstant.Authorization.WX_USER_INFO_1) {//解析用户信息
                //将当前用户的数据保存到数据表
                updateUserInfo(result);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 受邀者注册成功后触发的消息推送
     *
     * @param inviteOpenId
     */
    private void sendMessage(String inviteOpenId, String openId) {

        if (TextUtils.isEmpty(inviteOpenId)) {
            return;
        }


        //获取邀请者邀请好友数量
        List<TomatoUserEntity> userEntityList = tomatoCouponUserService.getUserFansList(inviteOpenId);

        //获取formId
        FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(inviteOpenId));

        if (null == formIdVo) {
            Log.e("formId invalid");
            return;
        }

        Map<String, Object> map = new HashMap();

        map.put("nickName", new StringBuilder(TomatoConstant.Common.TOMATO_USER).append(openId.substring(openId.length() - 3, openId.length())).toString());
        map.put("num", userEntityList.size());

        templateService.sendNotifyTemplate(inviteOpenId, formIdVo, map, TomatoConstant.Common.NUMBER_1);

    }

    /**
     * 将微信中获取的avatar和nickname插入当前用户表
     */
    private void updateUserInfo(JSONObject json) {
        String nickName = json.getString("nickName");
        String avatar = json.getString("avatarUrl");


        //fixme 获取用户的邀请者信息
        TomatoUserEntity tomatoUserEntity = tomatoUserService.findUserByUsername(PrincipalUtils.getUsername());
        if (null == tomatoUserEntity) {
            return;
        }
        tomatoUserEntity.setNickName(nickName);
        tomatoUserEntity.setAvatar(avatar);

        tomatoUserService.updateUserInfo(tomatoUserEntity);

    }

    /**
     * 获取微信的access_token
     *
     * @param request
     * @return
     */
    @Override
    public String getAccessToken(ServletRequest request) {

        //fixme 获取微信access_token start
        String url = new StringBuilder(configProperties.getWx_token_url()).append("&appid=").append(configProperties.getAppId())
                .append("&secret=").append(configProperties.getAppSecret()).toString();

        String response = TomatoRestUtils.get(request, url, null);
        JSONObject json = JSON.parseObject(response);
        String access_token = json.getString("access_token");
        return access_token;
    }


    private void insertUserInfo(Date date, String openId, String inviteOpenId) {

        TomatoUserEntity tomatoUser = tomatoUserService.findUserByUsername(openId);
        if (null == tomatoUser) {//fixme 新用户注册
            Log.i("tomatoUser is null,openId:" + openId);
            tomatoUser = buildTomatoUser(openId, date, inviteOpenId);
            boolean success = tomatoUserService.updateTomatoUser(tomatoUser);//--success
            if (success) {
                sendMessage(inviteOpenId, openId);//fixme 触发发送通知消息--需要知道用户的昵称数据
                receivePacket(openId, inviteOpenId);
            }

        } else {
            Log.i("tomatoUser is not null,openId:" + openId + ",change rookie");
            tomatoUser.setRookie(TomatoConstant.Common.NUMBER_0);//
            tomatoUser.setLatelyLogin(date);
            tomatoUserService.updateTomatoUser(tomatoUser); //更新当前的用户状态
        }


    }


    /**
     * 从缓存中获取规则
     *
     * @return
     */
    private List<PacketRuleEntity> getRuleList() {

        PacketRuleVo packetRuleVo = (PacketRuleVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getPacketRuleKey());

        if (null == packetRuleVo) {

            List<PacketRuleEntity> list = packetRuleService.getPacketRuleList();
            if (list.size() > TomatoConstant.Common.NUMBER_0) {//规则为list size 0，返回null
                packetRuleVo = new PacketRuleVo();
                packetRuleVo.setList(list);
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getPacketRuleKey(), packetRuleVo, TomatoConstant.Common.EXPIRE_TIME_REDIS_1800);//半小时
                return list;
            }
            return null;
        }
        return packetRuleVo.getList();
    }

    private PacketLimitEntity getPacketLimit() {
        PacketLimitEntity packetLimitEntity = (PacketLimitEntity) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getPacketLimitKey());
        if (null == packetLimitEntity) {
            packetLimitEntity = packetLimitService.getPacketLimitEntity();
            if (null != packetLimitEntity) {
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getPacketLimitKey(), packetLimitEntity, TomatoConstant.Common.EXPIRE_TIME_REDIS_1800);//半小时
                return packetLimitEntity;
            }

            return null;
        }
        return packetLimitEntity;
    }

    /**
     * 将此方法中的配置保存到redis中
     *
     * @param packetUserEntity
     * @return
     */
    private BigDecimal show(PacketUserEntity packetUserEntity) {

        List<PacketRuleEntity> list = this.getRuleList();

        if (null == list) {//规则为list size 0，返回null
            return null;
        }


        if (null == packetUserEntity) {

            PacketRuleEntity packetRuleEntity = list.get(TomatoConstant.Common.NUMBER_0);

            return getRandom(packetRuleEntity.getLower_limit_amounts().doubleValue(), packetRuleEntity.getUpper_limit_amounts().doubleValue());
        }

        //fixme 红包不为空则需要判断是否超过了红包的限制金额19.75
        PacketLimitEntity packetLimitEntity = getPacketLimit();
        if (null == packetLimitEntity) {
            if (packetUserEntity.getPacket_amounts().doubleValue() - TomatoConstant.Common.DOUBLE_LIMIT >= TomatoConstant.Common.NUMBER_0) {
                return null;
            }
            for (PacketRuleEntity packetRuleEntity : list) {
                if (packetRuleEntity.getAccruing_amounts().doubleValue() - packetUserEntity.getPacket_amounts().doubleValue() > 0) {

                    return getRandom(packetRuleEntity.getLower_limit_amounts().doubleValue(), packetRuleEntity.getUpper_limit_amounts().doubleValue());
                }

            }

        } else {
            if (packetUserEntity.getPacket_amounts().doubleValue() - packetLimitEntity.getTotal_accruing_amounts().doubleValue() >= TomatoConstant.Common.NUMBER_0) {
                return null;
            }
            for (PacketRuleEntity packetRuleEntity : list) {
                if (packetRuleEntity.getAccruing_amounts().doubleValue() - packetUserEntity.getPacket_amounts().doubleValue() > 0) {

                    return getRandom(packetRuleEntity.getLower_limit_amounts().doubleValue(), packetRuleEntity.getUpper_limit_amounts().doubleValue());
                }

            }

        }
        return null;
    }

    //[x,y]
    public BigDecimal getRandom(double lower, double upper) {
        if (lower == upper) {
            return null;
        }
        return new BigDecimal((lower + Math.random() * upper % (upper - lower))).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * @param openId--当前注册用户--被邀请者
     * @param inviteOpenId         邀请者
     */
    private void receivePacket(String openId, String inviteOpenId) {
        if (TextUtils.isEmpty(inviteOpenId)) {
            return;
        }

        PacketUserEntity packetUserEntity = packetUserService.getPacketUserEntity(inviteOpenId);
        if (null == packetUserEntity) {//fixme 当用户首次注册未领取红包
            BigDecimal bigDecimal = null == show(null) ? new BigDecimal("0.00") : show(null);

            packetUserEntity = new PacketUserEntity();
            packetUserEntity.setUser_name(inviteOpenId);
            packetUserEntity.setPacket_times(TomatoConstant.Common.NUMBER_1);
            packetUserEntity.setPacket_first_date(new Date());//30天内第一次领取红包
            packetUserEntity.setPacket_recent_date(new Date());
            packetUserEntity.setPacket_amounts(bigDecimal);
            packetUserService.insertUpdatePacketUser(packetUserEntity);
            insertPacketLog(openId, inviteOpenId, bigDecimal);
            return;
        } else if (null == packetUserEntity.getPacket_first_date()) {//重置后为null
            packetUserEntity.setPacket_first_date(new Date());
        }

        //fixme 可以判断和的结果为20则可以设置值小于20

        BigDecimal bigDecimal = null == show(packetUserEntity) ? new BigDecimal("0.00") : show(packetUserEntity);

        packetUserEntity.setPacket_recent_date(new Date());//设置最近的红包领取时间
        packetUserEntity.setPacket_times(packetUserEntity.getPacket_times() + TomatoConstant.Common.NUMBER_1);
        packetUserEntity.setPacket_amounts(BigDecimalUtils.addBig(packetUserEntity.getPacket_amounts(), bigDecimal));
        packetUserService.insertUpdatePacketUser(packetUserEntity);
        //记录邀请者、被邀请者的红包记录日志
        insertPacketLog(openId, inviteOpenId, bigDecimal);

    }

    private void insertPacketLog(String openId, String inviteOpenId, BigDecimal bigDecimal) {

        PacketInviteLogEntity packetInviteLogEntity = new PacketInviteLogEntity();
        packetInviteLogEntity.setInvite_user(inviteOpenId);//邀请者
        packetInviteLogEntity.setInvited_user(openId);//被邀请者--当前注册的用户
        packetInviteLogEntity.setPacket_money(bigDecimal.doubleValue() == TomatoConstant.Common.NUMBER_0 ? new BigDecimal("0.001") : bigDecimal);//fixme 保留三位小数点
        packetInviteLogEntity.setInvite_date(new Date());
        packetInviteLogService.insertUpdateLog(packetInviteLogEntity);

    }

    /**
     * 注册
     *
     * @param openId
     * @return
     */
    private TomatoUserEntity buildTomatoUser(String openId, Date date, String openInviteOpenId) {
        Log.i("BCryptPasswordEncoder");
        TomatoUserEntity tomatoUser = new TomatoUserEntity();
        tomatoUser.setUsername(openId);
        tomatoUser.setPassword(openId);
        tomatoUser.setLatelyLogin(date);//最近登录时间--注册时间
        tomatoUser.setRegisterDate(date);//注册时间
        tomatoUser.setRookie(TomatoConstant.Common.NUMBER_1);//设置是新用户
        tomatoUser.setInviteUser(openInviteOpenId);

        return tomatoUser;
    }

    /**
     * 微信鉴权请求
     *
     * @param request
     * @param code
     */
    private AuthorizationVo requestWxAuthtication(ServletRequest request, String code) {

        String url = new StringBuilder(configProperties.getWx_authorization_url()).append("?appid=")
                .append(configProperties.getAppId()).append("&secret=")
                .append(configProperties.getAppSecret()).append("&js_code=")
                .append(code).append("&grant_type=")
                .append(configProperties.getGrantType()).toString();

        AuthorizationVo authorizationVo = new AuthorizationVo();//创建返回对象
        try {
            String response = TomatoRestUtils.get(request, url, null);
            JSONObject json = JSON.parseObject(response);
            if (!TextUtils.isEmpty(json.getString(OPEN_ID_KEY))) {//成功后无返回码
                String sessionKey = json.getString(SESSION_KEY);
                String openId = json.getString(OPEN_ID_KEY);

                authorizationVo.setSessionKey(sessionKey);
                authorizationVo.setOpenId(openId);

            } else {//失败信息
                authorizationVo.setErrorCode(json.getIntValue(ERROR_CODE_MESSAGE));
                authorizationVo.setErrorMsg(json.getString(ERROR_MSG_MESSAGE));
                return authorizationVo;
            }


        } catch (Exception e) {
            e.printStackTrace();
            authorizationVo.setErrorCode(ErrorCodeEnum.AUTH1003.code());
            authorizationVo.setErrorMsg(ErrorCodeEnum.AUTH1003.msg());
            return authorizationVo;
        }

        return authorizationVo;
    }
}
