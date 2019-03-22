package com.company.business.goods.moudle.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.CouponVo;
import com.company.business.goods.moudle.entity.CouponEntity;
import com.company.business.goods.moudle.service.ICouponService;
import com.company.business.goods.utils.PageUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CouponController {

    @Autowired
    private ICouponService couponService;

    @PostMapping(value = "/coupon")
    public Response insertCoupon(@RequestBody JSONObject json) {
        String couponId = json.getString("couponId");
        if (TextUtils.isEmpty(couponId)) {
            return Response.error(ErrorCodeEnum.COUPON2000.code(), ErrorCodeEnum.COUPON2000.msg());
        }
        return couponService.insertCoupon(couponId) > 0 ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2001.code(), ErrorCodeEnum.COUPON2001.msg());


    }

    @GetMapping(value = "/coupon")
    public Response getCouponList(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<CouponEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<CouponEntity> pageList = couponService.getCouponList(pageEntity);
        List<CouponEntity> list = pageList.getRecords();

        if (null == list) {
            return Response.error(ErrorCodeEnum.COUPON2002.code(), ErrorCodeEnum.COUPON2002.msg());
        }
        CouponVo couponVo = new CouponVo();
        couponVo.setList(list);
        couponVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(couponVo);
    }
}