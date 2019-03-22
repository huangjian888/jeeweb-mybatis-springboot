package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.common.vo.StepVo;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.common.vo.TaskVo;
import com.company.shop.sys.service.modules.sys.entity.StepEntity;

import java.util.List;

public interface IHomeService {


    StepVo getGold(String id, int step);


    TaskVo getAllTask();

    /**
     * 主页任务点击
     *
     * @return
     */
    TaskInfoVo onTaskClick(String id, Integer category);

    List<StepEntity> getUserStep();

}
