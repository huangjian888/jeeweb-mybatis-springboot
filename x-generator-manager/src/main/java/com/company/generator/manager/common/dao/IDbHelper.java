package com.company.generator.manager.common.dao;

import com.company.generator.manager.common.data.DbColumnInfo;
import com.company.generator.manager.common.data.DbTableInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description: 数据工具类
 */
public interface IDbHelper extends Serializable {

    /**
     * 获取所有的表明
     *
     * @return
     */
    public List<DbTableInfo> getDbTables();

    /**
     * 通过表名获取所有的表名
     *
     * @param tableName
     * @return
     */
    public List<DbColumnInfo> getDbColumnInfo(String tableName);

    /**
     * 创建表
     * @param tableInfo
     * @throws TemplateException
     * @throws IOException
     */
    public void createTable(Map<String, Object> tableInfo) throws TemplateException, IOException;

    /**
     * 删除表
     * @param tableName
     */
    public void dropTable(String tableName);

}
