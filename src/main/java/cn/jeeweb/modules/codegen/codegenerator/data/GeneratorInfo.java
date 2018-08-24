package cn.jeeweb.modules.codegen.codegenerator.data;

import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.codegen.entity.Column;
import cn.jeeweb.modules.codegen.entity.Table;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class GeneratorInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	private String pathName;// 生成的路径
	private String entityName = ""; // 实体名
	private String packageName = ""; // 包名
	private String moduleName = "";// 模块名
	private String subModuleName = "";// 子模块名
	private String functionDesc = "";// 功能描述
	private String functionName = "";// 功能名称
	private String functionAuthor = "";// 功能作者
	private String type;// 1,2,3.4
	private List<String> generatorKeys; // 生成器
	private String time = ""; // 时间
	private String tableName = ""; // 表名
	private String generatorType = "uuid";// 主键生成的类型
	private List<AttributeInfo> attributeInfos;
	private List<Column> columns;
	private List<String> importTypes;
	private List<Table> schedules;

	public String getPathName() {
		return pathName;
	}

	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getTime() {
		if ("".equals(time)) {
			Date nowTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			time = formatter.format(nowTime);
		}
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<AttributeInfo> getAttributeInfos() {
		return attributeInfos;
	}

	public void setAttributeInfos(List<AttributeInfo> attributeInfos) {
		this.attributeInfos = attributeInfos;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getImportTypes() {
		return importTypes;
	}

	public void setImportTypes(List<String> importTypes) {
		this.importTypes = importTypes;
	}

	public String getGeneratorType() {
		return generatorType;
	}

	public void setGeneratorType(String generatorType) {
		this.generatorType = generatorType;
	}

	public String getModuleName() {
		if (!StringUtils.isEmpty(moduleName)) {
			moduleName = moduleName.toLowerCase();
		}
		return moduleName.toLowerCase();
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getSubModuleName() {
		if (!StringUtils.isEmpty(subModuleName)) {
			subModuleName = subModuleName.toLowerCase();
		}
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public String getFunctionDesc() {
		return functionDesc;
	}

	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionAuthor() {
		return functionAuthor;
	}

	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}

	public List<String> getGeneratorKeys() {
		return generatorKeys;
	}

	public void setGeneratorKeys(List<String> generatorKeys) {
		this.generatorKeys = generatorKeys;
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Table> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Table> schedules) {
		this.schedules = schedules;
	}

}
