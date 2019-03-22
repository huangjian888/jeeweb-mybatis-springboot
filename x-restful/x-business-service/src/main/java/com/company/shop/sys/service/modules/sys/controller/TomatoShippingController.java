package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.modules.sys.entity.ShippingEntity;
import com.company.shop.sys.service.modules.sys.service.IShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 物流地址管理类
 */
@RestController
@RequestMapping
public class TomatoShippingController extends BaseBeanController<ShippingEntity> {
    @Autowired
    private IShippingService shippingService;

    /**
     * 添加物流地址
     *
     * @param
     * @return
     */
    @PostMapping(value = "/address")
    public Response addAddress(@RequestBody JSONObject json) {

        int result = shippingService.addAddress(json);
        if (result > 0 && result < BusinessConstant.Shipping.LIMIT_ADDRESS) {
            return Response.ok();
        } else if (result == BusinessConstant.Shipping.LIMIT_ADDRESS) {
            return Response.error(ErrorCodeEnum.SHIPPING2009.code(), ErrorCodeEnum.SHIPPING2009.msg());
        }
        return Response.error(ErrorCodeEnum.SHIPPING2004.code(), ErrorCodeEnum.SHIPPING2004.msg());
    }

    /**
     * 修改物流地址
     *
     * @param
     * @return
     */
    @PutMapping(value = "/address")
    public Response updateAddress(@RequestBody JSONObject json) {

        int result = shippingService.updateAddress(json);
        if (result > 0) {
            return Response.ok();
        }
        return Response.error(ErrorCodeEnum.SHIPPING2005.code(), ErrorCodeEnum.SHIPPING2005.msg());

    }


    /**
     * 删除物流地址
     *
     * @param
     * @return
     */
    @DeleteMapping(value = "/address")
    public Response deleteAddress(@RequestBody JSONObject json) {

        int result = shippingService.removeAddress(json.getString("id"));
        if (result > 0) {
            return Response.ok();
        }
        return Response.error(ErrorCodeEnum.SHIPPING2006.code(), ErrorCodeEnum.SHIPPING2006.msg());
    }

    /**
     * 设置默认物流地址
     *
     * @param
     * @return
     */
    @PostMapping(value = "/address/default")
    public Response defaultAddress(@RequestBody JSONObject json) {
        int result = shippingService.defaultAddress(json.getString("id"));
        if (result > 0) {
            return Response.ok();
        }
        return Response.error(ErrorCodeEnum.SHIPPING2007.code(), ErrorCodeEnum.SHIPPING2007.msg());
    }

    /**
     * 获取用户的默认收货地址
     *
     * @return
     */
    @GetMapping(value = "/address/default")
    public Response getDefaultAddress() {
        ShippingEntity shippingEntity = shippingService.getDefaultAddress();
        if (null == shippingEntity) {
            return Response.error(ErrorCodeEnum.SHIPPING2010.code(), ErrorCodeEnum.SHIPPING2010.msg());
        }
        return Response.ok().putObject(shippingEntity);
    }

    /**
     * 获取用户的所有物流地址
     *
     * @return
     */
    @GetMapping(value = "/address")
    public Response getUserAllAdress() {
        List<ShippingEntity> list = shippingService.getUserAddress();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.SHIPPING2008.code(), ErrorCodeEnum.SHIPPING2008.msg());
        }
        return Response.ok().putList(GlobalConstant.RESPONSE, list);
    }


}
