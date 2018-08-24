package cn.jeeweb.core.utils.email;

import cn.jeeweb.core.mapper.JsonMapper;

import java.io.Serializable;

@SuppressWarnings("serial")
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

	@Override
	public String toString() {
		return JsonMapper.toJsonString(this);
	}
}
