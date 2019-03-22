package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.moudle.service.ITemplateService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inform")
public class TemplateController {

    @Autowired
    private ITemplateService templateService;

    @PostMapping(value = "/product")
    public Response saveFormId(@RequestBody JSONObject json) {
        String formId = json.getString("formId");
        if (TextUtils.isEmpty(formId)) {
            return Response.error(ErrorCodeEnum.COUPON2007.code(), ErrorCodeEnum.COUPON2007.msg());
        }

        return templateService.saveFormId(formId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2008.code(), ErrorCodeEnum.COUPON2008.msg());
    }
}
