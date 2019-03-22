package com.company.business.goods.moudle.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.company.business.goods.moudle.entity.CouponEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CouponMapper extends BaseMapper<CouponEntity> {

    List<CouponEntity> getCouponList(Pagination page, @Param("username") String username);

    CouponEntity selectCoupon(@Param("username") String username,@Param("couponId")String couponId);
}
