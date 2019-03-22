package com.company.generator.manager.common.dao;

import com.company.generator.manager.common.data.DbColumnInfo;
import com.company.generator.manager.common.data.DbTableInfo;
import com.company.generator.manager.common.definition.SqlUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据工具类
 */
public class DbHelper implements IDbHelper {

    private Connection connection;
    private String dbType;
    private String dbName;

    public DbHelper(Connection connection,String dbType,String dbName){
        this.connection=connection;
        this.dbType=dbType;
        this.dbName=dbName;
    }

    @Override
    public List<DbTableInfo> getDbTables() {
        ResultSet resultSet = null;
        List<DbTableInfo> dbTableInfos = new ArrayList<DbTableInfo>();
        try {
            connection.setAutoCommit(true);
            String[] types = { "TABLE" };
            // 判断是否为MYSQL
            String driverName = connection.getMetaData().getDriverName().toUpperCase();
            if (driverName.contains("ORACLE")) {
                resultSet = connection.getMetaData().getTables(null, dbName.toUpperCase(),
                        null, types);
            } else {
                resultSet = connection.getMetaData().getTables(null, null, null, types);
            }
            while (resultSet.next()) {
                String tableName = resultSet.getString("TABLE_NAME");
                String remarks = resultSet.getString("REMARKS");
                if (StringUtils.isEmpty(remarks)) {

                    if (driverName.contains("MySQL")) {

                    }
                }
                DbTableInfo dbTableInfo = new DbTableInfo();
                dbTableInfo.setTableName(tableName);
                dbTableInfo.setRemarks(remarks);
                dbTableInfos.add(dbTableInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                } finally {
                    if (connection != null)
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                }
        }
        return dbTableInfos;
    }

    @Override
    public List<DbColumnInfo> getDbColumnInfo(String tableName) {
        ResultSet resultSet = null;
        List<DbColumnInfo> columnInfos = new ArrayList<DbColumnInfo>();
        try {
            connection.setAutoCommit(true);
            // 判断是否为MYSQL
            String driverName = connection.getMetaData().getDriverName().toUpperCase();
            // 获得列的信息
            resultSet = connection.getMetaData().getColumns(null, null, tableName, null);
            while (resultSet.next()) {
                // 获得字段名称
                String columnName = resultSet.getString("COLUMN_NAME");
                // 获得字段类型名称
                String typeName = resultSet.getString("TYPE_NAME");
                // 获得字段大小
                String columnSize = resultSet.getString("COLUMN_SIZE");
                // 获得字段备注
                String remarks = resultSet.getString("REMARKS");
                if(!StringUtils.isEmpty(remarks)){
                    remarks=remarks.replace("'","");
                }else{
                    remarks="";
                }

                // 该列是否为空
                Boolean nullable = Boolean.FALSE;
                if (driverName.contains("ORACLE")) {
                    nullable = resultSet.getBoolean("NULLABLE");
                } else {
                    nullable = resultSet.getBoolean("IS_NULLABLE");
                }
                // 小数部分的位数
                String decimalDigits = resultSet.getString("DECIMAL_DIGITS");
                // 默认值
                String columnDef = resultSet.getString("COLUMN_DEF");
                if (!StringUtils.isEmpty(columnDef)){
                    columnDef=columnDef.replace("'","");
                    columnDef=columnDef.trim();
                }
                DbColumnInfo info = new DbColumnInfo(columnName, typeName, columnSize, remarks, nullable, false, false,
                        columnDef, decimalDigits);
                columnInfos.add(info);
            }

            // 获得主键的信息
            resultSet = connection.getMetaData().getPrimaryKeys(null, null, tableName);
            while (resultSet.next()) {
                String primaryKey = resultSet.getString("COLUMN_NAME");
                // 设置是否为主键
                for (DbColumnInfo dbColumnInfo : columnInfos) {
                    if (primaryKey != null && primaryKey.equals(dbColumnInfo.getColumnName()))
                        dbColumnInfo.setParmaryKey(true);
                    else
                        dbColumnInfo.setParmaryKey(false);
                }
            }

            // 获得外键信息
            resultSet = connection.getMetaData().getImportedKeys(null, null, tableName);
            while (resultSet.next()) {
                String exportedKey = resultSet.getString("FKCOLUMN_NAME");
                // 设置是否是外键
                for (DbColumnInfo dbColumnInfo : columnInfos) {
                    if (exportedKey != null && exportedKey.equals(dbColumnInfo.getColumnName()))
                        dbColumnInfo.setImportedKey(true);
                    else
                        dbColumnInfo.setImportedKey(false);
                }
            }

        } catch (

                Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取字段信息的时候失败，请将问题反映到维护人员。" + e.getMessage(), e);
        } finally {
            if (resultSet != null)
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (connection != null)
                        try {
                            connection.close();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                }
        }
        return columnInfos;
    }

    @Override
    public void createTable(Map<String, Object> tableInfo) throws TemplateException, IOException {
        String createTableSql = SqlUtils.getSqlUtils(dbType).getSqlByID("createTable").getContent().trim();
        createTableSql = parseSql(createTableSql, tableInfo).trim();
        executeSql(createTableSql);
    }

    @Override
    public void dropTable(String tableName) {
        String dropSql = SqlUtils.getSqlUtils(dbType).getSqlByID("dropTable").getContent().trim();
        dropSql = dropSql.replaceAll("\\$\\{tablename\\}", tableName);
        executeSql(dropSql);
    }

    /**
     *
     * @title: executeSql
     * @description: 执行sql
     * @param sql
     * @return: void
     */
    public void executeSql(String sql) {
        Statement stmt = null;
        try {
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            String[] sqls=sql.split(";");
            if (sqls.length>1){
                for (String sqlItem:sqls) {
                    stmt.addBatch(sqlItem);
                }
                stmt.executeBatch();
            }else {
                stmt.execute(sql);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    private String parseSql(String sql, Map<String, Object> rootMap) throws TemplateException, IOException {
        String tempname = StringUtils.hashKeyForDisk(sql);
        Configuration configuration = new Configuration();
        configuration.setNumberFormat("#");
        StringTemplateLoader stringLoader = new StringTemplateLoader();
        stringLoader.putTemplate(tempname, sql);
        @SuppressWarnings("deprecation")
        Template template = new Template(tempname, new StringReader(sql));
        StringWriter stringWriter = new StringWriter();
        template.process(rootMap, stringWriter);
        configuration.setTemplateLoader(stringLoader);
        sql = stringWriter.toString();
        return sql;
    }
}

