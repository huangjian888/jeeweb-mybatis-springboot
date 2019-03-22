package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.CommissionVo;
import com.company.business.goods.moudle.service.ICommissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CommissionController {

    @Autowired
    private ICommissionService iCommissionService;


    /**
     * 提现:需要输出提现金额
     *
     * @param json
     * @return
     */

    @PostMapping("/commission")
    public Response commission(@RequestBody JSONObject json) {

        String money = json.getString("commission_money");

        if (null == money) {
            return Response.error(ErrorCodeEnum.COUPON2027.code(), ErrorCodeEnum.COUPON2027.msg());
        }
        int code = iCommissionService.commission(money);

        if (code == TomatoConstant.Common.NUMBER_1) {
            return Response.ok();
        } else if (code == ErrorCodeEnum.COUPON2020.code()) {
            return Response.error(ErrorCodeEnum.COUPON2020.code(), ErrorCodeEnum.COUPON2020.msg());

        } else if (code == ErrorCodeEnum.COUPON2021.code()) {

            return Response.error(ErrorCodeEnum.COUPON2021.code(), ErrorCodeEnum.COUPON2021.msg());

        } else if (code == ErrorCodeEnum.COUPON2023.code()) {

            return Response.error(ErrorCodeEnum.COUPON2023.code(), ErrorCodeEnum.COUPON2023.msg());

        } else if (code == ErrorCodeEnum.COUPON2025.code()) {
            return Response.error(ErrorCodeEnum.COUPON2025.code(), ErrorCodeEnum.COUPON2025.msg());
        } else if (code == ErrorCodeEnum.COUPON2026.code()) {
            return Response.error(ErrorCodeEnum.COUPON2026.code(), ErrorCodeEnum.COUPON2026.msg());
        }

        return Response.error(ErrorCodeEnum.COUPON2022.code(), ErrorCodeEnum.COUPON2022.msg());

    }

    /**
     * 提现:动态提示消息
     *
     * @return
     */
    @GetMapping("/commission/tips")
    public Response commissionTips() {
        CommissionVo commissionVo = iCommissionService.getCommissionVo();
        if (null == commissionVo) {
            return Response.error(ErrorCodeEnum.COUPON2029.code(), ErrorCodeEnum.COUPON2029.msg());
        }

        return Response.ok().putObject(commissionVo);


    }

    /**
     * 提现：当日是否可提现
     *
     * @return
     */
    @GetMapping("/commission/status")
    public Response commissionAble() {
        CommissionVo commissionVo = new CommissionVo();
        commissionVo.setStatus(iCommissionService.commissionAble());
        return Response.ok().putObject(commissionVo);

    }


}
