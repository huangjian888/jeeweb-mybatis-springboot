package com.company.generator.manager.service.impl;

import com.company.generator.manager.common.dao.DbHelper;
import com.company.generator.manager.common.dao.IDbHelper;
import com.company.generator.manager.entity.DataSource;
import com.company.generator.manager.mapper.DataSourceMapper;
import com.company.generator.manager.service.IDataSourceService;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@Transactional
@Service("dataSourceService")
public class DataSourceServiceImpl  extends CommonServiceImpl<DataSourceMapper,DataSource> implements IDataSourceService {
    public IDbHelper getDbHelper(String datasourid){
        DataSource dataSource=selectById(datasourid);
        Connection connection=getConnection(dataSource);
        return new DbHelper(connection,dataSource.getDbType(),dataSource.getDbName());
    }

    public Connection getConnection(DataSource dataSource){
        try {
            Connection conn = null;
            String dbType = dataSource.getDbType();
            String url = StringEscapeUtils.unescapeHtml(dataSource.getUrl());
            String username = dataSource.getDbUser();
            String password = dataSource.getDbPassword();
            String driverClassName = dataSource.getDriverClass();
            Properties props = new Properties();
            if (username != null) {
                props.put("user", username);
            }
            if (password != null) {
                props.put("password", password);
            }
            if (dbType.equals("oracle")) {
                props.put("remarksReporting", "true");
            }
            // 初始化JDBC驱动并让驱动加载到jvm中
            Class.forName(driverClassName);
            conn = DriverManager.getConnection(url, props);
            conn.setAutoCommit(true);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void testConnect(DataSource dataSource) {
         getConnection(dataSource);
    }
}
