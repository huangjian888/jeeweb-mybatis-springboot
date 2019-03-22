package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.PacketUserBuyEntity;
import com.company.business.goods.moudle.mapper.PacketUserBuyMapper;
import com.company.business.goods.moudle.service.IPacketUserBuyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service("packetUserBuyService")
@Transactional
public class PacketUserBuyServiceImpl extends ServiceImpl<PacketUserBuyMapper, PacketUserBuyEntity> implements IPacketUserBuyService {

    @Override
    public PacketUserBuyEntity getPacketUserBuy(String username) {
        return baseMapper.getPacketUserBuy(username);
    }

    @Override
    public boolean insertUpdatePacketUserBuy(PacketUserBuyEntity packetUserBuyEntity) {

        return insertOrUpdate(packetUserBuyEntity);
    }
}
