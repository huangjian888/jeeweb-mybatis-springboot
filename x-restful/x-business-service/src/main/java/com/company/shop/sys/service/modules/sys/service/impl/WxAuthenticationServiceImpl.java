package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.utils.RestTemplateUtils;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.FormIdVo;
import com.company.shop.sys.service.common.vo.WxAuthorizationVo;
import com.company.shop.sys.service.modules.sys.entity.*;
import com.company.shop.sys.service.modules.sys.service.*;
import com.company.shop.sys.service.properties.WxConfigProperties;
import com.company.shop.sys.service.utils.*;
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
import java.util.List;


/**
 * 前端wx.login获取的code传入--服务端获取微信session
 */
@Transactional
@Service("wxAuthenticationServiceImpl")

public class WxAuthenticationServiceImpl implements IWxAuthenticationService {
    private String ERROR_CODE_MESSAGE = "errcode";
    private String ERROR_MSG_MESSAGE = "errmsg";
    private String SESSION_KEY = "session_key";
    private String OPEN_ID_KEY = "openid";
    @Autowired
    private WxConfigProperties wxconfigProperties;


    @Autowired
    private IStoreUserService storeUserService;

    @Autowired
    private UserDetailsService userDetailsService;

    @Resource
    private ITokenService tokenService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private IStepService stepService;

    @Autowired
    private IInviteAwardService iInviteAwardService;

    @Autowired
    private IInviteConfigService iInviteConfigService;

    @Autowired
    private IBuyLimitService buyLimitService;

    @Autowired
    private ITemplateService templateService;

    /**
     * 注册
     *
     * @param openId
     * @return
     */
    private StoreUserEntity buildStoreUser(String openId, String inviteOpenId, Date date) {
        StoreUserEntity storeUser = new StoreUserEntity();
        storeUser.setUsername(openId);
        storeUser.setPassword(openId);//openId作为密码
        storeUser.setRegisterDate(date);//注册时间
        storeUser.setLatelyLogin(date);//最近登录时间--注册时间
        storeUser.setInviteUser(inviteOpenId);//邀请者的openId
        storeUser.setNewuser(BusinessConstant.Home.ONE);//设置是新用户
        return storeUser;
    }

    /**
     * 被邀请者注册成为新用户--刷新邀请者每日邀请数量
     *
     * @param inviteOpenId
     */
    private void refreshInvite(String inviteOpenId, Date date) {


        //获取邀请者的邀请表信息--邀请者当日列表长度因小于后台设置
        InviteConfigEntity inviteConfigEntity = iInviteConfigService.getInviteEntity();
        List<InviteAwardEntity> inviteAwardEntityList = iInviteAwardService.getInviteAward(inviteOpenId);

        if (inviteAwardEntityList.size() == BusinessConstant.Home.ZERO || inviteAwardEntityList.size() < inviteConfigEntity.getPacketCount()) {
            InviteAwardEntity inviteAwardEntity = new InviteAwardEntity();
            inviteAwardEntity.setUserName(inviteOpenId);
            inviteAwardEntity.setAward(inviteConfigEntity.getAward());
            inviteAwardEntity.setDescription(inviteConfigEntity.getDescription());
            inviteAwardEntity.setStatus(BusinessConstant.Home.ZERO);
            inviteAwardEntity.setInsertDate(date);
            iInviteAwardService.insertInviteAward(inviteAwardEntity);
        }


    }


    private void sendMessage(String inviteOpenId) {

        FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(inviteOpenId));

        if (null == formIdVo) {
            return;
        }

        templateService.sendNotifyTemplate(inviteOpenId, formIdVo, null, BusinessConstant.Message.NUMBER_2);
    }

    /**
     * inviteOpenId--邀请者的openId
     * 查询当前登录用户是否是初次注册
     */
    private void initUserInfo(Date date, String openId, String inviteOpenId) {

        StoreUserEntity storeUserEntity = storeUserService.findByUsername(openId);
        if (null == storeUserEntity) {//fixme 用户初次注册
            //fixme 进行全局注册 --用户信息插入数据库
            storeUserEntity = buildStoreUser(openId, inviteOpenId, date);
            boolean success = storeUserService.insert(storeUserEntity);//--success
            if (success && !TextUtils.isEmpty(inviteOpenId)) {
                sendMessage(inviteOpenId);
                refreshInvite(inviteOpenId, date);
            }

        } else {

            if (!isRepetition(storeUserEntity.getLatelyLogin(), date)) {//超过一天将重置用户步数
                Log.i("距离上次登录超过一天，重置步数和今日金币");
                storeUserEntity.setStep(BusinessConstant.Home.ZERO);
                storeUserEntity.setGoldToday(new BigDecimal(BusinessConstant.Home.ZERO));
                storeUserEntity.setStatus(BusinessConstant.Home.ZERO);//重置用户今日步数兑换金币状态
            }

            storeUserEntity.setLatelyLogin(date);//设置最近一次登录
            storeUserService.insertOrUpdate(storeUserEntity);//更新当前的用户状态
        }

    }

    /**
     * 检查当前的时间间隔
     */
    private boolean isRepetition(Date lastDate, Date nowDate) {

        if (DateUtils.daysBetween(lastDate, nowDate) > 0) {
            Log.i("大于1天，返回false");
            return false;
        }
        return true;
    }

    /**
     * 登录成功后重置每日任务-分享,签到任务
     */
    private void resetDailyTask(Date nowDate) {

        //重置当日的签到奖励领取情况--步数兑换金币
        List<StepEntity> stepList = stepService.getUserStep();
        if (null != stepList && stepList.size() > BusinessConstant.Home.ZERO) {

            for (StepEntity stepEntity : stepList) {

                if (stepEntity.getStatus() == BusinessConstant.Home.ONE) {
                    if (!isRepetition(stepEntity.getExchangeDate(), nowDate)) {
                        stepEntity.setStatus(BusinessConstant.Home.ZERO);
                        stepEntity.setSymbol(BusinessConstant.Home.ZERO);
                        stepService.updateUserStep(stepEntity);
                    }
                }

            }
        }

        //重置每日邀请数量--清除

        List<InviteAwardEntity> inviteAwardEntityList = iInviteAwardService.getInviteAward();

        if (inviteAwardEntityList.size() != BusinessConstant.Home.ZERO) {

            for (InviteAwardEntity inviteAward : inviteAwardEntityList) {
                //删除过期奖励
                if (!isRepetition(inviteAward.getInsertDate(), nowDate)) {
                    iInviteAwardService.deleteInviteAward(inviteAward.getId());

                }
            }
        }

        //重置用户今日购买数量
        BuyLimitEntity buyLimitEntity = buyLimitService.getBuyLimit();
        if (null != buyLimitEntity) {//fixme 判断购买时间是否大于一天

            if (!isRepetition(buyLimitEntity.getGetDate(), nowDate)) {
                buyLimitEntity.setAmount(BusinessConstant.Home.ZERO);
                buyLimitService.insertUserBuy(buyLimitEntity);
            }
        }

    }

    /**
     * 获取用户信息
     *
     * @param request
     * @param code
     * @return
     */
    @Override
    public WxAuthorizationVo getUserInfo(ServletRequest request, String code) {

        return this.requestWxAuthtication(request, code);
    }

    /**
     * 将微信中获取的avatar和nickname插入当前用户表
     */
    private void updateUserInfo(JSONObject json) {
        String nickName = json.getString("nickName");
        String avatar = json.getString("avatarUrl");
        storeUserService.updateUserInfo(nickName, avatar);
    }

    /**
     * 翻译微信加密数据
     *
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

        WxAuthorizationVo wxAuthorizationVo = this.getUserInfo(request, code);
        try {
            result = AesCbcUtils.decrypt(encryptedData, wxAuthorizationVo.getSessionKey(), iv, "UTF-8");
            if (category == BusinessConstant.Authorization.WX_USER_INFO_1 && null != result) {//解析用户信息
                //将当前用户的数据保存到数据表
                updateUserInfo(result);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public String getAccessToken(ServletRequest request) {

        //fixme 获取微信access_token start
        String url = new StringBuilder(wxconfigProperties.getWx_token_url()).append("&appid=").append(wxconfigProperties.getAppid())
                .append("&secret=").append(wxconfigProperties.getAppsecret()).toString();

        String response = RestTemplateUtils.get(request, url, null);
        JSONObject json = JSON.parseObject(response);
        return json.getString("access_token");

    }

    /**
     * 微信鉴权请求
     *
     * @param request
     * @param code
     */
    private WxAuthorizationVo requestWxAuthtication(ServletRequest request, String code) {

        String url = new StringBuilder(wxconfigProperties.getWx_authorization_url()).append("?appid=")
                .append(wxconfigProperties.getAppid()).append("&secret=")
                .append(wxconfigProperties.getAppsecret()).append("&js_code=")
                .append(code).append("&grant_type=")
                .append(wxconfigProperties.getGranttype()).toString();

        WxAuthorizationVo wxAuthorizationVo = new WxAuthorizationVo();//创建返回对象
        try {
            String response = RestTemplateUtils.get(request, url, null);
            JSONObject json = JSON.parseObject(response);
            if (!TextUtils.isEmpty(json.getString(OPEN_ID_KEY))) {//成功后无返回码
                Log.i("wechat authorization is successed");
                String openId = json.getString(OPEN_ID_KEY);
                String sessionKey = json.getString(SESSION_KEY);

                wxAuthorizationVo.setOpenId(openId);
                wxAuthorizationVo.setSessionKey(sessionKey);

            } else {//失败信息

                wxAuthorizationVo.setErrorCode(json.getIntValue(ERROR_CODE_MESSAGE));
                wxAuthorizationVo.setErrorMsg(json.getString(ERROR_MSG_MESSAGE));
                return wxAuthorizationVo;
            }


        } catch (Exception e) {
            e.printStackTrace();
            wxAuthorizationVo.setErrorCode(ErrorCodeEnum.AUTH1003.code());
            wxAuthorizationVo.setErrorMsg(ErrorCodeEnum.AUTH1003.msg());
            return wxAuthorizationVo;
        }


        return wxAuthorizationVo;
    }


    /**
     * 鉴权成功后保存token到redis
     * inviteOpenId--邀请者openId
     *
     * @return
     */
    @Override
    public WxAuthorizationVo authentication(ServletRequest request, String inviteOpenId, String code) {
        Date date = new Date();
        WxAuthorizationVo wxAuthorizationVo = this.requestWxAuthtication(request, code);
        /**
         * 登录成功
         */
        if (TextUtils.isEmpty(wxAuthorizationVo.getErrorMsg())) {
            String openId = wxAuthorizationVo.getOpenId();

            //注册用户
            initUserInfo(date, openId, inviteOpenId);

            //fixme 实例化全局用户信息
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(openId, openId);

            Authentication authentication = authenticationManager.authenticate(upToken);//调用loadUserByUsername--ProviderManager实现类中
            SecurityContextHolder.getContext().setAuthentication(authentication);//实例化全局Authentication对象--登录成功后会实例化UserDetails实例
            UserDetails userDetails = userDetailsService.loadUserByUsername(openId);
            String token = tokenService.generateToken(userDetails);

            //重置用户每日任务
            resetDailyTask(date);

            wxAuthorizationVo.setToken(token);

            //fixme 获取微信access_token start
            String url = new StringBuilder(wxconfigProperties.getWx_token_url()).append("&appid=").append(wxconfigProperties.getAppid())
                    .append("&secret=").append(wxconfigProperties.getAppsecret()).toString();

            String response = RestTemplateUtils.get(request, url, null);
            JSONObject json = JSON.parseObject(response);
            String access_token = json.getString("access_token");
            //fixme 获取微信access_token end
            storeAccessToken(openId, access_token);
            tokenService.storeToken(token, access_token);//保存token到redis
        }
        return wxAuthorizationVo;
    }

    private void storeAccessToken(String openId, String accessToken) {
        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getWxAccessTokenKey(openId), accessToken, BusinessConstant.Common.EXPIRE_TIME_REDIS);
    }

}
