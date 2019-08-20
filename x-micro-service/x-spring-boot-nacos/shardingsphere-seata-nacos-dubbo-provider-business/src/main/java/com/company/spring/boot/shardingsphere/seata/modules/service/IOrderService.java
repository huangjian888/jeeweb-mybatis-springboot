package com.company.spring.boot.shardingsphere.seata.modules.service;

import com.baomidou.mybatisplus.service.IService;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;


public interface IOrderService extends IService<OrderEntity> {
    void insertOrder(OrderEntity orderEntity);
}
