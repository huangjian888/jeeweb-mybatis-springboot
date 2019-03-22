package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.ProductCateGoryEntity;
import com.company.shop.sys.service.modules.sys.mapper.ProductCateGoryMapper;
import com.company.shop.sys.service.modules.sys.service.IProductCateGoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productCateGoryService")
public class ProductCateGoryServiceImpl extends ServiceImpl<ProductCateGoryMapper, ProductCateGoryEntity> implements IProductCateGoryService {


    @Override
    public List<ProductCateGoryEntity> getProductCateGory() {
        return baseMapper.getProductCategory();
    }


}
