package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {

    List<OrderEntity> getOrderListByName(@Param("username") String username);

    OrderEntity getOrderById(@Param("orderId") String orderId);

    List<OrderEntity> getOrderComplete(@Param("username") String username, @Param("orderStatus") int orderStatus, @Param("upStatus") int upStatus);

}
