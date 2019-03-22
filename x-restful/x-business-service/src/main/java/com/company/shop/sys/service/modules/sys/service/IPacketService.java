package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.PacketEntity;

public interface IPacketService {

    PacketEntity getPacket();

    TaskInfoVo receivePacket();

    int updateTable(PacketEntity packetEntity);
}
