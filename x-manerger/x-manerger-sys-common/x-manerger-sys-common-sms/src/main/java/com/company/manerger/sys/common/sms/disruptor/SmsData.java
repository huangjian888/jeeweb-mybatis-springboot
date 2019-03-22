package com.company.manerger.sys.common.sms.disruptor;

import com.company.manerger.sys.common.sms.config.SmsConfigProperties;
import java.io.Serializable;
import java.util.Map;

public class SmsData implements Serializable {
	private String phone;
	private String smsTemplate;
	private SmsConfigProperties smsConfigProperties;
	private Map<String,Object> datas;

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public SmsConfigProperties getSmsConfigProperties() {
		return smsConfigProperties;
	}

	public void setSmsConfigProperties(SmsConfigProperties smsConfigProperties) {
		this.smsConfigProperties = smsConfigProperties;
	}

	public Map<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

	public String getSmsTemplate() {
		return smsTemplate;
	}

	public void setSmsTemplate(String smsTemplate) {
		this.smsTemplate = smsTemplate;
	}
}
