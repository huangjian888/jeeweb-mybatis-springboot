package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.modules.sys.entity.AwardConfigEntity;

import java.util.List;


public interface IAwardConfigService {
    List<AwardConfigEntity> getAwardList();

    AwardConfigEntity getAwardConfigEntity(int order);

    boolean updateAwardConfig(JSONObject json);
}
