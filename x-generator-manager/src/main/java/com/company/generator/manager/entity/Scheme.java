package com.company.generator.manager.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;


@TableName("generator_scheme")
public class Scheme extends AbstractEntity<String> implements java.io.Serializable {

	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 生成模块名 */
	private String moduleName;

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
	private String entityName; // 实体名
	private String tableName; // 实体名
	private String functionName; //方法描述
	@TableField(value = "template_scheme_id")
	private String templateSchemeId; //模板方案ID

	public Scheme() {

	}

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

	public String getTemplateSchemeId() {
		return templateSchemeId;
	}

	public void setTemplateSchemeId(String templateSchemeId) {
		this.templateSchemeId = templateSchemeId;
	}
}
