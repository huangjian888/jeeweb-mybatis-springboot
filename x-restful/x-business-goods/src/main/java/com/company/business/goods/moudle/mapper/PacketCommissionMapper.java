package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PacketCommissionEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PacketCommissionMapper extends BaseMapper<PacketCommissionEntity> {

    List<PacketCommissionEntity> getPacketCommissionList();

    PacketCommissionEntity getPacketCommission(@Param("order_num") int order_num);
}
