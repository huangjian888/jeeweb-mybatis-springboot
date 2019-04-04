package com.company.generator.manager.common.definition.data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

@SuppressWarnings("serial")
@XmlRootElement(name = "definition")
public class Definition implements Serializable {
	// 定义名称
	private String name;
	// 数据库KEY
	private String dbType;
	// 默认连接字符串
	private String dbUrl;
	//  名称
	private String dbDriver;
	// 定义描述
	private String description;

	// 数据库的定义
	private Db db;
	// 数据导入的时候，类型与JAVA类型的判断
	private List<Type> dbtojavaTypes;
	// java类型与class全路径的对应
	private List<Type> javatoclassTypes;

	@XmlElement(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlElement(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlElement(name = "db-type")
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	@XmlElement(name = "db-url")
	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	@XmlElement(name = "db-driver")
	public String getDbDriver() {
		return dbDriver;
	}

	public void setDbDriver(String dbDriver) {
		this.dbDriver = dbDriver;
	}

	@XmlElement(name = "db")
	public Db getDb() {
		return db;
	}

	public void setDb(Db db) {
		this.db = db;
	}

	@XmlElementWrapper(name = "dbtojava-types")
	@XmlElements({ @XmlElement(name = "type", type = Type.class) })
	public List<Type> getDbtojavaTypes() {
		return dbtojavaTypes;
	}

	public void setDbtojavaTypes(List<Type> dbtojavaTypes) {
		this.dbtojavaTypes = dbtojavaTypes;
	}

	@XmlElementWrapper(name = "javatoclass-types")
	@XmlElements({ @XmlElement(name = "type", type = Type.class) })
	public List<Type> getJavatoclassTypes() {
		return javatoclassTypes;
	}

	public void setJavatoclassTypes(List<Type> javatoclassTypes) {
		this.javatoclassTypes = javatoclassTypes;
	}
}
