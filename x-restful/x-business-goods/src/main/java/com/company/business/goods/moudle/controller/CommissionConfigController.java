package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.moudle.service.ICommissionService;
import com.company.business.goods.moudle.service.ICommissionTipService;
import com.company.business.goods.moudle.service.IRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/commission/config")
public class CommissionConfigController {
    @Autowired
    private IRateService rateService;
    @Autowired
    private ICommissionTipService commissionTipService;
    @Autowired
    private ICommissionService iCommissionService;
    /**
     * 配置佣金比例
     *
     * @return
     */
    @PostMapping("/sale")
    public Response configSale(@RequestBody JSONObject json) {
        return rateService.insertRateEntity(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }


    /**
     * 提示消息配置
     * @param json
     * @return
     */
    @PostMapping("/tip")
    public Response insertTip(@RequestBody JSONObject json) {
        return commissionTipService.insertCommissionTip(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());

    }

    @PostMapping("/money")
    public Response commissionConfiguration(@RequestBody JSONObject json) {

        return iCommissionService.insertUpdateConfig(json) ? Response.ok() : Response.error(ErrorCodeEnum.AUTH600.code(), ErrorCodeEnum.AUTH600.msg());
    }

}
