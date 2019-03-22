package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.PacketVo;
import com.company.business.goods.moudle.entity.PacketUserEntity;
import com.company.business.goods.moudle.service.IPacketUserService;
import com.company.business.goods.utils.BigDecimalUtils;
import com.company.business.goods.utils.DateUtils;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;

@RestController
@RequestMapping("/packet")
public class PacketWithdrawController {

    @Autowired
    private IPacketUserService packetUserService;

    /**
     * 红包提现提示
     *
     * @return
     */
    @GetMapping("/tips")
    public Response packetWithdrawTip() {

        PacketUserEntity packetUserEntity = packetUserService.getPacketUserEntity(PrincipalUtils.getUsername());
        if (null == packetUserEntity) {
            return Response.error(ErrorCodeEnum.COUPON2037.code(), ErrorCodeEnum.COUPON2037.msg());
        }

        PacketVo packetVo = new PacketVo();
        packetVo.setMoney(packetUserEntity.getPacket_amounts().setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        packetVo.setDay(TomatoConstant.Common.NUMBER_30 - DateUtils.isNotOneDay(packetUserEntity.getPacket_first_date(), new Date()));
        return Response.ok().putObject(packetVo);
    }

    @PostMapping("/withdraw")
    public Response packetWithdraw(@RequestBody JSONObject json) {
        String money = json.getString("withdraw_money");
        if (BigDecimalUtils.sub(Double.valueOf(money), TomatoConstant.Common.NUMBER_20).doubleValue() >= 0) {
            return Response.error(ErrorCodeEnum.COUPON2039.code(), ErrorCodeEnum.COUPON2039.msg());

        }
        return Response.error(ErrorCodeEnum.COUPON2038.code(), ErrorCodeEnum.COUPON2038.msg());

    }
}
