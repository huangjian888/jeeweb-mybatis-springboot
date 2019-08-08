package com.company.spring.boot.shardingsphere.seata.modules.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.mapper.OrderMapper;
import com.company.spring.boot.shardingsphere.seata.modules.service.IOrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderEntity> implements IOrderService {

    @Override
    public void insertOrder(OrderEntity orderEntity) {
        baseMapper.insert(orderEntity);
    }
}
