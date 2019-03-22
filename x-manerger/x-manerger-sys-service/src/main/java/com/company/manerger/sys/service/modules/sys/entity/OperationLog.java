package com.company.manerger.sys.service.modules.sys.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import com.company.manerger.sys.common.base.mvc.entity.AbstractEntity;

import java.util.Date;

/**
 * @description: 操作日志实体
 */

@TableName("sys_operation_log")
@SuppressWarnings("serial")
public class OperationLog extends AbstractEntity<String> {
	/**成功*/
	public final static  String OPERATION_LOG_SUCCESS="1";
	/**失败*/
	public final static  String OPERATION_LOG_FAIL="0";
    /**编号*/
    @TableId(value = "id", type = IdType.UUID)
	private String id;
    /**日志标题*/
    @TableField(value = "title")
	private String title;
    /**日志内容*/
    @TableField(value = "content")
	private String content;
    /**操作方式*/
    @TableField(value = "log_type")
	private String logType;
	/** 请求URI */
	private String requestUri;
    /**浏览器*/
    @TableField(value = "browser")
	private String browser;
    /**操作系统*/
    @TableField(value = "os")
	private String os;
    /**请求URI*/
    @TableField(value = "operation_ip")
	private String operationIp;
    @TableField(value = "operation_name")
    private String operationName;
    /**操作方法*/
    @TableField(value = "method")
	private String method;
    /**数据*/
    @TableField(value = "params")
	private String params;
    /**异常信息*/
    @TableField(value = "msg")
	private String msg;
    /**请求状态*/
    @TableField(value = "status")
	private String status;
	/** 创建者 */
	@TableField(value = "create_by", el = "createBy.id", fill = FieldFill.INSERT)
	private User createBy;
	/** 创建时间 */
	@TableField(value = "create_date", fill = FieldFill.INSERT)
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date createDate;
	/**
	 * 获取  id
	 *@return String  编号
	 */
	public String getId(){
		return this.id;
	}

	/**
	 * 设置  id
	 *@param id  编号
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * 获取  title
	 *@return String  日志标题
	 */
	public String getTitle(){
		return this.title;
	}

	/**
	 * 设置  title
	 *@param title  日志标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 * 获取  content
	 *@return String  日志内容
	 */
	public String getContent(){
		return this.content;
	}

	/**
	 * 设置  content
	 *@param content  日志内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 * 获取  logType
	 *@return String  操作方式
	 */
	public String getLogType(){
		return this.logType;
	}

	/**
	 * 设置  logType
	 *@param logType  操作方式
	 */
	public void setLogType(String logType){
		this.logType = logType;
	}

	public User getCreateBy() {
		return createBy;
	}

	public void setCreateBy(User createBy) {
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

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	/**
	 * 获取  browser
	 *@return String  浏览器
	 */
	public String getBrowser(){
		return this.browser;
	}

	/**
	 * 设置  browser
	 *@param browser  浏览器
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

	public String getOperationIp() {
		return operationIp;
	}

	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}

	public String getOperationName() {
		return operationName;
	}

	public void setOperationName(String operationName) {
		this.operationName = operationName;
	}
	/**
	 * 获取  method
	 *@return String  操作方法
	 */
	public String getMethod(){
		return this.method;
	}

	/**
	 * 设置  method
	 *@param method  操作方法
	 */
	public void setMethod(String method){
		this.method = method;
	}
	/**
	 * 获取  params
	 *@return String  数据
	 */
	public String getParams(){
		return this.params;
	}

	/**
	 * 设置  params
	 *@param params  数据
	 */
	public void setParams(String params){
		this.params = params;
	}
	/**
	 * 获取  msg
	 *@return String  异常信息
	 */
	public String getMsg(){
		return this.msg;
	}

	/**
	 * 设置  msg
	 *@param msg  异常信息
	 */
	public void setMsg(String msg){
		this.msg = msg;
	}
	/**
	 * 获取  status
	 *@return String  请求状态
	 */
	public String getStatus(){
		return this.status;
	}

	/**
	 * 设置  status
	 *@param status  请求状态
	 */
	public void setStatus(String status){
		this.status = status;
	}
	
}