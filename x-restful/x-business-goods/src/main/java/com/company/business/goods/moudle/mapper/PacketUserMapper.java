package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PacketUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;

@Mapper
public interface PacketUserMapper extends BaseMapper<PacketUserEntity> {

    HashMap getPacketUser(@Param("username") String username);

    PacketUserEntity getPacketUserEntity(@Param("username") String username);
}
