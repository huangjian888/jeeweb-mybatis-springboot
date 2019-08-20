package com.company.spring.boot.shardingsphere.seata.modules.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.mapper.OrderMapper;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {

    @Override
    public void insertOrder(OrderEntity orderEntity) {
        System.out.println("XID:"+ RootContext.getXID());
        baseMapper.insert(orderEntity);
    }
}
