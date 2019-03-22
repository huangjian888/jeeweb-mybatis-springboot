package com.company.shop.sys.service.modules.sys.service;


import com.baomidou.mybatisplus.plugins.Page;
import com.company.shop.sys.service.modules.sys.entity.ProductEntity;

import java.util.List;

/**
 * 商品服务
 */
public interface IProductService {

    /**
     * 商品详情
     *
     * @param id
     * @return
     */
    ProductEntity getProductDetails(String id);


    /**
     * 获取商品信息
     *
     * @param id
     * @return
     */
    ProductEntity getProduct(String id);

    /**
     * 更新商品库存
     *
     * @param
     * @return
     */
    int updateProduct(String id, int num);

    /**
     * 根据分类类别查询对应类别下的商品分类类别
     *
     * @param pid
     * @return
     */
    Page<ProductEntity> getProductByCategory(Page<ProductEntity> page, String pid);

    /**
     * 搜索商品
     *
     * @param productName
     * @return
     */
    Page<ProductEntity> getProductByName(Page<ProductEntity> page, String productName);


    /**
     * 获取推荐商品
     *
     * @return
     */
    List<ProductEntity> getRecommend();

    boolean updateProduct(ProductEntity productEntity);


}
