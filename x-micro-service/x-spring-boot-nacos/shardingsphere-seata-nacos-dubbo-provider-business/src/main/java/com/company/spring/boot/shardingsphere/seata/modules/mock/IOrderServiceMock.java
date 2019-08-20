package com.company.spring.boot.shardingsphere.seata.modules.mock;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.mapper.OrderMapper;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderService;

public class IOrderServiceMock extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {
    @Override
    public void insertOrder(OrderEntity orderEntity) {
        System.out.println("OrderService RpcException");
    }
}
