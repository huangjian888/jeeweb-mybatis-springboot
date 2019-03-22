package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.modules.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 保存当前系统的配置接口
 */
@RestController
@RequestMapping("/config")
public class TomatoConfigController {

    @Autowired
    private IPacketConfigService packetConfigService;

    @Autowired
    private IProcedureConfigService procedureConfigService;

    @Autowired
    private IInviteConfigService inviteConfigService;
    @Autowired
    private ISignConfigService signConfigService;

    @Autowired
    private IAwardConfigService awardConfigService;

    /**
     * 配置新人红包
     *
     * @param json
     * @return
     */
    @PostMapping("/packet")
    public Response updatePacketConfig(@RequestBody JSONObject json) {

        return packetConfigService.updatePacketConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH1008.code(), ErrorCodeEnum.AUTH1008.msg());

    }

    /**
     * 配置添加到小程序奖励
     *
     * @param json
     * @return
     */
    @PostMapping("/procedure")
    public Response updateProcedureConfig(@RequestBody JSONObject json) {
        return procedureConfigService.updateProcedureConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH1008.code(), ErrorCodeEnum.AUTH1008.msg());

    }

    /**
     * 配置邀请人数及奖励
     *
     * @param json
     * @return
     */
    @PostMapping("/share")
    public Response updateInviteConfig(@RequestBody JSONObject json) {
        return inviteConfigService.updateInviteConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH1008.code(), ErrorCodeEnum.AUTH1008.msg());

    }

    /**
     * 配置签到奖励
     *
     * @param json
     * @return
     */
    @PostMapping("/sign")
    public Response updateSignConfig(@RequestBody JSONObject json) {

        return signConfigService.updateSignConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH1008.code(), ErrorCodeEnum.AUTH1008.msg());
    }

    /**
     * 配置步数兑换金币
     *
     * @param json
     * @return
     */
    @PostMapping("/step")
    public Response updateStepGoldConfig(@RequestBody JSONObject json) {

        return awardConfigService.updateAwardConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH1008.code(), ErrorCodeEnum.AUTH1008.msg());
    }

}
