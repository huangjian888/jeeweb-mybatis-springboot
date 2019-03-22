package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.BuyLimitEntity;
import com.company.shop.sys.service.modules.sys.mapper.BuyLimitMapper;
import com.company.shop.sys.service.modules.sys.service.IBuyLimitService;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("buyLimitService")
public class BuyLimitServiceImpl extends ServiceImpl<BuyLimitMapper, BuyLimitEntity> implements IBuyLimitService {
    @Override
    public BuyLimitEntity getBuyLimit() {
        return baseMapper.getLimit(PrincipalUtils.getUsername());
    }

    @Override
    public int insertUserBuy(BuyLimitEntity buyLimitEntity) {
        return insertOrUpdate(buyLimitEntity) ? 1 : 0;
    }
}
