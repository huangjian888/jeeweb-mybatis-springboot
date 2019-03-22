package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.moudle.entity.PacketUserEntity;
import com.company.business.goods.moudle.mapper.PacketUserMapper;
import com.company.business.goods.moudle.service.IPacketUserService;
import com.company.business.goods.utils.BigDecimalUtils;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;

@Service("packetUserService")
@Transactional
public class PacketUserServiceImpl extends ServiceImpl<PacketUserMapper, PacketUserEntity> implements IPacketUserService {
    @Override
    public HashMap getPacketUser(String username) {
        return baseMapper.getPacketUser(username);
    }

    /**
     * 打开红包
     *
     * @param money
     * @return
     */
    @Override
    public boolean openPacket(double money) {
        PacketUserEntity packetUserEntity = this.getPacketUserEntity(PrincipalUtils.getUsername());
        if (null == packetUserEntity) {
            packetUserEntity = new PacketUserEntity();
            packetUserEntity.setUser_name(PrincipalUtils.getUsername());
            packetUserEntity.setPacket_times(TomatoConstant.Common.NUMBER_1);
            packetUserEntity.setPacket_first_date(new Date());
            packetUserEntity.setPacket_amounts(BigDecimalUtils.mul(money, TomatoConstant.Common.NUMBER_1));
            return insertOrUpdate(packetUserEntity);
        } else if (null == packetUserEntity.getPacket_first_date()) {
            packetUserEntity.setPacket_first_date(new Date());
        }

        packetUserEntity.setPacket_recent_date(new Date());
        packetUserEntity.setPacket_times(packetUserEntity.getPacket_times() + TomatoConstant.Common.NUMBER_1);
        packetUserEntity.setPacket_amounts(BigDecimalUtils.add(packetUserEntity.getPacket_amounts().doubleValue(), money));

        return insertOrUpdate(packetUserEntity);
    }

    /**
     * 考虑是否加入红包领取日志
     * @param packetUserEntity
     * @return
     */

    @Override
    public boolean insertUpdatePacketUser(PacketUserEntity packetUserEntity) {
        return insertOrUpdate(packetUserEntity);
    }

    @Override
    public PacketUserEntity getPacketUserEntity(String username) {
        return baseMapper.getPacketUserEntity(username);
    }

}
