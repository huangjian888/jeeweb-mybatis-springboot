package com.company.business.goods.moudle.service;

import com.alibaba.fastjson.JSONObject;
import com.company.business.goods.common.vo.RateVo;
import com.company.business.goods.moudle.entity.RateEntity;

public interface IRateService {

    RateVo getRate();

    boolean insertRateEntity(JSONObject json);

    RateEntity getRateEntity();
}
