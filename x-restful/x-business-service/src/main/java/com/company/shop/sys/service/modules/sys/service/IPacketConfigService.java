package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.modules.sys.entity.PacketConfigEntity;

public interface IPacketConfigService {
    PacketConfigEntity getPacketConfiguration();
    boolean updatePacketConfig(JSONObject json);
}
