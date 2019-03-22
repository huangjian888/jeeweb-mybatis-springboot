package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.modules.sys.entity.TaskEntity;

import java.util.List;

public interface ITaskService {

    List<TaskEntity> getTask();

    TaskEntity getTaskConfig(int category, int todayCount);
}
