package com.company.shop.sys.service.modules.sys.service;


import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.common.vo.CartVo;
import com.company.shop.sys.service.modules.sys.entity.CartInfo;


public interface ICartService {

    /**
     * 查询购物车中的商品param request:username
     *
     * @return
     */
    CartVo getGoodsInCart();

    boolean addGoodsInCart(JSONObject json);

    boolean updateCart(JSONObject json);

    int removeGoodsFromCart(String goodsId);


    CartInfo getCartByProductId(String productId);

    /**
     * 当商品被选择或反选的状态更新
     *
     * @return
     */
    int selectCheckedStatus(JSONObject json);


}
