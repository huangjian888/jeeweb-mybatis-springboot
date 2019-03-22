package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PacketSaleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PacketSaleMapper extends BaseMapper<PacketSaleEntity> {
    PacketSaleEntity getPacketSale(@Param("order_num") int order_num);

    List<PacketSaleEntity> getPacketList();
}
