package com.company.manerger.sys.service.modules.sys.data;

import com.company.manerger.sys.common.utils.PropertiesUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class HySmsSetting implements Serializable {
	public static final String PROPERTIES_PATH = "sms.properties";
	private String apiid;
	private String apikey;

	public HySmsSetting() {

	}

	public void load() {
		load(PROPERTIES_PATH);
	}

	public void load(String propertiesPath) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(propertiesPath);
		this.apiid = propertiesUtil.getString("sms.account.apiid");
		this.apikey = propertiesUtil.getString("sms.account.apikey");
	}

	public void set() {
		set(PROPERTIES_PATH);
	}

	public void set(String propertiesPath) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(propertiesPath);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("sms.account.apiid", apiid);
		dataMap.put("sms.account.apikey", apikey);
		
		propertiesUtil.set(dataMap);
	}

	public String getApiid() {
		return apiid;
	}

	public void setApiid(String apiid) {
		this.apiid = apiid;
	}

	public String getApikey() {
		return apikey;
	}

	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	
}
