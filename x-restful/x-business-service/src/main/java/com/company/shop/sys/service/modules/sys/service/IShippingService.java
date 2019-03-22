package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.modules.sys.entity.ShippingEntity;

import java.util.List;

public interface IShippingService {

    /**
     * 增加收货地址
     *
     * @param shippingInfo
     * @return
     */
    int addAddress(JSONObject json);

    /**
     * 删除收货人地址
     *
     * @return
     */
    int removeAddress(String shippingId);

    /***
     *修改当前用户的收货地址
     */
    int updateAddress(JSONObject json);


    /**
     * 设置为用户默认的收货地址
     *
     * @param shippingId
     * @return
     */
    int defaultAddress(String shippingId);

    /**
     * 获取用户默认收货地址
     *
     * @return
     */
    ShippingEntity getDefaultAddress();

    /**
     * 查询当前用户的所有收货地址
     *
     * @return
     */
    List<ShippingEntity> getUserAddress();

    /**
     * 根据物流id查询当前用户的物流信息
     *
     * @return
     */
    ShippingEntity getUserShipById(String shipoingId);

    /**
     * 查询当前用户有几个收货地址
     *
     * @return
     */
    int countAddress();
}
