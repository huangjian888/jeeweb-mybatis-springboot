package com.company.manerger.sys.common.email.data;

import java.io.Serializable;

public class EmailResult implements Serializable {

	private String msg; // 返回消息
	private Boolean success;// 是否成功

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean isSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public static EmailResult fail(String msg) {
		EmailResult emailResult = new EmailResult();
		emailResult.setSuccess(Boolean.FALSE);
		emailResult.setMsg(msg);
		return emailResult;
	}

	public static EmailResult success(String msg) {
		EmailResult emailResult = new EmailResult();
		emailResult.setSuccess(Boolean.TRUE);
		emailResult.setMsg(msg);
		return emailResult;
	}
}
