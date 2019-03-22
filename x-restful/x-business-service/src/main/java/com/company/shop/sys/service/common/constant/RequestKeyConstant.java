package com.company.shop.sys.service.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RequestKeyConstant {

    /***
     * 购物车键值
     */
    public interface Cart {

        String PRODUCT_ID = "productId";//商品id
        String CHECKED_STATUS = "checked";//当前商品的选择状态
        String USER_ID = "userId";//用户id
        String COUNT = "count";//商品数量

    }
}
