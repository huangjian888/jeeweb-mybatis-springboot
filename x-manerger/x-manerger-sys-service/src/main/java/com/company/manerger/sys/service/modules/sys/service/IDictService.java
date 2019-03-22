package com.company.manerger.sys.service.modules.sys.service;


import java.util.List;

import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.company.manerger.sys.service.modules.sys.entity.Dict;

/**
 *
 */
public interface IDictService extends ICommonService<Dict> {
    public List<Dict> selectDictList();
}
