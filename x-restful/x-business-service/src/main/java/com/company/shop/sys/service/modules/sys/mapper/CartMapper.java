package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.CartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CartMapper extends BaseMapper<CartInfo> {
    List<CartInfo> getGoodsInCart(@Param("username") String username);

    CartInfo getCartByProductId(@Param("username") String username, @Param("productId") String productId);//根据当前的商品id查询购物车情况

    int getCheckedStatus(@Param("username") String username);

    int removeGoodsFromCart(@Param("username") String username, @Param("productId") String productId);

    int selectCheckedStatus(@Param("username") String username, @Param("productId") String productId, @Param("status") int status);


}
