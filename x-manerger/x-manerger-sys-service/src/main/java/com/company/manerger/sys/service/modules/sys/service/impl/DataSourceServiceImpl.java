package com.company.manerger.sys.service.modules.sys.service.impl;

import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.service.modules.sys.entity.DataSource;
import com.company.manerger.sys.service.modules.sys.mapper.DataSourceMapper;
import com.company.manerger.sys.service.modules.sys.service.IDataSourceService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 数据源
 *
 */
@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl  extends CommonServiceImpl<DataSourceMapper,DataSource> implements  IDataSourceService {

}
