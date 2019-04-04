package com.company.manerger.sys.service.modules.sys.data;

import com.company.manerger.sys.common.utils.PropertiesUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class CloudSmsSetting implements Serializable {
	public static final String PROPERTIES_PATH = "sms.properties";
	private String serverip;
	private String serverport;
	private String accountsid;
	private String accounttoken;
	private String appid;

	public CloudSmsSetting() {

	}

	public void load() {
		load(PROPERTIES_PATH);
	}

	public void load(String propertiesPath) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(propertiesPath);
		this.serverip = propertiesUtil.getString("sms.serverip");
		this.serverport = propertiesUtil.getString("sms.serverport");
		this.accountsid = propertiesUtil.getString("sms.accountsid");
		this.accounttoken = propertiesUtil.getString("sms.accounttoken");
		this.appid = propertiesUtil.getString("sms.appid");
	}

	public void set() {
		set(PROPERTIES_PATH);
	}

	public void set(String propertiesPath) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(propertiesPath);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("sms.serverip", serverip);
		dataMap.put("sms.serverport", serverport);
		dataMap.put("sms.accountsid", accountsid);
		dataMap.put("sms.accounttoken", accounttoken);
		dataMap.put("sms.appid", appid);
		
		propertiesUtil.set(dataMap);
	}

	public String getServerip() {
		return serverip;
	}

	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	public String getServerport() {
		return serverport;
	}

	public void setServerport(String serverport) {
		this.serverport = serverport;
	}

	public String getAccountsid() {
		return accountsid;
	}

	public void setAccountsid(String accountsid) {
		this.accountsid = accountsid;
	}

	public String getAccounttoken() {
		return accounttoken;
	}

	public void setAccounttoken(String accounttoken) {
		this.accounttoken = accounttoken;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
}
