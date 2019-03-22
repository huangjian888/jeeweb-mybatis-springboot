package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.ShippingEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShippingMapper extends BaseMapper<ShippingEntity> {

    //删除指定的收货地址
    int removeAddress(@Param("username") String username, @Param("shippingId") String shippingId);

    //获取当前的默认收货地址信息
    ShippingEntity getCurrentDefaultAddress(@Param("username") String username);

    //设置当前id为默认收货地址
    int setDefaultAddress(@Param("username") String username, @Param("shippingId") String shippingId);

    ShippingEntity getShipById(@Param("username") String username, @Param("shippingId") String shippingId);

    List<ShippingEntity> getAllAdress(@Param("username") String username);

    int countAddress(@Param("username") String username);

    ShippingEntity getDefaultAddress(@Param("username") String username);
}
