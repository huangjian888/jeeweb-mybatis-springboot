package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.CommissionDailyEntity;

/**
 * 用户提现接口
 */
public interface ICommissionDailyService {

    CommissionDailyEntity getCommissionDaily(String username);

    boolean insertCommissionEntity(CommissionDailyEntity commissionDailyEntity);


}
