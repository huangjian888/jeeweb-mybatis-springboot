package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import lombok.Data;

@Data
public class OrderGenerateVo extends BaseVo {
    int errorCode;
    String order;
    ProductEntity product;
}
