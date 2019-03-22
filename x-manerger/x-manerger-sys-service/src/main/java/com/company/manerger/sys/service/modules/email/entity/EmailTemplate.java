package com.company.manerger.sys.service.modules.email.entity;


import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.service.common.entity.DataEntity;

/**
 * @description: 邮件模板实体
 */
@TableName("email_template")
@SuppressWarnings("serial")
public class EmailTemplate extends DataEntity<String> {

    /**主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**模版名称*/
    @TableField(value = "name")
	private String name;
    /**模版编码*/
    @TableField(value = "code")
	private String code;
    /**模版主题*/
    @TableField(value = "template_subject")
	private String templateSubject;
    /**模版内容*/
    @TableField(value = "template_content")
	private String templateContent;

	
	/**
	 * 获取  id
	 *@return String  主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return String  模版名称
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  模版名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  code
	 *@return String  模版编码
	 */
	public String getCode(){
		return this.code;
	}

	/**
	 * 设置  code
	 *@param code  模版编码
	 */
	public void setCode(String code){
		this.code = code;
	}
	/**
	 * 获取  templateSubject
	 *@return String  模版主题
	 */
	public String getTemplateSubject(){
		return this.templateSubject;
	}

	/**
	 * 设置  templateSubject
	 *@param templateSubject  模版主题
	 */
	public void setTemplateSubject(String templateSubject){
		this.templateSubject = templateSubject;
	}
	/**
	 * 获取  templateContent
	 *@return String  模版内容
	 */
	public String getTemplateContent(){
		return this.templateContent;
	}

	/**
	 * 设置  templateContent
	 *@param templateContent  模版内容
	 */
	public void setTemplateContent(String templateContent){
		this.templateContent = templateContent;
	}
}