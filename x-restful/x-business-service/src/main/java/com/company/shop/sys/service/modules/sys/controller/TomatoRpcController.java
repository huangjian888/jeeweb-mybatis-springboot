package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.FormIdVo;
import com.company.shop.sys.service.modules.sys.service.ITemplateService;
import com.company.shop.sys.service.utils.Log;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 留于管理后台使用，如，已经发货时发送模板消息
 */
@RestController
@RequestMapping(value = "/tomato")
public class TomatoRpcController {

    @Autowired
    private ITemplateService templateService;

    @PostMapping(value = "/order/message")

    public Response sendMessage(@RequestBody JSONObject json) {
        Log.i("server controller page enter sendMessage,json:" + json.toString());
        String username = json.getString("user_name");
        Date sendTime = json.getDate("send_time");
        String orderId = json.getString("order_id");
        String productName = json.getString("product_name");
        if (TextUtils.isEmpty(username) || TextUtils.isEmpty(orderId) || TextUtils.isEmpty(productName) || null == sendTime) {
            return Response.error(ErrorCodeEnum.AUTH1009.code(), ErrorCodeEnum.AUTH1009.msg());
        }

        FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(username));

        if (null == formIdVo) {
            return Response.ok();
        }

        Map<String, Object> map = new HashMap();

        map.put("send_time", sendTime);
        map.put("order_id", orderId);
        map.put("product_name", productName);

        templateService.sendNotifyTemplate(username, formIdVo, map, BusinessConstant.Message.NUMBER_4);

        return Response.ok();
    }
}
