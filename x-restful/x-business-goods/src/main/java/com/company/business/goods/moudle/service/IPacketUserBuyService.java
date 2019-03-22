package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.PacketUserBuyEntity;

/**
 * 用户的红包账户
 */
public interface IPacketUserBuyService {
    PacketUserBuyEntity getPacketUserBuy(String username);

    boolean insertUpdatePacketUserBuy(PacketUserBuyEntity packetUserBuyEntity);
}
