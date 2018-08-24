package cn.jeeweb.modules.codegen.dao;

import cn.jeeweb.modules.codegen.codegenerator.data.DbColumnInfo;
import cn.jeeweb.modules.codegen.codegenerator.data.DbTableInfo;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * http://blog.csdn.net/lmy86263/article/details/51020759 Spring
 * JDBC学习笔记（3）：使用JdbcTemplate来获取数据库表和列的元数据
 * 
 * @author Administrator
 *
 */
public interface IGeneratorDao {

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

	public void createTable(Map<String, Object> tableInfo) throws TemplateException, IOException;

	public Boolean isExistTable(String tableName);

	public void dropTable(String tableName);

}