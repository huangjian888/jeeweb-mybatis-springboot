package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PacketLimitEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PacketLimitMapper extends BaseMapper<PacketLimitEntity> {

    PacketLimitEntity getPacketLimitEntity(@Param("username")String username);
}
