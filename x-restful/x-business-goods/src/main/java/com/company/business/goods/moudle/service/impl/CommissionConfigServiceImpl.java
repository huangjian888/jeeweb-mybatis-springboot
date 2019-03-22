package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.CommissionConfigEntity;
import com.company.business.goods.moudle.mapper.CommissionConfigMapper;
import com.company.business.goods.moudle.service.ICommissionConfigService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("commissionConfigService")
@Transactional
public class CommissionConfigServiceImpl extends ServiceImpl<CommissionConfigMapper, CommissionConfigEntity> implements ICommissionConfigService {
    @Override
    public CommissionConfigEntity getCommissionConfig(int count) {
        return baseMapper.getCommissionConfig(count);
    }

    @Override
    public List<CommissionConfigEntity> getCommissionConfigList() {
        return baseMapper.getCommissionConfigList();
    }

    @Override
    public boolean insertCommissionConfig(CommissionConfigEntity commissionConfigEntity) {

        return insertOrUpdate(commissionConfigEntity);
    }


}