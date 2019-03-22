package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import com.company.shop.sys.service.modules.sys.mapper.ProductMapper;
import com.company.shop.sys.service.modules.sys.service.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productServiceService")
public class ProductServiceServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements IProductService {


    /**
     * 查询商品详情
     *
     * @param id
     * @return
     */

    @Override
    public ProductEntity getProductDetails(String id) {


        ProductEntity productEntity = baseMapper.getProductDetails(id);
        if (null == productEntity) {
            return null;
        }

        /*ProductDetailsEntity productDetailsEntity = productDetailsService.getProductDetail(productEntity.getId());
        if (null != productDetailsEntity) {
            productVo.setSpecification(productDetailsEntity);

        }*/

        return productEntity;

    }

    /**
     * 购物车中的商品使用
     *
     * @param id
     * @return
     */
    @Override
    public ProductEntity getProduct(String id) {
        return baseMapper.getProduct(id);
    }

    /**
     * 更新商品库存
     *
     * @param num:单次购买数量
     * @return
     */

    @Override
    public int updateProduct(String id, int num) {

        ProductEntity productEntity = baseMapper.getProductDetails(id);
        productEntity.setInventory(productEntity.getInventory() - num);//库存
        return insertOrUpdate(productEntity) ? 1 : 0;
    }

    /**
     * 主页面商品展示
     *
     * @param pid
     * @return
     */
    @Override
    public Page<ProductEntity> getProductByCategory(Page<ProductEntity> page, String pid) {
        return page.setRecords(baseMapper.getProductByCategory(page, pid));


    }

    /**
     * 搜索商品
     *
     * @param prefix
     * @return
     */
    @Override
    public Page<ProductEntity> getProductByName(Page<ProductEntity> page, String prefix) {
        return page.setRecords(baseMapper.getProductByName(page, prefix));
    }

    /**
     * 获取推荐商品
     *
     * @return
     */
    @Override
    public List<ProductEntity> getRecommend() {
        return null;
    }

    @Override
    public boolean updateProduct(ProductEntity productEntity) {

        return insertOrUpdate(productEntity);
    }


}
