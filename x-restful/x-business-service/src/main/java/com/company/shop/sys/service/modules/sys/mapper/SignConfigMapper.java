package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SignConfigMapper extends BaseMapper<SignConfigEntity> {

    List<SignConfigEntity> getSignConfiguration();

    SignConfigEntity getStep(@Param("day") int day);
}
