package cn.jeeweb.core.utils.sms.data;

import cn.jeeweb.core.mapper.JsonMapper;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SmsResult implements Serializable {

	private String code;// 返回状态吗
	private String msg; // 返回消息
	private String smsid; // 消息ID
	private Boolean success;// 是否成功
	private String senderName; // 发射器名称

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSmsid() {
		return smsid;
	}

	public void setSmsid(String smsid) {
		this.smsid = smsid;
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Override
	public String toString() {
		return JsonMapper.toJsonString(this);
	}
}
