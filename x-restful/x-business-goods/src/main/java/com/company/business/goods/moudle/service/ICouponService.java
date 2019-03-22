package com.company.business.goods.moudle.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.company.business.goods.moudle.entity.CouponEntity;

/**
 * 优惠劵
 */
public interface ICouponService {

    int insertCoupon(String couponId);

    Page<CouponEntity> getCouponList(Page<CouponEntity> page);

    CouponEntity selectCoupon(String couponId);
}
