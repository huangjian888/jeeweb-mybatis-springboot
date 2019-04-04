package com.company.manerger.sys.common.sms.data;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SmsResult implements Serializable {
	public static  final int OK_CODE = 0;
	public static  final int ERROR_CODE = 500;

	private int code;// 返回状态吗
	private String msg; // 返回消息
	private String smsid; // 消息ID
	private String reponseData;// 返回的数据,转换为json

	public Boolean isSuccess(){
		if (code == OK_CODE){
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	public SmsResult() {
		code = 0;
		this.msg = "返回成功";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
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

	public String getReponseData() {
		return reponseData;
	}

	public void setReponseData(String reponseData) {
		this.reponseData = reponseData;
	}

	public static SmsResult success(){
		return new SmsResult();
	}

	public static SmsResult success(String msg){
		return fail(OK_CODE,msg);
	}


	public static SmsResult fail(String msg){
		return fail(ERROR_CODE,msg);
	}

	public static SmsResult fail(int code, String msg) {
		SmsResult smsResult = new SmsResult();
		smsResult.setCode(code);
		smsResult.setMsg(msg);
		return smsResult;
	}
}
