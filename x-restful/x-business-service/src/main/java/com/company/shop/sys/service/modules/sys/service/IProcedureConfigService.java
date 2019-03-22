package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.modules.sys.entity.ProcedureConfigEntity;

public interface IProcedureConfigService {

    ProcedureConfigEntity getProcedureEntity();

    boolean updateProcedureConfig(JSONObject json);

}
