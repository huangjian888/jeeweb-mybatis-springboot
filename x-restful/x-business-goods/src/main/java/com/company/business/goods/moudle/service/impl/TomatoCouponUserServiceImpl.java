package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.vo.FriendsVo;
import com.company.business.goods.common.vo.UserFansVo;
import com.company.business.goods.moudle.entity.HardwareEntity;
import com.company.business.goods.moudle.entity.OrderEntity;
import com.company.business.goods.moudle.entity.PropertyInviterLogEntity;
import com.company.business.goods.moudle.service.*;
import com.company.business.goods.security.user.*;
import com.company.business.goods.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("tomatoCouponUserService")
@Transactional
public class TomatoCouponUserServiceImpl extends ServiceImpl<TomatoUserMapper, TomatoUserEntity> implements ITomatoCouponUserService {

    @Autowired
    private ITomatoUserService tomatoUserService;
    @Autowired
    private IHardWareService handWareService;
    @Autowired
    private IOrderService orderService;

    @Autowired
    private IPropertyLogService propertyLogService;

    @Autowired
    private IPropertyInviterLogService propertyInviterLogService;//邀请者的佣金获得情况

    @Override
    public int updateExitTime() {
        TomatoUserEntity tomatoUser = tomatoUserService.findUserByUsername(PrincipalUtils.getUsername());
        if (null == tomatoUser) {
            return 0;
        }
        tomatoUser.setExitTime(new Date());
        return insertOrUpdate(tomatoUser) ? 1 : 0;
    }

    /**
     * 获取所有用户--消息推送使用
     *
     * @return
     */
    @Override
    public List<TomatoUserEntity> getAllUser() {
        return baseMapper.getAllUser();
    }

    /**
     * 上传微信用户信息
     *
     * @return
     */
    @Override
    public int updateUserInfo(JSONObject json) {
        boolean isUser = false, isHardware = false;

        String gender = json.getString("gender");//用户性别
        String address = json.getString("address");//用户地址

        String brand = json.getString("brand");//设备品牌

        String model = json.getString("model");//设备型号
        String version = json.getString("version");//微信版本
        String system = json.getString("system");//操作系统版本
        String platform = json.getString("platform");//客户端平台


        TomatoUserEntity tomatoUser = tomatoUserService.findUserByUsername(PrincipalUtils.getUsername());
        if (null != tomatoUser) {
            tomatoUser.setGender(gender);
            tomatoUser.setAddress(address);
            isUser = insertOrUpdate(tomatoUser);

            //硬件信息
            HardwareEntity hardwareEntity = handWareService.getHardware();
            if (null == hardwareEntity) {
                hardwareEntity = new HardwareEntity();
                hardwareEntity.setUsername(PrincipalUtils.getUsername());
                hardwareEntity.setBrand(brand);
                hardwareEntity.setModel(model);
                hardwareEntity.setVersion(version);
                hardwareEntity.setSystem(system);
                hardwareEntity.setPlatform(platform);
                isHardware = handWareService.insertHardware(hardwareEntity);
            } else {
                isHardware = true;
            }

        }


        return (isHardware && isUser) ? 1 : 0;
    }

    private TomatoUserEntity getUserInfo(TomatoUserEntity tomatoUserEntity) {

        if (null == tomatoUserEntity.getNickName() || null == tomatoUserEntity.getAvatar()) {
            TomatoUserEntity tomatoUser = new TomatoUserEntity();
            tomatoUser.setNickName("");
            tomatoUser.setAvatar("");
            tomatoUser.setUsername(tomatoUserEntity.getUsername());
            return tomatoUser;
        }

        return tomatoUserEntity;

    }

    /**
     * 获取当前登录用户的粉丝(邀请好友)
     *
     * @param page
     * @return
     */
    @Override
    public Page<UserFansVo> getUserFansList(Page<UserFansVo> page) {

        List<TomatoUserEntity> list = baseMapper.getUserFansList(page, PrincipalUtils.getUsername());
        List<UserFansVo> retList = new ArrayList<>();
        //fixme 需要获取对应的粉丝状态/未下单用户/离开N天/赚取佣金额度
        if (list.size() > TomatoConstant.Common.NUMBER_0) {
            for (TomatoUserEntity tomatoUserEntity : list) {
                UserFansVo userFansVo = new UserFansVo();
                userFansVo.setUserInfo(getUserInfo(tomatoUserEntity));

                Date exitDate = tomatoUserEntity.getExitTime();

                int exitDay = 0;
                if (null == exitDate) {
                    exitDay = DateUtils.isNotOneDay(tomatoUserEntity.getLatelyLogin(), new Date());
                } else {
                    exitDay = DateUtils.isNotOneDay(tomatoUserEntity.getExitTime(), new Date());
                }

                //fixme 用户离开时间超过5天
                if (exitDay > TomatoConstant.Common.NUMBER_5) {
                    userFansVo.setExitDay(exitDay);
                }
                //FIXME 查询订单表

                List<OrderEntity> orderList = orderService.getOrderByUserName(tomatoUserEntity.getUsername());
                //fixme 未下单用户
                if (orderList.size() == TomatoConstant.Common.NUMBER_0) {
                    userFansVo.setStatus(TomatoConstant.Common.NUMBER_1);
                } else {//fixme 已下单用户，计算收益
                    userFansVo.setMoney(show(tomatoUserEntity));
                }

                retList.add(userFansVo);
            }

        }

        return page.setRecords(retList);
    }


    /**
     * 在日志中查询
     *
     * @param fansUser
     * @return
     */
    private BigDecimal show(TomatoUserEntity fansUser) {
        //邀请者的粉丝为邀请者贡献的收益应当从邀请者收益列表中取

        List<PropertyInviterLogEntity> list = propertyInviterLogService.getPropertyInviterList(PrincipalUtils.getUsername(), fansUser.getUsername());//邀请者，被邀请者

        if (list.size() == TomatoConstant.Common.NUMBER_0) {
            return new BigDecimal("0.00");
        }
        double money = 0;
        for (PropertyInviterLogEntity propertyLogEntity : list) {

            if (propertyLogEntity.getType() == TomatoConstant.Common.NUMBER_1) {
                money += propertyLogEntity.getCommission_money().doubleValue();
            }
        }
        return new BigDecimal(String.valueOf(money)).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public List<TomatoUserEntity> getUserFansList(String username) {
        return baseMapper.getUserFansListSize(username);
    }

    @Override
    public FriendsVo getFriendsVo() {

        List<TomatoUserEntity> list = baseMapper.getUserFansListSize(PrincipalUtils.getUsername());
        FriendsVo friendsVo = new FriendsVo();
        if (list.size() == TomatoConstant.Common.NUMBER_0) {
            friendsVo.setToday_fans(TomatoConstant.Common.NUMBER_0);
            friendsVo.setTotal_fans(TomatoConstant.Common.NUMBER_0);
            return friendsVo;
        }

        Date now = new Date();
        int today_fans = 0;
        for (TomatoUserEntity tomatoUserEntity : list) {

            if (DateUtils.isNotOneDay(tomatoUserEntity.getRegisterDate(), now) == TomatoConstant.Common.NUMBER_0) {

                today_fans += 1;
            }

        }

        friendsVo.setToday_fans(today_fans);
        friendsVo.setTotal_fans(list.size());
        return friendsVo;
    }

}
