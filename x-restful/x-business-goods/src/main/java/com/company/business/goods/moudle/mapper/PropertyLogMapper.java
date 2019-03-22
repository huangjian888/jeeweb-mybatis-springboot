package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.business.goods.moudle.entity.PropertyLogEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PropertyLogMapper extends BaseMapper<PropertyLogEntity> {
    List<PropertyLogEntity> getPropertyLogList(@Param("username") String username);

    PropertyLogEntity getPropertyLog(@Param("username") String username,@Param("order_no") String order_no);
}
