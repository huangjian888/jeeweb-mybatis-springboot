package cn.jeeweb.modules.codegen.codegenerator.xml.definition;

import javax.xml.bind.annotation.XmlElement;

public class Type {
	private String javaType; // JAVA类型
	private String fullType; // 类型全名
	private String dbType; // 数据库类型

	@XmlElement(name = "java-type")
	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	@XmlElement(name = "full-type")
	public String getFullType() {
		return fullType;
	}

	public void setFullType(String fullType) {
		this.fullType = fullType;
	}

	@XmlElement(name = "db-type")
	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

}