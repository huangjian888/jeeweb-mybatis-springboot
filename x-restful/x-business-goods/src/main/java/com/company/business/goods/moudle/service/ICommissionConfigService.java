package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.CommissionConfigEntity;
import java.util.List;

public interface ICommissionConfigService {

    CommissionConfigEntity getCommissionConfig(int count);
    List<CommissionConfigEntity> getCommissionConfigList();

    boolean insertCommissionConfig(CommissionConfigEntity commissionConfigEntity);

}
