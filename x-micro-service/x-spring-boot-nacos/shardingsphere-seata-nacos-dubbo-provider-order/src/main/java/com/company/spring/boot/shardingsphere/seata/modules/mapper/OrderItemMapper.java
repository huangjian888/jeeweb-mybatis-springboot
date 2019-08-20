package com.company.spring.boot.shardingsphere.seata.modules.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderItemEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItemEntity> {
	
}