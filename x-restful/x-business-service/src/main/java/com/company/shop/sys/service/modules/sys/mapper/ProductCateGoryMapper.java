package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.ProductCateGoryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductCateGoryMapper extends BaseMapper<ProductCateGoryEntity> {
    List<ProductCateGoryEntity> getProductCategory();
}
