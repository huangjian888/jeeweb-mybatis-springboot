package com.company.business.goods.moudle.service;


import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.PacketCommissionEntity;

import java.util.List;

public interface IPacketCommissionService {
    boolean insertUpdateConfig(JSONObject json);

    List<PacketCommissionEntity> getPacketCommissionList();
}
