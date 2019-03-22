package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.StepEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StepMapper extends BaseMapper<StepEntity> {
    List<StepEntity> getUserStep(@Param("username") String username);

    StepEntity getStepEntity(@Param("id") String id);

}
