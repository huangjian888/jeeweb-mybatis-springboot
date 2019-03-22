package com.company.generator.manager.service;

import com.company.generator.manager.common.dao.IDbHelper;
import com.company.generator.manager.entity.DataSource;
import com.company.manerger.sys.common.mybatis.service.ICommonService;


public interface IDataSourceService extends ICommonService<DataSource> {
    /**
     * 获取Hepler
     * @param datasourid
     * @return
     */
    IDbHelper getDbHelper(String datasourid);

    void testConnect(DataSource dataSource);

}

