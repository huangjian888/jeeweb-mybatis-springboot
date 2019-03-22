package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;

import java.util.List;


public interface ISignConfigService {


    SignConfigEntity getStep(int day);

    List<SignConfigEntity> getSignConfig();

    boolean updateSignConfig(JSONObject json);
}
