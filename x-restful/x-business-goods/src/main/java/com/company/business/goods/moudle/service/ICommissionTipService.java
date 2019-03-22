package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.moudle.entity.CommissionTipEntity;

public interface ICommissionTipService {
    boolean insertCommissionTip(JSONObject json);

    CommissionTipEntity getCommissionTip();
}
