package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.moudle.entity.PageIConEntity;
import com.company.business.goods.moudle.service.IPageIConService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PageIConController {

    @Autowired
    private IPageIConService pageIConService;

    /**
     * 根据markId查询对应page信息
     *
     * @param markId
     * @return
     */
    @GetMapping(value = "/page/icon/{markId}")
    public Response getPageIConEntity(@PathVariable("markId") String markId) {
        if (TextUtils.isEmpty(markId)) {
            return Response.error(ErrorCodeEnum.COUPON2000.code(), ErrorCodeEnum.COUPON2000.msg());
        }

        PageIConEntity pageIConEntity = pageIConService.getPageIConEntity(markId);
        if (null == pageIConEntity) {
            return Response.error(ErrorCodeEnum.COUPON2012.code(), ErrorCodeEnum.COUPON2012.msg());
        }
        return Response.ok().putObject(pageIConEntity);

    }

    /**
     * 插入相应页面信息
     *
     * @param json
     * @return
     */
    @PostMapping(value = "/page/icon")
    public Response insertPageIConEntity(@RequestBody JSONObject json) {

        return pageIConService.insertPageICon(json) ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2016.code(), ErrorCodeEnum.COUPON2016.msg());
    }

    @PutMapping(value = "/page/icon")
    public Response updatePageICon(@RequestBody JSONObject json) {
        return pageIConService.updatePageIcon(json) ? Response.ok() :
                Response.error(ErrorCodeEnum.COUPON2016.code(), ErrorCodeEnum.COUPON2016.msg());

    }
}
