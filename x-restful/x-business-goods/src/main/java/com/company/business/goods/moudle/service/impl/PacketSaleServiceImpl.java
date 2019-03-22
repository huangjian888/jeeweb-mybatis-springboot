package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.moudle.entity.PacketSaleEntity;
import com.company.business.goods.moudle.mapper.PacketSaleMapper;
import com.company.business.goods.moudle.service.IPacketSaleService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
@Service("packetSaleService")
public class PacketSaleServiceImpl extends ServiceImpl<PacketSaleMapper, PacketSaleEntity> implements IPacketSaleService {


    @Override
    public boolean insertUpdateConfig(JSONObject json) {
        String order = json.getString("order");
        String lower = json.getString("lower");
        String upper = json.getString("upper");
        int rate = json.getIntValue("rate");
        String status = json.getString("status");

        if (TextUtils.isEmpty(lower)) {
            return false;
        }
        if (!TextUtils.isEmpty(order)) {//order不为""即为更新
            PacketSaleEntity packetSaleEntity = baseMapper.getPacketSale(Integer.parseInt(order));

            if (null == packetSaleEntity) {
                return false;
            }


            packetSaleEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
            packetSaleEntity.setUpdate_date(new Date());
            packetSaleEntity.setRate(rate);
            if (!TextUtils.isEmpty(status)) {
                packetSaleEntity.setStatus(Integer.parseInt(status));
            }

            if (!TextUtils.isEmpty(lower)) {
                packetSaleEntity.setLower_limit_amounts(new BigDecimal(lower).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            if (!TextUtils.isEmpty(upper)) {
                packetSaleEntity.setUpper_limit_amounts(new BigDecimal(upper).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            return insertOrUpdate(packetSaleEntity);

        } else {

            PacketSaleEntity packetSaleEntity = new PacketSaleEntity();
            packetSaleEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
            packetSaleEntity.setCreate_date(new Date());

            packetSaleEntity.setRate(rate);
            if (!TextUtils.isEmpty(lower)) {
                packetSaleEntity.setLower_limit_amounts(new BigDecimal(lower).setScale(2, BigDecimal.ROUND_HALF_UP));
            }

            if (!TextUtils.isEmpty(upper)) {
                packetSaleEntity.setUpper_limit_amounts(new BigDecimal(upper).setScale(2, BigDecimal.ROUND_HALF_UP));
            }
            return insertOrUpdate(packetSaleEntity);
        }

    }

    @Override
    public List<PacketSaleEntity> getPacketSaleList() {

        return baseMapper.getPacketList();
    }
}
