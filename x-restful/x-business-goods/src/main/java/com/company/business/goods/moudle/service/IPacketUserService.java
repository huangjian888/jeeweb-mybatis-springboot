package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.PacketUserEntity;

import java.util.HashMap;

/**
 * 用户的红包账户
 */
public interface IPacketUserService {
    HashMap getPacketUser(String username);

    boolean openPacket(double money);

    boolean insertUpdatePacketUser(PacketUserEntity packetUserEntity);

    PacketUserEntity getPacketUserEntity(String username);
}
