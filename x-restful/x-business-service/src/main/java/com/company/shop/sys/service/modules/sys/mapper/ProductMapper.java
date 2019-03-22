package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProductMapper extends BaseMapper<ProductEntity> {

    ProductEntity getProductDetails(@Param("productId") String productId);//查询商品详情

    ProductEntity getProduct(@Param("productId") String productId);//查询商品

    List<ProductEntity> getProductByCategory(Pagination page, @Param("pid") String pid);//查询商品；类别

    List<ProductEntity> getProductByName(Pagination page, @Param("prefix") String prefix);//


}
