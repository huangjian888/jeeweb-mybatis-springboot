package com.company.spring.boot.shardingsphere.seata.modules.service;

import com.baomidou.mybatisplus.service.IService;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderEntity;
import com.company.spring.boot.shardingsphere.seata.modules.entity.OrderItemEntity;


public interface IOrderItemService extends IService<OrderItemEntity> {
    void insertOrderItem(OrderItemEntity orderItemEntity);
}
