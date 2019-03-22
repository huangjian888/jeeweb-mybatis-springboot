package com.company.manerger.sys.service.modules.sys.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;

import java.util.Date;

/**
 *
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.entity
 * @title: 用户表实体
 * @description: 用户表实体
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */

@TableName("store_user")
@SuppressWarnings("serial")
public class StoreUser extends AbstractEntity<String> {

    /**字段主键*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**创建者*/
    @TableField(value = "create_by",el="createBy.id")
	private StoreUser createBy;
    /**创建时间*/
    @TableField(value = "create_date")
	private Date createDate;
    /**更新者*/
    @TableField(value = "update_by",el="updateBy.id")
	private StoreUser updateBy;
    /**更新时间*/
    @TableField(value = "update_date")
	private Date updateDate;
    /**删除标记（0：正常；1：删除）*/
    @TableField(value = "del_flag")
	private String delFlag;
    /**备注信息*/
    @TableField(value = "remarks")
	private String remarks;
    /**真实名称*/
    @TableField(value = "realname")
	private String realname;
    /**用户名*/
    @TableField(value = "username")
	private String username;
    /**头像*/
    @TableField(value = "portrait")
	private String portrait;
    /**密码*/
    @TableField(value = "password")
	private String password;
    /**盐*/
    @TableField(value = "salt")
	private String salt;
    /**邮件*/
    @TableField(value = "email")
	private String email;
    /**联系电话*/
    @TableField(value = "phone")
	private String phone;
    /**用户的状态*/
    @TableField(value = "status")
	private String status;
	
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
	 * 获取  createBy
	 *@return User  创建者
	 */
	public StoreUser getCreateBy(){
		return this.createBy;
	}

	/**
	 * 设置  createBy
	 *@param createBy  创建者
	 */
	public void setCreateBy(StoreUser createBy){
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
	public StoreUser getUpdateBy(){
		return this.updateBy;
	}

	/**
	 * 设置  updateBy
	 *@param updateBy  更新者
	 */
	public void setUpdateBy(StoreUser updateBy){
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
	/**
	 * 获取  realname
	 *@return String  真实名称
	 */
	public String getRealname(){
		return this.realname;
	}

	/**
	 * 设置  realname
	 *@param realname  真实名称
	 */
	public void setRealname(String realname){
		this.realname = realname;
	}
	/**
	 * 获取  username
	 *@return String  用户名
	 */
	public String getUsername(){
		return this.username;
	}

	/**
	 * 设置  username
	 *@param username  用户名
	 */
	public void setUsername(String username){
		this.username = username;
	}
	/**
	 * 获取  portrait
	 *@return String  头像
	 */
	public String getPortrait(){
		return this.portrait;
	}

	/**
	 * 设置  portrait
	 *@param portrait  头像
	 */
	public void setPortrait(String portrait){
		this.portrait = portrait;
	}
	/**
	 * 获取  password
	 *@return String  密码
	 */
	public String getPassword(){
		return this.password;
	}

	/**
	 * 设置  password
	 *@param password  密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	/**
	 * 获取  salt
	 *@return String  盐
	 */
	public String getSalt(){
		return this.salt;
	}

	/**
	 * 设置  salt
	 *@param salt  盐
	 */
	public void setSalt(String salt){
		this.salt = salt;
	}
	/**
	 * 获取  email
	 *@return String  邮件
	 */
	public String getEmail(){
		return this.email;
	}

	/**
	 * 设置  email
	 *@param email  邮件
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 * 获取  phone
	 *@return String  联系电话
	 */
	public String getPhone(){
		return this.phone;
	}

	/**
	 * 设置  phone
	 *@param phone  联系电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 * 获取  status
	 *@return String  用户的状态
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  用户的状态
	 */
	public void setStatus(String status){
		this.status = status;
	}

	public String getCredentialsSalt() {
		return username + salt;
	}
	
}