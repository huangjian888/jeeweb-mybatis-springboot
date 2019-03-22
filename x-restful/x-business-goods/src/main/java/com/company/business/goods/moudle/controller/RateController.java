package com.company.business.goods.moudle.controller;

import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.RateVo;
import com.company.business.goods.moudle.service.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateController {

    @Autowired
    private IRateService rateService;

    @GetMapping("/commission/rate")
    public Response getRate() {
        RateVo rateVo = rateService.getRate();
        if (null == rateVo) {
            return Response.error(ErrorCodeEnum.COUPON2028.code(), ErrorCodeEnum.COUPON2028.msg());
        }
        return Response.ok().putObject(rateVo);
    }

}
