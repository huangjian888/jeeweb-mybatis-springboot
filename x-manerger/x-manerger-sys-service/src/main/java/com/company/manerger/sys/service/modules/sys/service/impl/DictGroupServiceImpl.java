package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.DictGroup;
import com.company.manerger.sys.service.modules.sys.mapper.DictGroupMapper;
import com.company.manerger.sys.service.modules.sys.service.IDictGroupService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("dictGroupService")
public class DictGroupServiceImpl extends CommonServiceImpl<DictGroupMapper,DictGroup> implements IDictGroupService {
}
