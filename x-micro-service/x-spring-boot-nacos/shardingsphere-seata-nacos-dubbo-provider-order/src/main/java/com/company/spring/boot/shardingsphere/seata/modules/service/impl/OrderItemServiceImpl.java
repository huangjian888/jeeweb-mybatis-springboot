package com.company.spring.boot.shardingsphere.seata.modules.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderItemEntity;
import com.company.spring.boot.shardingsphere.seata.modules.mapper.OrderItemMapper;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderItemService;
import org.springframework.stereotype.Service;

@Service
public class OrderItemServiceImpl extends ServiceImpl<OrderItemMapper, OrderItemEntity> implements IOrderItemService {

    @Override
    public void insertOrderItem(OrderItemEntity orderItemEntity) {
        baseMapper.insert(orderItemEntity);
    }
}
