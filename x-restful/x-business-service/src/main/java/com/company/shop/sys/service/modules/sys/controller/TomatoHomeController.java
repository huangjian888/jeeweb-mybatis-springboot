package com.company.shop.sys.service.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.limit.redis.aspectj.annotation.Limit;
import com.company.manerger.sys.common.limit.redis.aspectj.enums.LimitType;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.common.vo.StepVo;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.common.vo.TaskVo;
import com.company.shop.sys.service.modules.sys.entity.StepEntity;
import com.company.shop.sys.service.modules.sys.service.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/home")
public class TomatoHomeController {
    @Autowired
    private IHomeService homeService;

    /**
     * 获取运营配置步数兑换金币规则
     *
     * @return
     */
    @GetMapping(value = "/step")
    public Response getStep() {
        List<StepEntity> list = homeService.getUserStep();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.TASK1055.code(), ErrorCodeEnum.TASK1055.msg());
        }
        return Response.ok().putList(GlobalConstant.RESPONSE, list);
    }


    /**
     * 兑换金币
     * task
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/gold")
    public Response exchangeGold(@RequestBody JSONObject json) {
        String id = json.getString("id");
        int step = json.getIntValue("step");

        StepVo stepVo = homeService.getGold(id, step);
        if (null == stepVo) {
            return Response.error(ErrorCodeEnum.TASK1061.code(), ErrorCodeEnum.TASK1061.msg());
        }

        return Response.ok().putObject(stepVo);

    }


    /**
     * 获取用户未完成的任务
     *
     * @return
     */
    @GetMapping(value = "/task")
    public Response getAllTask() {
        TaskVo taskVo = homeService.getAllTask();
        if (null == taskVo) {
            return Response.error(ErrorCodeEnum.TASK1053.code(), ErrorCodeEnum.TASK1053.msg());
        }

        return Response.ok().putObject(taskVo);
    }

    /**
     * 主页面完成了相应的任务获取奖励
     *
     * @return
     */
    @PostMapping(value = "/task")
    public Response onTaskClick(@RequestBody JSONObject json) {
        int category = json.getIntValue("category");
        String id = json.getString("id");
        if (category == 0) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }
        TaskInfoVo taskInfoVo = homeService.onTaskClick(id, category);
        if (null == taskInfoVo) {
            return Response.error(ErrorCodeEnum.TASK1054.code(), ErrorCodeEnum.TASK1054.msg());
        }
        return Response.ok().putObject(taskInfoVo);
    }


}
