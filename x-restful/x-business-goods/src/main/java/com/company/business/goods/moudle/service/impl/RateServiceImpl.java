package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.vo.PacketCommissionVo;
import com.company.business.goods.common.vo.RateVo;
import com.company.business.goods.moudle.entity.PacketCommissionEntity;
import com.company.business.goods.moudle.entity.PacketUserBuyEntity;
import com.company.business.goods.moudle.entity.RateEntity;
import com.company.business.goods.moudle.mapper.RateMapper;
import com.company.business.goods.moudle.service.IPacketCommissionService;
import com.company.business.goods.moudle.service.IPacketUserBuyService;
import com.company.business.goods.moudle.service.IRateService;
import com.company.business.goods.moudle.service.ITomatoCouponUserService;
import com.company.business.goods.security.user.TomatoUserEntity;
import com.company.business.goods.utils.PrincipalUtils;
import com.company.business.goods.utils.RedisCacheUtils;
import com.company.business.goods.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("rateService")
@Transactional
public class RateServiceImpl extends ServiceImpl<RateMapper, RateEntity> implements IRateService {

    @Autowired
    private ITomatoCouponUserService tomatoCouponUserService;

    @Autowired
    private IPacketCommissionService packetCommissionService;//粉丝下单的动态佣金比例配置

    @Autowired
    private IPacketUserBuyService packetUserBuyService;//用户的购买表情况


    private List<PacketCommissionEntity> getList() {

        PacketCommissionVo pcketCommissionVo = (PacketCommissionVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getPacketOrderKey());


        if (null == pcketCommissionVo) {

            List<PacketCommissionEntity> commissionList = packetCommissionService.getPacketCommissionList();//用户下单数量配置
            if (commissionList.size() > TomatoConstant.Common.NUMBER_0) {//规则为list size 0，返回null
                pcketCommissionVo = new PacketCommissionVo();
                pcketCommissionVo.setList(commissionList);
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getPacketOrderKey(), pcketCommissionVo, TomatoConstant.Common.EXPIRE_TIME_REDIS_1800);//半小时
                return commissionList;
            }
            return null;
        }

        return pcketCommissionVo.getList();

    }

    /**
     * 三期更改--分享赚根据当前用户的粉丝下单数来动态获取金额
     *
     * @return
     */
    @Override
    public RateVo getRate() {

        int sum = 0;
        //fixme 获取当前用户的粉丝人数--获取到粉丝人数中的下单人数,用户粉丝可能存在为0的情况，返回的邀请赚的比例应按配置的最大的来
        List<TomatoUserEntity> inviteList = tomatoCouponUserService.getUserFansList(PrincipalUtils.getUsername());

        List<PacketCommissionEntity> commissionList = getList();//用户下单数量配置
        RateVo rateVo = new RateVo();

        if (inviteList.size() == TomatoConstant.Common.NUMBER_0) {//fixme 当前用户没有邀请者
            rateVo.setRate(commissionList.get(TomatoConstant.Common.NUMBER_0).getRate());
            return rateVo;
        }


        for (TomatoUserEntity user : inviteList) {
            PacketUserBuyEntity packetUserBuyEntity = packetUserBuyService.getPacketUserBuy(user.getUsername());
            if (null == packetUserBuyEntity) {
                continue;
            } else if (packetUserBuyEntity.getBuy_times() > 0) {
                sum += packetUserBuyEntity.getBuy_times();
            }
        }

        //邀请者邀请粉丝佣金比例配置
        for (PacketCommissionEntity packet : commissionList) {
            if (sum > packet.getLower_fans() && sum <= packet.getUpper_fans()) {
                rateVo.setRate(packet.getRate());
                return rateVo;
            } else if (sum > packet.getLower_fans() && TomatoConstant.Common.NUMBER_0 == packet.getUpper_fans()) {//最后一个,upper为null，构造为0
                rateVo.setRate(packet.getRate());
                return rateVo;
            }

        }
        //fixme 当前有邀请者，但是没有邀请者下单,默认获取第0个返回佣金比例
        rateVo.setRate(commissionList.get(TomatoConstant.Common.NUMBER_0).getRate());
        return rateVo;
    }


    @Override
    public boolean insertRateEntity(JSONObject json) {


        String normal_buy_rate = json.getString("normal_buy_rate");
        String first_buy_rate = json.getString("first_buy_rate");
        String invite_first_buy_rate = json.getString("invite_first_buy_rate");
        String invite_user_return_rate = json.getString("invite_user_return_rate");

        String invite_user_promote = json.getString("invite_user_promote");
        String invite_user_return = json.getString("invite_user_return");

        String remarks = json.getString("remarks");


        RateEntity rateEntity = this.getRateEntity();
        if (null == rateEntity) {
            rateEntity = new RateEntity();
            rateEntity.setCreate_date(new Date());
            rateEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
        } else {
            rateEntity.setUpdate_date(new Date());
            rateEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
        }

        if (!TextUtils.isEmpty(normal_buy_rate)) {
            rateEntity.setNormal_buy_rate(new BigDecimal(normal_buy_rate));
        }
        if (!TextUtils.isEmpty(first_buy_rate)) {
            rateEntity.setFirst_buy_rate(new BigDecimal(first_buy_rate));
        }
        if (!TextUtils.isEmpty(invite_first_buy_rate)) {
            rateEntity.setInvite_first_buy_rate(new BigDecimal(invite_first_buy_rate));
        }
        if (!TextUtils.isEmpty(invite_user_return_rate)) {
            rateEntity.setInvite_user_return_rate(new BigDecimal(invite_user_return_rate));
        }
        if (!TextUtils.isEmpty(invite_user_promote)) {
            rateEntity.setInvite_user_promote(Integer.parseInt(invite_user_promote));
        }
        if (!TextUtils.isEmpty(invite_user_return)) {
            rateEntity.setInvite_user_return(Integer.parseInt(invite_user_return));
        }
        rateEntity.setRemarks(remarks);


        return insertOrUpdate(rateEntity);
    }

    @Override
    public RateEntity getRateEntity() {

        return baseMapper.getRateEntity(TomatoConstant.Common.company_ADMIN);
    }

}
