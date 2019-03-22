package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.PacketInviteLogEntity;
import com.company.business.goods.moudle.mapper.PacketInviteLogMapper;
import com.company.business.goods.moudle.service.IPacketInviteLogService;

import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("packetInviteLogService")
public class PacketInviteLogServiceImpl extends ServiceImpl<PacketInviteLogMapper, PacketInviteLogEntity> implements IPacketInviteLogService {

    @Override
    public boolean insertUpdateLog(PacketInviteLogEntity packetInviteLogEntity) {
        return insertOrUpdate(packetInviteLogEntity);
    }

    @Override
    public Page getFriendPacketVoList(Page page) {
        return page.setRecords(baseMapper.getPacketInviteLogList(page, PrincipalUtils.getUsername()));
    }

}
