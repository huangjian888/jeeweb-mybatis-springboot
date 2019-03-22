package com.company.business.goods.moudle.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.company.business.goods.moudle.entity.CollectEntity;

/**
 * 优惠劵
 */
public interface ICollectService {

    int addCoupon(String couponId);

    Page<CollectEntity> getCollectList(Page<CollectEntity> page);

    CollectEntity selectCollect(String couponId);

    int cancelCollect(String couponId);

    boolean isCollect(String couponId);
}
