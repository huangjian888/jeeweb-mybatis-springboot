package cn.jeeweb.modules.codegen.codegenerator.xml.definition;

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
