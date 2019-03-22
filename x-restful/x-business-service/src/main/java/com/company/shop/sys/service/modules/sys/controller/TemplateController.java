package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.modules.sys.service.ITemplateService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemplateController {

    @Autowired
    private ITemplateService templateService;

    @PostMapping(value = "/form")
    public Response saveFormId(@RequestBody JSONObject json) {
        String formId = json.getString("formId");
        if (TextUtils.isEmpty(formId)) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }

        return templateService.saveFormId(formId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.COMMON9001.code(), ErrorCodeEnum.COMMON9001.msg());
    }
}
