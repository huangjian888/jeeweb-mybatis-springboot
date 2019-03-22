package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.vo.CartVo;
import com.company.shop.sys.service.modules.sys.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 支持购物车的操作：查询购物车商品、添加到购物车、删除购物车指定商品
 */
@RestController
@RequestMapping(value = "/cart")
public class CartController {


    @Autowired
    private ICartService cartService;

    /**
     * 查询购物车中的商品
     *
     * @return
     */
    @GetMapping(value = "/goods")
    public Response getGoodsInCart() {

        CartVo cartVo = cartService.getGoodsInCart();

        if (null == cartVo) {//购物车是空的哦

            return Response.error(ErrorCodeEnum.CART4001.code(), ErrorCodeEnum.CART4001.msg());
        }
        return Response.ok().putObject(cartVo);

    }

    /**
     * 添加商品到购物车
     *
     * @param
     * @return
     */
    @PostMapping(value = "/goods")
    public Response addGoodsInCart(@RequestBody JSONObject json) {
        return cartService.addGoodsInCart(json) ? Response.ok() : Response.error(ErrorCodeEnum.CART4002.code(), ErrorCodeEnum.CART4002.msg());
    }

    /**
     * 删除指定商品
     * 商品id
     *
     * @param
     * @return
     */
    @DeleteMapping(value = "/goods")
    public Response removeGoodsFromCart(@RequestBody String goodsId) {

        return cartService.removeGoodsFromCart(goodsId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.CART4003.code(), ErrorCodeEnum.CART4003.msg());
    }

    /**
     * 商品是否被选中状态的保存
     *
     * @param json
     * @return
     */
    @PostMapping(value = "/status")
    public Response updateCheckStatus(@RequestBody JSONObject json) {

        return cartService.selectCheckedStatus(json) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.CART4004.code(), ErrorCodeEnum.CART4004.msg());
    }

    /**
     * 更新购物车信息--数量
     *
     * @param json
     * @return
     */
    @PostMapping(value = "/count")
    public Response updateCartInfo(@RequestBody JSONObject json) {

        return cartService.updateCart(json) ? Response.ok() : Response.error(ErrorCodeEnum.CART4005.code(), ErrorCodeEnum.CART4005.msg());
    }
}
