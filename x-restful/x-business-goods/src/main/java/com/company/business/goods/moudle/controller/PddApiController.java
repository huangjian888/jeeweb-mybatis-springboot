package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.PddVo;
import com.company.business.goods.moudle.service.IPddService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 拼多多api统一接口调用
 */
@RestController
public class PddApiController {
    @Autowired
    private IPddService pddService;

    @PostMapping(value = "/pdd/entrance")
    public Response apiResponse(@RequestBody JSONObject json) {

        String type = json.getString("type");//函数名


        if (TextUtils.isEmpty(type)) {
            return Response.error(ErrorCodeEnum.COUPON2004.code(), ErrorCodeEnum.COUPON2004.msg());
        }

        String response = pddService.apiCenter(json);
        if (TextUtils.isEmpty(response)) {
            return Response.error(ErrorCodeEnum.COUPON2005.code(), ErrorCodeEnum.COUPON2005.msg());
        }
        JSONObject jsonObject = JSON.parseObject(response);
        if (!TextUtils.isEmpty(jsonObject.getString("error_response"))) {

            JSONObject errorJson = JSON.parseObject(jsonObject.getString("error_response"));
            return Response.error(Integer.parseInt(errorJson.getString("error_code")), errorJson.getString("error_msg"));
        }
        PddVo pddVo = new PddVo();
        pddVo.setPdd(response);
        return Response.ok().putObject(pddVo);
    }

    @PostMapping(value = "/pdd/category")
    public Response categoryProduct(@RequestBody JSONObject json) {

        String response = pddService.categoryProduct(json);
        if (TextUtils.isEmpty(response)) {
            return Response.error(ErrorCodeEnum.COUPON2005.code(), ErrorCodeEnum.COUPON2005.msg());
        }
        JSONObject jsonObject = JSON.parseObject(response);
        if (!TextUtils.isEmpty(jsonObject.getString("error_response"))) {

            JSONObject errorJson = JSON.parseObject(jsonObject.getString("error_response"));
            return Response.error(Integer.parseInt(errorJson.getString("error_code")), errorJson.getString("error_msg"));
        }
        PddVo pddVo = new PddVo();
        pddVo.setPdd(response);
        return Response.ok().putObject(pddVo);
    }
}
