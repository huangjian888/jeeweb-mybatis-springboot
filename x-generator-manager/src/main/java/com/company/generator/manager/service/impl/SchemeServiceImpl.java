package com.company.generator.manager.service.impl;

import com.company.generator.manager.entity.Scheme;
import com.company.generator.manager.mapper.SchemeMapper;
import com.company.generator.manager.service.ISchemeService;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("schemeService")
public class SchemeServiceImpl  extends CommonServiceImpl<SchemeMapper,Scheme> implements ISchemeService {

}
