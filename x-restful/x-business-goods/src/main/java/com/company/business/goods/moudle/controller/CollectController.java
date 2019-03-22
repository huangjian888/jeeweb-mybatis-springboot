package com.company.business.goods.moudle.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.CollectVo;
import com.company.business.goods.moudle.entity.CollectEntity;
import com.company.business.goods.moudle.service.ICollectService;
import com.company.business.goods.utils.PageUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CollectController {

    @Autowired
    private ICollectService collectService;

    @PostMapping(value = "/collect")
    public Response addCoupon(@RequestBody JSONObject json) {
        String couponId = json.getString("couponId");
        if (TextUtils.isEmpty(couponId)) {
            return Response.error(ErrorCodeEnum.COUPON2000.code(), ErrorCodeEnum.COUPON2000.msg());
        }
        return collectService.addCoupon(couponId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2001.code(), ErrorCodeEnum.COUPON2001.msg());
    }

    @GetMapping(value = "/collect")
    public Response getCollectList(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<CollectEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<CollectEntity> pageList = collectService.getCollectList(pageEntity);
        List<CollectEntity> list = pageList.getRecords();

        if (null == list) {
            return Response.error(ErrorCodeEnum.COUPON2003.code(), ErrorCodeEnum.COUPON2003.msg());
        }
        CollectVo collectVo = new CollectVo();
        collectVo.setList(list);
        collectVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(collectVo);
    }


    @DeleteMapping(value = "/collect")
    public Response cancelCollect(@RequestBody JSONObject json) {
        String couponId = json.getString("couponId");
        if (TextUtils.isEmpty(couponId)) {
            return Response.error(ErrorCodeEnum.COUPON2000.code(), ErrorCodeEnum.COUPON2000.msg());
        }

        return collectService.cancelCollect(couponId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2009.code(), ErrorCodeEnum.COUPON2009.msg());

    }

    @PostMapping(value = "/collect/coupon")
    public Response isCollect(@RequestBody JSONObject json) {
        String couponId = json.getString("couponId");
        if (TextUtils.isEmpty(couponId)) {
            return Response.error(ErrorCodeEnum.COUPON2000.code(), ErrorCodeEnum.COUPON2000.msg());
        }
        CollectVo collectVo = new CollectVo();
        collectVo.setCollect(collectService.isCollect(couponId));
        return Response.ok().putObject(collectVo);

    }

}