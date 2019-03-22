package com.company.manerger.sys.service.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;

import java.util.Date;

/**
 *
 * @version V1.0
 * @package com.company.manerger.sys.service.modules.sys.entity
 * @title: 品牌功能实体
 * @description: 品牌实体实体
 * @date: 2018-11-27 13:55:10
 */

@TableName("sys_grand")
@SuppressWarnings("serial")
public class Grand extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**名字*/
    @TableField(value = "name")
	private String name;
    /**logo*/
    @TableField(value = "company_logo")
	private String companyLogo;
    /**公司名称*/
    @TableField(value = "company_name")
	private String companyName;
    /**公司描述*/
    @TableField(value = "company_describe")
	private String companyDescribe;
    /**联系信息*/
    @TableField(value = "contact")
	private String contact;
	@TableField(value = "remarks")
	protected String remarks; // 备注
	@TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
	protected User createBy; // 创建者
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	protected Date createDate; // 创建日期
	@TableField(value = "update_by", el = "updateBy.id", fill = FieldFill.UPDATE)
	protected User updateBy; // 更新者
	@TableField(value = "update_date", fill = FieldFill.UPDATE)
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	protected Date updateDate; // 更新日期
	@TableField(value = "del_flag", fill = FieldFill.INSERT)
	protected String delFlag = "0"; // 删除标记（0：正常；1：删除 ）


	/**
	 * 获取  id
	 *@return String  字段主键
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  字段主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  name
	 *@return String  名字
	 */
	public String getName(){
		return this.name;
	}

	/**
	 * 设置  name
	 *@param name  名字
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 * 获取  companyLogo
	 *@return String  companyLogo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}
	/**
	 * 设置  companyLogo
	 *@param companyLogo  log
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	/**
	 * 获取  companyName
	 *@return String  公司名称
	 */
	public String getCompanyName(){
		return this.companyName;
	}

	/**
	 * 设置  companyName
	 *@param companyName  公司名称
	 */
	public void setCompanyName(String companyName){
		this.companyName = companyName;
	}
	/**
	 * 获取  companyDescribe
	 *@return String  公司描述
	 */
	public String getCompanyDescribe(){
		return this.companyDescribe;
	}

	/**
	 * 设置  companyDescribe
	 *@param companyDescribe  公司描述
	 */
	public void setCompanyDescribe(String companyDescribe){
		this.companyDescribe = companyDescribe;
	}
	/**
	 * 获取  contact
	 *@return String  联系信息
	 */
	public String getContact(){
		return this.contact;
	}

	/**
	 * 设置  contact
	 *@param contact  联系信息
	 */
	public void setContact(String contact){
		this.contact = contact;
	}
	/**
	 * 获取  createBy
	 *@return User  创建者
	 */
	public User getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param createBy  创建者
	 */
	public void setCreateBy(User createBy){
		this.createBy = createBy;
	}
	/**
	 * 获取  createDate
	 *@return Date  创建时间
	 */
	public Date getCreateDate(){
		return this.createDate;
	}

	/**
	 * 设置  createDate
	 *@param createDate  创建时间
	 */
	public void setCreateDate(Date createDate){
		this.createDate = createDate;
	}
	/**
	 * 获取  updateBy
	 *@return User  更新者
	 */
	public User getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param updateBy  更新者
	 */
	public void setUpdateBy(User updateBy){
		this.updateBy = updateBy;
	}
	/**
	 * 获取  updateDate
	 *@return Date  更新时间
	 */
	public Date getUpdateDate(){
		return this.updateDate;
	}

	/**
	 * 设置  updateDate
	 *@param updateDate  更新时间
	 */
	public void setUpdateDate(Date updateDate){
		this.updateDate = updateDate;
	}
	/**
	 * 获取  delFlag
	 *@return String  删除标记（0：正常；1：删除）
	 */
	public String getDelFlag(){
		return this.delFlag;
	}

	/**
	 * 设置  delFlag
	 *@param delFlag  删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag){
		this.delFlag = delFlag;
	}
	/**
	 * 获取  remarks
	 *@return String  备注信息
	 */
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 * 设置  remarks
	 *@param remarks  备注信息
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}


}