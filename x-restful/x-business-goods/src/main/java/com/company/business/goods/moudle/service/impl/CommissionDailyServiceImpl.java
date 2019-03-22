package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.CommissionDailyEntity;
import com.company.business.goods.moudle.mapper.CommissionDailyMapper;
import com.company.business.goods.moudle.service.ICommissionDailyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("commissionDailyService")
@Transactional
public class CommissionDailyServiceImpl extends ServiceImpl<CommissionDailyMapper, CommissionDailyEntity> implements ICommissionDailyService {


    @Override
    public CommissionDailyEntity getCommissionDaily(String username) {
        return baseMapper.getCommissionDaily(username);
    }

    @Override
    public boolean insertCommissionEntity(CommissionDailyEntity commissionDailyEntity) {
        return insertOrUpdate(commissionDailyEntity);
    }
}
