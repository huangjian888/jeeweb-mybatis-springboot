package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PropertyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PropertyMapper extends BaseMapper<PropertyEntity> {

    PropertyEntity getProperty(@Param("username") String username);

    boolean updateProperty(@Param("username") String username, @Param("commissionAble") double commissionAble, @Param("commissionBack") double commissionBack);

    boolean updatePropertyNoAble(@Param("username") String username, @Param("commissionBack") double commissionBack);
}
