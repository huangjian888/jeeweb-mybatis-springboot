package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.PacketLimitEntity;

public interface IPacketLimitService {

    PacketLimitEntity getPacketLimitEntity();
    boolean insertUpdate(JSONObject json);
}
