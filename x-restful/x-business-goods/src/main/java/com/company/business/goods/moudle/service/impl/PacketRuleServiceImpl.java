package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.moudle.entity.PacketRuleEntity;
import com.company.business.goods.moudle.mapper.PacketRuleMapper;
import com.company.business.goods.moudle.service.IPacketRuleService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
@Service("packetRuleService")
public class PacketRuleServiceImpl extends ServiceImpl<PacketRuleMapper, PacketRuleEntity> implements IPacketRuleService {
    @Override
    public List<PacketRuleEntity> getPacketRuleList() {
        return baseMapper.getPacketRuleList();
    }


    @Override
    public boolean insertUpdate(JSONObject json) {

        String accruingAmounts = json.getString("accruing_amounts");

        String order = json.getString("order");
        String lower = json.getString("lower");
        String upper = json.getString("upper");
        String status = json.getString("status");


        if (TextUtils.isEmpty(accruingAmounts) || TextUtils.isEmpty(lower) || TextUtils.isEmpty(upper)) {
            return false;
        }

        if (!TextUtils.isEmpty(order)) {
            PacketRuleEntity packetRuleEntity = this.getPackRuleEntity(Integer.parseInt(order));
            if (null == packetRuleEntity) {
                return false;
            }
            packetRuleEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
            packetRuleEntity.setUpdate_date(new Date());
            packetRuleEntity.setLower_limit_amounts(new BigDecimal(lower).setScale(2, BigDecimal.ROUND_HALF_UP));
            packetRuleEntity.setUpper_limit_amounts(new BigDecimal(upper).setScale(2, BigDecimal.ROUND_HALF_UP));
            packetRuleEntity.setAccruing_amounts(new BigDecimal(accruingAmounts).setScale(2, BigDecimal.ROUND_HALF_UP));
            if (!TextUtils.isEmpty(status)) {
                packetRuleEntity.setStatus(Integer.parseInt(status));
            }
            return insertOrUpdate(packetRuleEntity);

        } else {
            PacketRuleEntity packetRuleEntity = new PacketRuleEntity();
            packetRuleEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
            packetRuleEntity.setCreate_date(new Date());
            packetRuleEntity.setLower_limit_amounts(new BigDecimal(lower).setScale(2, BigDecimal.ROUND_HALF_UP));
            packetRuleEntity.setUpper_limit_amounts(new BigDecimal(upper).setScale(2, BigDecimal.ROUND_HALF_UP));
            packetRuleEntity.setAccruing_amounts(new BigDecimal(accruingAmounts).setScale(2, BigDecimal.ROUND_HALF_UP));
            return insertOrUpdate(packetRuleEntity);
        }


    }

    @Override
    public PacketRuleEntity getPackRuleEntity(int order) {
        return baseMapper.getPackRuleEntity(order);
    }
}
