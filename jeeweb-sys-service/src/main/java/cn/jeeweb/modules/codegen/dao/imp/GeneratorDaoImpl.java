package cn.jeeweb.modules.codegen.dao.imp;

import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.codegen.codegenerator.data.DbColumnInfo;
import cn.jeeweb.modules.codegen.codegenerator.data.DbTableInfo;
import cn.jeeweb.modules.codegen.codegenerator.utils.CodeGenUtils;
import cn.jeeweb.modules.codegen.codegenerator.utils.SqlUtils;
import cn.jeeweb.modules.codegen.dao.IGeneratorDao;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * http://blog.csdn.net/linwei_hello/article/details/21639657
 * http://www.cnblogs.com/csuwangwei/archive/2012/01/30/2331737.html
 * http://www.thinksaas.cn/topics/0/195/195191.html 数据库底层操作（还有HIBREATE的映射）
 * http://blog.csdn.net/qq383264679/article/details/52460098 备注问题
 * http://blog.csdn.net/leolu007/article/details/45971053 获得表备注问题
 * 
 * @author 白猫
 *
 */
@SuppressWarnings({ "resource", "unchecked", "rawtypes" })
@Repository("generatorDao")
public class GeneratorDaoImpl implements IGeneratorDao {
	String properiesName = "dbconfig.properties";
	PropertiesUtil propertiesUtil = new PropertiesUtil(properiesName);

	@Override
	public void createTable(Map<String, Object> tableInfo) throws TemplateException, IOException {
		String createTableSql = SqlUtils.getSqlUtils().getSqlByID("createTable").getContent();
		// 模版
		// 生成数据库模版
		//String createTableSql = FreeMarkerUtils.initByDefaultTemplate().processToString("oracle.ftl", tableInfo);
		createTableSql = parseSql(createTableSql, tableInfo).trim();
		executeSql(createTableSql);

	}

	private Connection getConnection() {
		try {
			Connection conn = null;
			String dbType = propertiesUtil.getString("connection.dbType");
			String url = propertiesUtil.getString("connection.url");
			String username = propertiesUtil.getString("connection.username");
			String password = propertiesUtil.getString("connection.password");
			String driverClassName = "com.mysql.jdbc.Driver";
			Properties props = new Properties();
			if (username != null) {
				props.put("user", username);
			}
			if (password != null) {
				props.put("password", password);
			}
			if (dbType.equals("sqlserver")) {
				driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
			} else if (dbType.equals("mysql")) {
				driverClassName = "com.mysql.jdbc.Driver";
			} else if (dbType.equals("oracle")) {
				driverClassName = "oracle.jdbc.driver.OracleDriver";
				props.put("remarksReporting", "true");
			}
			// 初始化JDBC驱动并让驱动加载到jvm中
			Class.forName(driverClassName);
			conn = DriverManager.getConnection(url, props);
			conn.setAutoCommit(true);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DbTableInfo> getDbTables() {
		ResultSet resultSet = null;
		Connection connection = null;
		List<DbTableInfo> dbTableInfos = new ArrayList<DbTableInfo>();
		try {
			connection = getConnection();
			connection.setAutoCommit(true);

			String[] types = { "TABLE" };
			// 判断是否为MYSQL
			String driverName = connection.getMetaData().getDriverName().toUpperCase();
			if (driverName.contains("ORACLE")) {
				resultSet = connection.getMetaData().getTables(null, propertiesUtil.getString("connection.username"),
						null, types);
			} else {
				resultSet = connection.getMetaData().getTables(null, null, null, types);
			}
			while (resultSet.next()) {
				String tableName = resultSet.getString("TABLE_NAME");
				String remarks = resultSet.getString("REMARKS");
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
		Connection connection = null;
		List<DbColumnInfo> columnInfos = new ArrayList<DbColumnInfo>();
		try {
			connection = getConnection();
			connection.setAutoCommit(true);
			// 判断是否为MYSQL
			String driverName = connection.getMetaData().getDriverName().toUpperCase();
			// 获得列的信息
			resultSet = connection.getMetaData().getColumns(null, null, tableName, null);
			while (resultSet.next()) {
				// 获得字段名称
				String columnName = resultSet.getString("COLUMN_NAME");
				// 获得字段类型名称
				String typeName = resultSet.getString("TYPE_NAME").toUpperCase();
				// 获得字段大小
				String columnSize = resultSet.getString("COLUMN_SIZE");
				// 获得字段备注
				String remarks = resultSet.getString("REMARKS");
				if (!StringUtils.isEmpty(remarks)){
					remarks=remarks.replace("'","");
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
	public void dropTable(String tableName) {
		String dropSql = SqlUtils.getSqlUtils().getSqlByID("dropTable").getContent();
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
		Connection connection = getConnection();
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

	@Override
	public Boolean isExistTable(String tableName) {
		Connection conn = null;
		ResultSet rs = null;
		String tableNamePattern = tableName;
		try {
			String[] types = { "TABLE" };
			conn = getConnection();
			String dbType = CodeGenUtils.getDbType().toLowerCase();
			if ("oracle".equals(dbType)) {
				tableNamePattern = tableName.toUpperCase();
				// 由于PostgreSQL是大小写敏感的，并默认对SQL语句中的数据库对象名称转换为小写
			} else if ("postgresql".equals(dbType)) {
				tableNamePattern = tableName.toLowerCase();
			}
			DatabaseMetaData dbMetaData = conn.getMetaData();
			rs = dbMetaData.getTables(null, null, tableNamePattern, types);
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		} finally {// 关闭连接
			try {
				if (rs != null) {
					rs.close();
				}
				if (conn != null) {
					conn.close();
				}
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