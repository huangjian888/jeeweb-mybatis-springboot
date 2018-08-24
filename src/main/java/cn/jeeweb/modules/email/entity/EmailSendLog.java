package cn.jeeweb.modules.email.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * @Title: 邮件发送日志
 * @Description: 邮件发送日志
 * @author jeeweb
 * @date 2017-06-10 07:46:06
 * @version V1.0
 *
 */
@TableName("email_send_log")
@SuppressWarnings("serial")
public class EmailSendLog extends AbstractEntity<String> {

	/** id */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 联系电话 */
	private String email;
	/** 主题 */
	private String subject;
	/** 模板类型 */
	private String content;
	/** 发送数据 */
	private String senddata;
	/** 响应时间 */
	private Date responseDate;
	/** 业务类型 */
	private String businessType;
	/** 删除标记（0：正常；1：删除） */
	private String delFlag;
	/** 发送状态 */
	private String status;
	/** 返回消息 */
	private String msg;
	/** 备注信息 */
	private String remarks;

	/**
	 * 获取 id
	 * 
	 * @return: String id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 获取 email
	 * 
	 * @return: String 联系电话
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 设置 email
	 * 
	 * @param: email
	 *             联系电话
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获取 subject
	 * 
	 * @return: String 主题
	 */
	public String getSubject() {
		return this.subject;
	}

	/**
	 * 设置 subject
	 * 
	 * @param: subject
	 *             主题
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 获取 content
	 * 
	 * @return: String 模板类型
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置 content
	 * 
	 * @param: content
	 *             模板类型
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * 获取 senddata
	 * 
	 * @return: String 发送数据
	 */
	public String getSenddata() {
		return this.senddata;
	}

	/**
	 * 设置 senddata
	 * 
	 * @param: senddata
	 *             发送数据
	 */
	public void setSenddata(String senddata) {
		this.senddata = senddata;
	}

	/**
	 * 获取 responseDate
	 * 
	 * @return: Date 响应时间
	 */
	public Date getResponseDate() {
		return this.responseDate;
	}

	/**
	 * 设置 responseDate
	 * 
	 * @param: responseDate
	 *             响应时间
	 */
	public void setResponseDate(Date responseDate) {
		this.responseDate = responseDate;
	}

	/**
	 * 获取 businessType
	 * 
	 * @return: String 业务类型
	 */
	public String getBusinessType() {
		return this.businessType;
	}

	/**
	 * 设置 businessType
	 * 
	 * @param: businessType
	 *             业务类型
	 */
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	/**
	 * 获取 delFlag
	 * 
	 * @return: String 删除标记（0：正常；1：删除）
	 */
	public String getDelFlag() {
		return this.delFlag;
	}

	/**
	 * 设置 delFlag
	 * 
	 * @param: delFlag
	 *             删除标记（0：正常；1：删除）
	 */
	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	/**
	 * 获取 status
	 * 
	 * @return: String 发送状态
	 */
	public String getStatus() {
		return this.status;
	}

	/**
	 * 设置 status
	 * 
	 * @param: status
	 *             发送状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 获取 msg
	 * 
	 * @return: String 返回消息
	 */
	public String getMsg() {
		return this.msg;
	}

	/**
	 * 设置 msg
	 * 
	 * @param: msg
	 *             返回消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 获取 remarks
	 * 
	 * @return: String 备注信息
	 */
	public String getRemarks() {
		return this.remarks;
	}

	/**
	 * 设置 remarks
	 * 
	 * @param: remarks
	 *             备注信息
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
