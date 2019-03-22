package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import lombok.Data;

import java.util.List;

@Data
public class ProductPageVo extends BaseVo {
    List<ProductEntity> list;
    long total;
}
