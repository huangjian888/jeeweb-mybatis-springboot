package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.shop.sys.service.modules.sys.entity.OrderEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseMapper<OrderEntity> {


    int deleteOrder(@Param("username") String username, @Param("orderId") String orderId, @Param("cancel") int cancel, @Param("complete") int complete);

    OrderEntity getOrder(@Param("username") String username, @Param("orderId") String orderId);

    List<OrderEntity> getAllOrder(Pagination page, @Param("username") String username);

    List<OrderEntity> getAllOrderByType(Pagination page, @Param("username") String username, @Param("status") int status);

    List<OrderEntity> getProductRecord(Pagination page, @Param("productId") String productId);

    int comfirmOrder(@Param("username") String username, @Param("orderId") String orderId, @Param("status") int status);

    List<OrderEntity> getOrderList(@Param("type")int type);
}
