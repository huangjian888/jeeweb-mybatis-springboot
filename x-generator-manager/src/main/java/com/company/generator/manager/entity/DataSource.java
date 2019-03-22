package com.company.generator.manager.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;

@TableName("generator_data_source")
public class DataSource  extends AbstractEntity<String> implements java.io.Serializable {

	/** 索引关键字 */
	private String dbKey;
	/** 驱动 */
	private String driverClass;
	/** 数据库名称 */
	private String dbName;
	/** 密码 */
	private String dbPassword;
	/** 数据库类型 */
	private String dbType;
	/** 描述 */
	private String description;
	/** id */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** URL */
	private String url;
	/** 帐号 */
	private String dbUser;

	/**
	 * 获取 dbKey
	 * 
	 * @return: String 索引关键字
	 */
	public String getDbKey() {
		return this.dbKey;
	}

	/**
	 * 设置 dbKey
	 * 
	 * @param: dbKey
	 *             索引关键字
	 */
	public void setDbKey(String dbKey) {
		this.dbKey = dbKey;
	}

	/**
	 * 获取 driverClass
	 * 
	 * @return: String 驱动
	 */
	public String getDriverClass() {
		return this.driverClass;
	}

	/**
	 * 设置 driverClass
	 * 
	 * @param: driverClass
	 *             驱动
	 */
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	/**
	 * 获取 dbName
	 * 
	 * @return: String 数据库名称
	 */
	public String getDbName() {
		return this.dbName;
	}

	/**
	 * 设置 dbName
	 * 
	 * @param: dbName
	 *             数据库名称
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	/**
	 * 获取 dbPassword
	 * 
	 * @return: String 密码
	 */
	public String getDbPassword() {
		return this.dbPassword;
	}

	/**
	 * 设置 dbPassword
	 * 
	 * @param: dbPassword
	 *             密码
	 */
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	/**
	 * 获取 dbType
	 * 
	 * @return: String 数据库类型
	 */
	public String getDbType() {
		return this.dbType;
	}

	/**
	 * 设置 dbType
	 * 
	 * @param: dbType
	 *             数据库类型
	 */
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	/**
	 * 获取 description
	 * 
	 * @return: String 描述
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * 设置 description
	 * 
	 * @param: description
	 *             描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 获取 id
	 * 
	 * @return: String id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 url
	 * 
	 * @return: String URL
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 * 设置 url
	 * 
	 * @param: url
	 *             URL
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 获取 dbUser
	 * 
	 * @return: String 帐号
	 */
	public String getDbUser() {
		return this.dbUser;
	}

	/**
	 * 设置 dbUser
	 * 
	 * @param: dbUser
	 *             帐号
	 */
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

}
