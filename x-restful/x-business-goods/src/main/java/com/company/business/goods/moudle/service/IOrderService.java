package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.OrderEntity;

import java.util.List;

public interface IOrderService {

    boolean insertOrder(JSONObject json);

    OrderEntity getOrderById(String orderId);

    List<OrderEntity> getOrderByUserName(String username);

    List<OrderEntity> getOrderComplete(String username);
}
