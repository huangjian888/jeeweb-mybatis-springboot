package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.DailyTaskEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DailyTaskMapper extends BaseMapper<DailyTaskEntity> {

    /**
     * 获取用户的任务列表
     *
     * @return
     */
    List<DailyTaskEntity> getUserTskList();
}
