package cn.jeeweb.modules.codegen.entity;

import cn.jeeweb.core.common.entity.DataEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * @Title: 生成方案
 * @Description: 代码生成方案
 * @author jeeweb
 * @date 2017-05-29 21:17:42
 * @version V1.0
 *
 */
@TableName("codegen_scheme")
@SuppressWarnings("serial")
public class Scheme extends DataEntity<String> {

	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 生成模块名 */
	private String moduleName;

	/** 生成子模块名 */
	private String subModuleName;

	/** 生成包路径 */
	private String packageName;

	/** 表类型 */
	private String tableType;

	/** 生成功能作者 */
	private String functionAuthor;
	/** 生成功能名（简写） */
	private String functionDesc;
	/** 生成表编号 */
	// 表的ID
	@TableField(value = "table_id", el = "table.id")
	private Table table;
	private String entityName = ""; // 实体名
	private String tableName = ""; // 实体名
	private String functionName;
	private String pathName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 moduleName
	 * 
	 * @return: String 生成模块名
	 */
	public String getModuleName() {
		return this.moduleName;
	}

	/**
	 * 设置 moduleName
	 * 
	 * @param: moduleName
	 *             生成模块名
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	/**
	 * 获取 subModuleName
	 * 
	 * @return: String 生成子模块名
	 */
	public String getSubModuleName() {
		return this.subModuleName;
	}

	/**
	 * 设置 subModuleName
	 * 
	 * @param: subModuleName
	 *             生成子模块名
	 */
	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	/**
	 * 获取 packageName
	 * 
	 * @return: String 生成包路径
	 */
	public String getPackageName() {
		return this.packageName;
	}

	/**
	 * 设置 packageName
	 * 
	 * @param: packageName
	 *             生成包路径
	 */
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	/**
	 * 
	 * 
	 * /** 获取 tableType
	 * 
	 * @return: String 表类型
	 */

	public String getTableType() {
		return this.tableType;
	}

	/**
	 * 设置 tableType
	 * 
	 * @param: tableType
	 *             表类型
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	/**
	 * 获取 functionAuthor
	 * 
	 * @return: String 生成功能作者
	 */
	public String getFunctionAuthor() {
		return this.functionAuthor;
	}

	/**
	 * 设置 functionAuthor
	 * 
	 * @param: functionAuthor
	 *             生成功能作者
	 */
	public void setFunctionAuthor(String functionAuthor) {
		this.functionAuthor = functionAuthor;
	}

	/**
	 * 获取 functionDesc
	 * 
	 * @return: String 生成功能名（简写）
	 */
	public String getFunctionDesc() {
		return this.functionDesc;
	}

	/**
	 * 设置 functionDesc
	 * 
	 * @param: functionDesc
	 *             生成功能名（简写）
	 */
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}

	/**
	 * 获取 functionName
	 * 
	 * @return: String 生成功能名
	 */
	/** 生成功能名 */
	public String getFunctionName() {
		return this.functionName;
	}

	/**
	 * 设置 functionName
	 * 
	 * @param: functionName
	 *             生成功能名
	 */
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * 获取 pathName
	 * 
	 * @return: String 代码生成目录
	 */
	public String getPathName() {
		return this.pathName;
	}

	/**
	 * 设置 pathName
	 * 
	 * @param: pathName
	 *             代码生成目录
	 */
	public void setPathName(String pathName) {
		this.pathName = pathName;
	}

	public Table getTable() {
		return table;
	}

	public void setTable(Table table) {
		this.table = table;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

}
