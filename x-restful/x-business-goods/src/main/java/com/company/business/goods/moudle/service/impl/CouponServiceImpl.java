package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.CouponEntity;
import com.company.business.goods.moudle.mapper.CouponMapper;
import com.company.business.goods.moudle.service.ICouponService;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("couponService")
@Transactional
public class CouponServiceImpl extends ServiceImpl<CouponMapper, CouponEntity> implements ICouponService {

    @Override
    public int insertCoupon(String couponId) {

        CouponEntity couponEntity = this.selectCoupon(couponId);
        if (null == couponEntity) {
            couponEntity = new CouponEntity();
            couponEntity.setCouponId(couponId);
            couponEntity.setReceiveTime(new Date());
            couponEntity.setUsername(PrincipalUtils.getUsername());
            return insertOrUpdate(couponEntity) ? 1 : 0;
        }


        return 0;

    }

    /**
     * 获取兑换券列表
     *
     * @param page
     * @return
     */
    @Override
    public Page<CouponEntity> getCouponList(Page<CouponEntity> page) {

        return page.setRecords(baseMapper.getCouponList(page, PrincipalUtils.getUsername()));
    }

    @Override
    public CouponEntity selectCoupon(String couponId) {
        return baseMapper.selectCoupon(PrincipalUtils.getUsername(), couponId);
    }
}
