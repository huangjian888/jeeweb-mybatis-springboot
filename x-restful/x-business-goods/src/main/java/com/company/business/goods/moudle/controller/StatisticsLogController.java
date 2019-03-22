package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.moudle.service.IStatisticsLogService;
import com.company.business.goods.moudle.service.IStatisticsSearchService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/log")
public class StatisticsLogController {

    @Autowired
    private IStatisticsLogService statisticsLogService;

    @Autowired
    private IStatisticsSearchService statisticsSearchService;

    @PostMapping("/page")
    public Response updateLog(@RequestBody JSONObject json) {

        return statisticsLogService.insetUpdate(json) ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2011.code(), ErrorCodeEnum.COUPON2011.msg());
    }

    @PostMapping("/search")
    public Response updateSearch(@RequestBody JSONObject json) {
        String keyWord = json.getString("keyWord");
        if (TextUtils.isEmpty(keyWord)) {
            return Response.error(ErrorCodeEnum.COUPON2000.code(), ErrorCodeEnum.COUPON2000.msg());
        }
        return statisticsSearchService.insertSearchLog(keyWord) ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2011.code(), ErrorCodeEnum.COUPON2011.msg());
    }

}
