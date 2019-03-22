package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.moudle.entity.PacketLimitEntity;
import com.company.business.goods.moudle.mapper.PacketLimitMapper;
import com.company.business.goods.moudle.service.IPacketLimitService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service("packetLimitService")
@Transactional
public class PacketLimitServiceImpl extends ServiceImpl<PacketLimitMapper, PacketLimitEntity> implements IPacketLimitService {
    @Override
    public PacketLimitEntity getPacketLimitEntity() {

        return baseMapper.getPacketLimitEntity(TomatoConstant.Common.company_ADMIN);
    }

    @Override
    public boolean insertUpdate(JSONObject json) {


        String money = json.getString("money");
        String status = json.getString("status");
        if (TextUtils.isEmpty(money)) {
            return false;
        } else if (Double.valueOf(money) >= TomatoConstant.Common.NUMBER_20) {
            return false;
        }

        PacketLimitEntity packetLimitEntity = this.getPacketLimitEntity();
        if (null == packetLimitEntity) {
            packetLimitEntity = new PacketLimitEntity();
            packetLimitEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
            packetLimitEntity.setCreate_date(new Date());
            packetLimitEntity.setTotal_accruing_amounts(new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP));
            return insertOrUpdate(packetLimitEntity);
        }
        packetLimitEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
        packetLimitEntity.setUpdate_date(new Date());
        if (!TextUtils.isEmpty(status)) {
            packetLimitEntity.setStatus(Integer.parseInt(status));

        }
        packetLimitEntity.setTotal_accruing_amounts(new BigDecimal(money).setScale(2, BigDecimal.ROUND_HALF_UP));

        return insertOrUpdate(packetLimitEntity);
    }
}
