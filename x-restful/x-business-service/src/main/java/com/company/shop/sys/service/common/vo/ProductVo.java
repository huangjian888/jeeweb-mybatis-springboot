package com.company.shop.sys.service.common.vo;


import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import lombok.Data;

/**
 * 商品详情表
 */
@Data
public class ProductVo extends BaseVo {

    ProductEntity entity;
    long total;
}
