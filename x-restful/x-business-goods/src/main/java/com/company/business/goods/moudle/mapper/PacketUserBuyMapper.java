package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PacketUserBuyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PacketUserBuyMapper extends BaseMapper<PacketUserBuyEntity> {

    PacketUserBuyEntity getPacketUserBuy(@Param("username") String username);
}
