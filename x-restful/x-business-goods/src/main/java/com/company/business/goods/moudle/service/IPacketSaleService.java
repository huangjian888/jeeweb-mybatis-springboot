package com.company.business.goods.moudle.service;


import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.PacketSaleEntity;

import java.util.List;

public interface IPacketSaleService {
    boolean insertUpdateConfig(JSONObject json);

    List<PacketSaleEntity> getPacketSaleList();
}
