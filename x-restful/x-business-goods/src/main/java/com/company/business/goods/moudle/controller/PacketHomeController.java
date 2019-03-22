package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.RandomPacketVo;
import com.company.business.goods.moudle.service.IPacketUserService;
import com.company.business.goods.moudle.service.IRandomPacketService;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * 提供的配置控制器
 */
@RestController
@RequestMapping(value = "/packet")
public class PacketHomeController {


    @Autowired
    private IRandomPacketService randomPacketService;//首页红包配置服务
    @Autowired
    private IPacketUserService packetUserService;


    //获取新用户的随机金额显示
    @GetMapping(value = "/home")
    public Response getNewUserPacket() {

        RandomPacketVo randomPacketVo = randomPacketService.getRandomPacket();
        if (null == randomPacketVo) {
            return Response.error(ErrorCodeEnum.COUPON2033.code(), ErrorCodeEnum.COUPON2033.msg());
        }

        return Response.ok().putObject(randomPacketVo);
    }

    //用户确认红包
    @PostMapping("/home")
    public Response verifyPacket(@RequestBody JSONObject json) {
        double packet_money = json.getDoubleValue("packet_money");
        if (packet_money <= TomatoConstant.Common.NUMBER_0) {
            return Response.error(ErrorCodeEnum.COUPON2034.code(), ErrorCodeEnum.COUPON2034.msg());
        }

        return packetUserService.openPacket(packet_money) ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2035.code(), ErrorCodeEnum.COUPON2035.msg());

    }

    //获取用户红包数额
    @GetMapping(value = "/user")
    public Response getUserPacket() {
        HashMap packetUserEntity = packetUserService.getPacketUser(PrincipalUtils.getUsername());
        if (null == packetUserEntity) {
            return Response.error(ErrorCodeEnum.COUPON2031.code(), ErrorCodeEnum.COUPON2031.msg());
        }
        return Response.ok().putObject(packetUserEntity);
    }

}
