package com.company.business.goods.moudle.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.company.business.goods.moudle.entity.PacketInviteLogEntity;

public interface IPacketInviteLogService {
    boolean insertUpdateLog(PacketInviteLogEntity packetInviteLogEntity);


    Page getFriendPacketVoList(Page page);

}
