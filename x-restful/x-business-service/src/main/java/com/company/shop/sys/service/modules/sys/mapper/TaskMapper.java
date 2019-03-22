package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.TaskEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TaskMapper extends BaseMapper<TaskEntity> {
    List<TaskEntity> getTask();

    TaskEntity getTaskConfig(@Param("category") int category, @Param("todayCount") int todayCount);
}
