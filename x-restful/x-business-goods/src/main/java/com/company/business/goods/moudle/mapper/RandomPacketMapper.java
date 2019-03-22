package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.RandomPacketEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RandomPacketMapper extends BaseMapper<RandomPacketEntity> {

    RandomPacketEntity getRandomByOrder(@Param("order") int order);

    List<RandomPacketEntity> getRandomPacket();
}
