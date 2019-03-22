package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.BuyLimitEntity;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface BuyLimitMapper extends BaseMapper<BuyLimitEntity> {
    BuyLimitEntity getLimit(String username);

}
