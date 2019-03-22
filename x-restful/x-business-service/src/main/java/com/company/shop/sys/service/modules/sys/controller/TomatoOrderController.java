package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.limit.redis.aspectj.annotation.Limit;
import com.company.manerger.sys.common.limit.redis.aspectj.enums.LimitType;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.OrderPageVo;
import com.company.shop.sys.service.common.vo.OrderVo;
import com.company.shop.sys.service.common.vo.ProductRecordVo;
import com.company.shop.sys.service.common.vo.WxPayVo;
import com.company.shop.sys.service.modules.sys.entity.OrderEntity;
import com.company.shop.sys.service.modules.sys.service.IOrderService;
import com.company.shop.sys.service.utils.PageUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/****
 *
 */
@RestController
public class TomatoOrderController extends BaseBeanController<OrderEntity> {

    @Autowired
    public IOrderService orderService;

    /**
     * 下单--创建订单
     * 地址信息--shippingId
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/order")
    public Response createOrder(@RequestBody JSONObject json) {

        WxPayVo wxPayVo = orderService.createOrder(json);
        if (wxPayVo.getErrorCode() == ErrorCodeEnum.ORDER2032.code()) {

            return Response.error(ErrorCodeEnum.ORDER2032.code(), ErrorCodeEnum.ORDER2032.msg());
        } else if (wxPayVo.getErrorCode() == ErrorCodeEnum.ORDER2031.code()) {

            return Response.error(ErrorCodeEnum.ORDER2031.code(), ErrorCodeEnum.ORDER2031.msg());
        } else if (wxPayVo.getErrorCode() == ErrorCodeEnum.ORDER2033.code()) {//一天只能兑换一次
            return Response.error(ErrorCodeEnum.ORDER2033.code(), ErrorCodeEnum.ORDER2033.msg());
        } else if (wxPayVo.getErrorCode() != BusinessConstant.Home.ZERO) {
            return Response.error(wxPayVo.getErrorCode(), ErrorCodeEnum.ORDER2031.msg());
        }

        return Response.ok().putObject(wxPayVo);
    }

    /**
     * 微信支付回调
     *
     * @param
     * @return
     */
    @PostMapping(value = "/pay/notify")
    public String notify(HttpServletRequest request, HttpServletResponse response) throws Exception {


        return orderService.wxPayNotify(request, response);
    }

    /**
     * 删除订单
     *
     * @param
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @DeleteMapping(value = "/order")
    public Response deleteOrder(@RequestBody JSONObject json) {
        String orderId = json.getString("orderId");

        return orderService.deleteOrder(orderId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.ORDER2020.code(), ErrorCodeEnum.ORDER2020.msg());
    }

    /**
     * 取消订单
     *
     * @param json
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PutMapping(value = "/order")
    public Response cancelOrder(@RequestBody JSONObject json) {
        String orderId = json.getString("orderId");
        return orderService.cancelOrder(orderId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.ORDER2021.code(), ErrorCodeEnum.ORDER2021.msg());
    }

    /**
     * 获取订单详情
     *
     * @param json
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/order/detail")
    public Response getOrderDetails(@RequestBody JSONObject json) {
        String orderId = json.getString("orderId");
        OrderVo orderVo = orderService.queryOrderDetails(orderId);
        if (null == orderVo) {
            return Response.error(ErrorCodeEnum.ORDER2022.code(), ErrorCodeEnum.ORDER2022.msg());
        }
        return Response.ok().putObject(orderVo);
    }

    /**
     * 获取用户的所有订单
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @GetMapping(value = "/order")
    public Response getAllOrder(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<OrderVo>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<OrderVo> pageList = orderService.queryAllOrder(pageEntity);
        List<OrderVo> list = pageList.getRecords();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.ORDER2023.code(), ErrorCodeEnum.ORDER2023.msg());
        }

        OrderPageVo orderPageVo = new OrderPageVo();
        orderPageVo.setList(list);
        orderPageVo.setTotal(pageList.getTotal());

        return Response.ok().putObject(orderPageVo);

    }

    /**
     * 根据类别查询当前用户的订单信息
     *
     * @param json
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/order/category")
    public Response getOrderByType(HttpServletRequest request, @RequestBody JSONObject json) {
        int category = json.getIntValue("category");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        Page pageEntity = new Page<OrderVo>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<OrderVo> pageList = orderService.queryAllOrderByType(pageEntity, category);
        List<OrderVo> list = pageList.getRecords();


        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.ORDER2023.code(), ErrorCodeEnum.ORDER2023.msg());
        }

        OrderPageVo orderPageVo = new OrderPageVo();
        orderPageVo.setList(list);
        orderPageVo.setTotal(pageList.getTotal());

        return Response.ok().putObject(orderPageVo);
    }

    /**
     * 商品的购买记录--查询到对应的用户
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/order/record")
    public Response getProductRecord(HttpServletRequest request, @RequestBody JSONObject json) {
        String productId = json.getString("productId");
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        Page pageEntity = new Page(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page pageList = orderService.getProductRecord(pageEntity, productId);
        List list = pageList.getRecords();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.COMMON9002.code(), ErrorCodeEnum.COMMON9002.msg());
        }

        ProductRecordVo productRecordVo = new ProductRecordVo();
        productRecordVo.setTotal(pageList.getTotal());
        productRecordVo.setList(list);


        return Response.ok().putObject(productRecordVo);
    }

    /**
     * 确认收货
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/order/complete")
    public Response comfirmOrder(@RequestBody JSONObject json) {
        String orderId = json.getString("orderId");
        if (TextUtils.isEmpty(orderId)) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }
        int result = orderService.comfirmOrder(orderId);
        if (result == BusinessConstant.Order.ORDER_4_NOT_PAY) {
            Response.error(ErrorCodeEnum.ORDER2026.code(), ErrorCodeEnum.ORDER2026.msg());
        }
        return result > 0 ? Response.ok() : Response.error(ErrorCodeEnum.ORDER2025.code(), ErrorCodeEnum.ORDER2025.msg());
    }
}
