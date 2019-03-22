package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.PacketRuleEntity;

import java.util.List;

public interface IPacketRuleService {
    List<PacketRuleEntity> getPacketRuleList();
    boolean insertUpdate(JSONObject json);
    PacketRuleEntity getPackRuleEntity(int order);
}
