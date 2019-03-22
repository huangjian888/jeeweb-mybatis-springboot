package com.company.generator.manager.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;


@TableName("generator_template_scheme")
public class TemplateScheme extends AbstractEntity<String> implements java.io.Serializable {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**方案标题*/
    @TableField(value = "title")
	private String title;
    /**方案描述*/
    @TableField(value = "description")
	private String description;
	
	/**
	 * 获取  id
	 *@return: String  字段主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param: id  字段主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  title
	 *@return: String  方案标题
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * 设置  title
	 *@param: title  方案标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * 获取  description
	 *@return: String  方案描述
	 */
	public String getDescription(){
		return this.description;
	}

	/**
	 * 设置  description
	 *@param: description  方案描述
	 */
	public void setDescription(String description){
		this.description = description;
	}
	
}
