package com.company.shop.sys.service.modules.sys.service;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.shop.sys.service.common.vo.OrderVo;
import com.company.shop.sys.service.common.vo.WxPayVo;
import com.company.shop.sys.service.modules.sys.entity.OrderEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IOrderService {

    //创建订单
    WxPayVo createOrder(JSONObject json);


    //删除订单
    int deleteOrder(String orderId);

    //取消订单
    int cancelOrder(String orderId);

    //查询某一订单详情
    OrderVo queryOrderDetails(String orderId);

    //查询订单--内部使用
    OrderEntity queryOrder(String orderId);

    //查询用户所有订单
    Page<OrderVo> queryAllOrder(Page<OrderVo> page);

    //根据类别查询用户订单
    Page<OrderVo> queryAllOrderByType(Page<OrderVo> page, int type);

    //获取商品购买记录
    Page getProductRecord(Page page, String productId);

    //确认收货接口
    int comfirmOrder(String orderId);

    //支付回调接口
    String wxPayNotify(HttpServletRequest request, HttpServletResponse response) throws Exception;//微信支付结果回调
    //获取已发货的订单,type为已发货标示
    List<OrderEntity> getOrderList(int type);
    boolean updateOrder(OrderEntity orderEntity);

}
