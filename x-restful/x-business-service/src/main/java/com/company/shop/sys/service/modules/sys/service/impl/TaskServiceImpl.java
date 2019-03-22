package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.TaskEntity;
import com.company.shop.sys.service.modules.sys.mapper.TaskMapper;
import com.company.shop.sys.service.modules.sys.service.ITaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("taskService")
public class TaskServiceImpl extends ServiceImpl<TaskMapper, TaskEntity> implements ITaskService {
    @Override
    public List<TaskEntity> getTask() {
        return baseMapper.getTask();
    }

    @Override
    public TaskEntity getTaskConfig(int category, int todayCount) {
        return baseMapper.getTaskConfig(category, todayCount);
    }
}
