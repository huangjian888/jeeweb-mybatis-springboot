package cn.jeeweb.modules.codegen.codegenerator.xml.definition;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import java.util.List;

public class Db {

	private String allTypes;
	private String charTypes;
	private String floatTypes;
	private String aloneTypes;
	private String blobTypes;
	private List<Sql> sql;

	@XmlElement(name = "all-types")
	public String getAllTypes() {
		return allTypes;
	}

	public void setAllTypes(String allTypes) {
		this.allTypes = allTypes;
	}

	@XmlElement(name = "char-types")
	public String getCharTypes() {
		return charTypes;
	}

	public void setCharTypes(String charTypes) {
		this.charTypes = charTypes;
	}

	@XmlElement(name = "float-types")
	public String getFloatTypes() {
		return floatTypes;
	}

	public void setFloatTypes(String floatTypes) {
		this.floatTypes = floatTypes;
	}

	@XmlElement(name = "alone-types")
	public String getAloneTypes() {
		return aloneTypes;
	}

	public void setAloneTypes(String aloneTypes) {
		this.aloneTypes = aloneTypes;
	}

	@XmlElement(name = "blob-types")
	public String getBlobTypes() {
		return blobTypes;
	}

	public void setBlobTypes(String blobTypes) {
		this.blobTypes = blobTypes;
	}

	@XmlElementWrapper(name = "sqls")
	@XmlElements({ @XmlElement(name = "sql", type = Sql.class) })
	public List<Sql> getSql() {
		return sql;
	}

	public void setSql(List<Sql> sql) {
		this.sql = sql;
	}

}