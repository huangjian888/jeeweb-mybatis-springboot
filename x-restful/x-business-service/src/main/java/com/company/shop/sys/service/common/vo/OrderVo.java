package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.OrderEntity;
import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import com.company.shop.sys.service.modules.sys.entity.ShippingEntity;
import lombok.Data;

@Data
public class OrderVo extends BaseVo {
    OrderEntity order;
    ShippingEntity ship;//订单详情中需要知道物流信息
    ProductEntity product;
    int errorCode;
}
