package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.common.vo.RandomPacketVo;
import com.company.business.goods.moudle.entity.RandomPacketEntity;
public interface IRandomPacketService {

    boolean insertRandomPack(JSONObject json);

    RandomPacketVo getRandomPacket();

    RandomPacketEntity getRandomByOrder(int order);
}
