package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PacketRuleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PacketRuleMapper extends BaseMapper<PacketRuleEntity> {
    List<PacketRuleEntity> getPacketRuleList();
    PacketRuleEntity getPackRuleEntity(@Param("order_num")int order_num);
}
