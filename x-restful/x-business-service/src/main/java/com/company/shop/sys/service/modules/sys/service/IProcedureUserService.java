package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.ProcedureUserEntity;

public interface IProcedureUserService {
    ProcedureUserEntity getProcedureUserEntity();

    TaskInfoVo addProcedure();
}
