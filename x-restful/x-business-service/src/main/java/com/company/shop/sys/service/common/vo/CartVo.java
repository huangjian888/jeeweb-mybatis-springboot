package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车返回信息类
 */

@Data
public class CartVo extends BaseVo {

    /**
     * 购物车中的商品集合信息
     */
    private List<ProductEntity> cartProductList;
    /**
     * 总价
     */
    private BigDecimal totalPrice;
    /**
     * 是否已经都勾选
     */
    private Boolean allChecked;

    /**
     * 购物车商品总数量
     */
    private int count;

}
