package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.CollectEntity;
import com.company.business.goods.moudle.mapper.CollectMapper;
import com.company.business.goods.moudle.service.ICollectService;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("collectService")
@Transactional
public class CollectServiceImpl extends ServiceImpl<CollectMapper, CollectEntity> implements ICollectService {

    @Override
    public int addCoupon(String couponId) {

        CollectEntity collectEntity = this.selectCollect(couponId);
        if (null == collectEntity) {
            collectEntity = new CollectEntity();
            collectEntity.setCouponId(couponId);
            collectEntity.setCollectTime(new Date());
            collectEntity.setUsername(PrincipalUtils.getUsername());

            return insertOrUpdate(collectEntity) ? 1 : 0;
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
    public Page<CollectEntity> getCollectList(Page<CollectEntity> page) {

        return page.setRecords(baseMapper.getCollectList(page, PrincipalUtils.getUsername()));
    }

    @Override
    public CollectEntity selectCollect(String couponId) {
        return baseMapper.selectCollect(PrincipalUtils.getUsername(), couponId);
    }

    /**
     * 取消收藏
     *
     * @param couponId
     * @return
     */
    @Override
    public int cancelCollect(String couponId) {
        return baseMapper.cancelCollect(PrincipalUtils.getUsername(), couponId);
    }

    /**
     * 获取当前商品是否被收藏
     *
     * @return
     */
    @Override
    public boolean isCollect(String couponId) {
        CollectEntity collectEntity = this.selectCollect(couponId);
        if (null == collectEntity) {//用户还没有收藏当前商品
            return false;
        }
        return true;//用户已经收藏
    }
}
