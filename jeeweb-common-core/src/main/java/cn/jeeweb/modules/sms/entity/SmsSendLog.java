package cn.jeeweb.modules.sms.entity;

import cn.jeeweb.core.common.entity.AbstractEntity;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;

/**
 * @Title: 短信发送日志
 * @Description: 短信发送日志
 * @author jeeweb
 * @date 2017-06-08 12:56:37
 * @version V1.0
 *
 */
@TableName("sms_send_log")
@SuppressWarnings("serial")
public class SmsSendLog extends AbstractEntity<String> {

	/** 字段主键 */
	@TableId(value = "id", type = IdType.UUID)
	private String id;
	/** 备注信息 */
	private String remarks;
	/** 业务类型 */
	private String businessType;

	/** 联系电话 */
	private String phone;
	/** 模板ID */
	private String templateId;
	/** 模板类型 */
	private String templateContent;
	/** 发送数据 */
	private String senddata;
	/** 发送状态 */
	private String status; // 0发送中，1成功，-1失败
	/** 发送响应消息ID */
	private String smsid;
	/** 返回码 */
	private String code;
	/** 返回消息 */
	private String msg;
	/** 删除标记（0：正常；1：删除） */
	private String delFlag;
	/** 响应时间 */
	private Date responseDate;

	/**
	 * 获取 id
	 * 
	 * @return: String 字段主键
	 */

	public String getId() {
		return this.id;
	}

	/**
	 * 设置 id
	 * 
	 * @param: id
	 *             字段主键
	 */
	public void setId(String id) {
		this.id = id;
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
	 * 获取 phone
	 * 
	 * @return: String 联系电话
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 * 设置 phone
	 * 
	 * @param: phone
	 *             联系电话
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取 templateId
	 * 
	 * @return: String 模板ID
	 */
	public String getTemplateId() {
		return this.templateId;
	}

	/**
	 * 设置 templateId
	 * 
	 * @param: templateId
	 *             模板ID
	 */
	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	/**
	 * 获取 templateContent
	 * 
	 * @return: String 模板类型
	 */
	public String getTemplateContent() {
		return this.templateContent;
	}

	/**
	 * 设置 templateContent
	 * 
	 * @param: templateContent
	 *             模板类型
	 */
	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
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
	 * 获取 smsid
	 * 
	 * @return: String 发送响应消息ID
	 */
	public String getSmsid() {
		return this.smsid;
	}

	/**
	 * 设置 smsid
	 * 
	 * @param: smsid
	 *             发送响应消息ID
	 */
	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	/**
	 * 获取 code
	 * 
	 * @return: String 返回码
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * 设置 code
	 * 
	 * @param: code
	 *             返回码
	 */
	public void setCode(String code) {
		this.code = code;
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
}
