package com.company.shop.sys.service.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.limit.redis.aspectj.annotation.Limit;
import com.company.manerger.sys.common.limit.redis.aspectj.enums.LimitType;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.common.vo.SignVo;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.SignEntity;
import com.company.shop.sys.service.modules.sys.service.ISignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 签到--第七天重置为0
 */
@RestController
public class TomatoSignController extends BaseBeanController<SignEntity> {
    @Autowired
    private ISignService signService;

    /**
     * 设置签到自动提醒1--开启 0关闭,前端埋点每日注册
     *
     * @return
     */
    @PostMapping(value = "/sign")
    public Response setAlert(@RequestBody JSONObject json) {
        int category = json.getIntValue("category");

        int result = signService.setAlert(category);

        if (result > 0) {
            return Response.ok();
        }
        return Response.error(ErrorCodeEnum.TASK1052.code(), ErrorCodeEnum.TASK1052.msg());
    }


    /**
     * 获取用户今日签到信息用于个人界面显示
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @GetMapping(value = "/sign")
    public Response getSign() {

        SignVo signVo = signService.getSign();
        if (null == signVo) {//今日未签到
            Response.error(ErrorCodeEnum.TASK1060.code(), ErrorCodeEnum.TASK1060.msg());
        }
        return Response.ok().putObject(signVo);
    }


    /***
     * 获取管理后台奖励配置列表
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @GetMapping(value = "/sign/configuration")
    public Response getSignConfiguration() {
        List<SignConfigEntity> list = signService.getSignConfigurationList();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.TASK1055.code(), ErrorCodeEnum.TASK1055.msg());
        }
        return Response.ok().putList(GlobalConstant.RESPONSE, list);
    }
}
