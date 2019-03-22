package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.common.vo.CommissionVo;
import com.company.business.goods.moudle.entity.CommissionEntity;

import java.util.List;

/**
 * 用户提现接口
 */
public interface ICommissionService {

    int commission(String money);

    List<CommissionEntity> getCommissionList();

    CommissionVo getCommissionVo();

    int commissionAble();

    boolean insertUpdateConfig(JSONObject json);

}
