package com.company.generator.manager.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;


@TableName("generator_template")
public class Template extends AbstractEntity<String> implements java.io.Serializable {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**模板名称*/
    @TableField(value = "name")
	private String name;
    /**标识*/
    @TableField(value = "key")
	private String key;
    /**模板内容*/
    @TableField(value = "template_content")
	private String templateContent;
    /**方案ID*/
    @TableField(value = "scheme_id")
	private String schemeId;
    /**文件名格式*/
    @TableField(value = "name_format")
	private String nameFormat;
	/**文件名下滑线命名*/
	@TableField(value = "name_underline")
	private String nameUnderline;
	/**是否开启包*/
	@TableField(value = "enable_package")
	private String enablePackage;
	/**生成目录*/
	@TableField(value = "target_package")
	private String targetPackage;
    /**生成目录*/
    @TableField(value = "target_path")
	private String targetPath;
	@TableField(value = "sort")
    private Integer sort;
	
	/**
	 * 获取  id
	 *@return: String  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return: String  模板名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param: name  模板名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  key
	 *@return: String  标识
	 */
	public String getKey(){
		return this.key;
	}

	/**
	 * 设置  key
	 *@param: key  标识
	 */
	public void setKey(String key){
		this.key = key;
	}

	/**
	 * 获取  templateContent
	 *@return: String  模板内容
	 */
	public String getTemplateContent(){
		return this.templateContent;
	}

	/**
	 * 设置  templateContent
	 *@param: templateContent  模板内容
	 */
	public void setTemplateContent(String templateContent){
		this.templateContent = templateContent;
	}

	public String getSchemeId() {
		return schemeId;
	}

	public void setSchemeId(String schemeId) {
		this.schemeId = schemeId;
	}

	/**
	 * 获取  nameFormat
	 *@return: String  文件名格式
	 */
	public String getNameFormat(){
		return this.nameFormat;
	}

	/**
	 * 设置  nameFormat
	 *@param: nameFormat  文件名格式
	 */
	public void setNameFormat(String nameFormat){
		this.nameFormat = nameFormat;
	}

	public String getNameUnderline() {
		return nameUnderline;
	}

	public void setNameUnderline(String nameUnderline) {
		this.nameUnderline = nameUnderline;
	}

	public String getEnablePackage() {
		return enablePackage;
	}

	public void setEnablePackage(String enablePackage) {
		this.enablePackage = enablePackage;
	}

	public String getTargetPackage() {
		return targetPackage;
	}

	public void setTargetPackage(String targetPackage) {
		this.targetPackage = targetPackage;
	}

	public String getTargetPath() {
		return targetPath;
	}

	public void setTargetPath(String targetPath) {
		this.targetPath = targetPath;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}
}
