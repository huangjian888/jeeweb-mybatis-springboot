package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.moudle.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/packet/config")
public class PacketConfigController {
    @Autowired
    private IPacketSaleService packetSaleService;
    @Autowired
    private IRandomPacketService randomPacketService;//首页红包配置服务

    @Autowired
    private IPacketLimitService packetLimitService;

    @Autowired
    private IPacketRuleService packetRuleService;

    @Autowired
    private IPacketCommissionService packetCommissionService;

    /**
     * 配置自返比例
     *
     * @return
     */
    @PostMapping("/sale")
    public Response configSale(@RequestBody JSONObject json) {
        return packetSaleService.insertUpdateConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }


    //配置随机金额
    @PostMapping("/random")
    public Response insertRandomPacket(@RequestBody JSONObject json) {
        return randomPacketService.insertRandomPack(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }

    //配置红包提现金额
    @PostMapping("/red")
    public Response insertRedPacket(@RequestBody JSONObject json) {
        return packetLimitService.insertUpdate(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }

    //配置红包生成规则
    @PostMapping("/rule")
    public Response randomRedPacket(@RequestBody JSONObject json) {
        return packetRuleService.insertUpdate(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }

    //配置粉丝订单佣金规则
    @PostMapping("/fans")
    public Response configFansOrderRule(@RequestBody JSONObject json) {
        return packetCommissionService.insertUpdateConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }
}
