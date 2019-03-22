package com.company.manerger.sys.service.modules.sys.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @description: 登陆日志实体
 */

@TableName("sys_login_log")
@SuppressWarnings("serial")
public class LoginLog extends AbstractEntity<String> {

    /**访问ID*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**登录账号*/
	@Excel(name = "登录账号", orderNum = "0",width = 15)
    @TableField(value = "login_name")
	@ApiModelProperty("登录账号")
	private String loginName;
    /**登录IP地址*/
    @TableField(value = "login_ip")
	@Excel(name = "登录IP", orderNum = "1",width = 20)
	@ApiModelProperty("登录IP")
	private String loginIp;
    /**登录地点*/
	@Excel(name = "登录地点", orderNum = "2")
    @TableField(value = "login_location")
	@ApiModelProperty("登录地点")
	private String loginLocation;
    /**浏览器类型*/
	@Excel(name = "浏览器类型", orderNum = "3")
    @TableField(value = "browser")
	@ApiModelProperty("浏览器类型")
	private String browser;
    /**操作系统*/
	@Excel(name = "操作系统", orderNum = "4",width = 15)
    @TableField(value = "os")
	@ApiModelProperty("操作系统")
	private String os;
    /**登录状态（1成功 -1失败）*/
	@Excel(name = "操作系统",replace= {"成功_1", "失败_-1", "退出_0"}, orderNum = "5")
    @TableField(value = "status")
	@ApiModelProperty("操作系统")
	private String status;
    /**提示消息*/
	@Excel(name = "提示消息", orderNum = "6",width = 20)
	@ApiModelProperty("提示消息")
    @TableField(value = "msg")
	private String msg;
    /**访问时间*/
	@Excel(name = "操作时间", orderNum = "7",format="yyyy-MM-dd HH:mm:ss",width = 30)
    @TableField(value = "login_time")
	@ApiModelProperty("操作时间")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date loginTime;
	
	/**
	 * 获取  id
	 *@return String  访问ID
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  访问ID
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  loginName
	 *@return String  登录账号
	 */
	public String getLoginName(){
		return this.loginName;
	}

	/**
	 * 设置  loginName
	 *@param loginName  登录账号
	 */
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	/**
	 * 获取  loginIp
	 *@return String  登录IP地址
	 */
	public String getLoginIp(){
		return this.loginIp;
	}

	/**
	 * 设置  loginIp
	 *@param loginIp  登录IP地址
	 */
	public void setLoginIp(String loginIp){
		this.loginIp = loginIp;
	}
	/**
	 * 获取  loginLocation
	 *@return String  登录地点
	 */
	public String getLoginLocation(){
		return this.loginLocation;
	}

	/**
	 * 设置  loginLocation
	 *@param loginLocation  登录地点
	 */
	public void setLoginLocation(String loginLocation){
		this.loginLocation = loginLocation;
	}
	/**
	 * 获取  browser
	 *@return String  浏览器类型
	 */
	public String getBrowser(){
		return this.browser;
	}

	/**
	 * 设置  browser
	 *@param browser  浏览器类型
	 */
	public void setBrowser(String browser){
		this.browser = browser;
	}
	/**
	 * 获取  os
	 *@return String  操作系统
	 */
	public String getOs(){
		return this.os;
	}

	/**
	 * 设置  os
	 *@param os  操作系统
	 */
	public void setOs(String os){
		this.os = os;
	}
	/**
	 * 获取  status
	 *@return String  登录状态（0成功 1失败）
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  登录状态（0成功 1失败）
	 */
	public void setStatus(String status){
		this.status = status;
	}
	/**
	 * 获取  msg
	 *@return String  提示消息
	 */
	public String getMsg(){
		return this.msg;
	}

	/**
	 * 设置  msg
	 *@param msg  提示消息
	 */
	public void setMsg(String msg){
		this.msg = msg;
	}
	/**
	 * 获取  loginTime
	 *@return Date  访问时间
	 */
	public Date getLoginTime(){
		return this.loginTime;
	}

	/**
	 * 设置  loginTime
	 *@param loginTime  访问时间
	 */
	public void setLoginTime(Date loginTime){
		this.loginTime = loginTime;
	}
	
}