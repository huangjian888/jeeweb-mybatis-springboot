package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.moudle.entity.PacketCommissionEntity;
import com.company.business.goods.moudle.mapper.PacketCommissionMapper;
import com.company.business.goods.moudle.service.IPacketCommissionService;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
@Service("packetCommissionService")
public class PacketCommissionServiceImpl extends ServiceImpl<PacketCommissionMapper, PacketCommissionEntity> implements IPacketCommissionService {


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

        if (!TextUtils.isEmpty(order)) {
            PacketCommissionEntity packetCommissionEntity = baseMapper.getPacketCommission(Integer.parseInt(order));
            if (null == packetCommissionEntity) {
                return false;
            }
            packetCommissionEntity.setUpdate_by(TomatoConstant.Common.company_ADMIN);
            packetCommissionEntity.setUpdate_date(new Date());
            packetCommissionEntity.setRate(rate);
            packetCommissionEntity.setLower_fans(Integer.parseInt(lower));
            if (!TextUtils.isEmpty(upper)) {
                packetCommissionEntity.setUpper_fans(Integer.parseInt(upper));
            }
            if (!TextUtils.isEmpty(status)) {
                packetCommissionEntity.setStatus(Integer.parseInt(status));
            }

            return insertOrUpdate(packetCommissionEntity);

        } else {
            PacketCommissionEntity packetCommissionEntity = new PacketCommissionEntity();
            packetCommissionEntity.setCreate_by(TomatoConstant.Common.company_ADMIN);
            packetCommissionEntity.setCreate_date(new Date());
            packetCommissionEntity.setLower_fans(Integer.parseInt(lower));
            if (!TextUtils.isEmpty(upper)) {
                packetCommissionEntity.setUpper_fans(Integer.parseInt(upper));
            }
            if (!TextUtils.isEmpty(status)) {
                packetCommissionEntity.setStatus(Integer.parseInt(status));
            }
            packetCommissionEntity.setRate(rate);
            return insertOrUpdate(packetCommissionEntity);
        }


    }

    @Override
    public List<PacketCommissionEntity> getPacketCommissionList() {

        return baseMapper.getPacketCommissionList();
    }
}
