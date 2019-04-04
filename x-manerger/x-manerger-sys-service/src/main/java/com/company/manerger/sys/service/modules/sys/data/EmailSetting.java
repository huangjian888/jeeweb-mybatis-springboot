package com.company.manerger.sys.service.modules.sys.data;

import com.company.manerger.sys.common.utils.PropertiesUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


@SuppressWarnings("serial")
public class EmailSetting implements Serializable {
	public static final String PROPERTIES_PATH = "email.properties";
	private String host = "";
	private String port = "25";
	private Boolean auth = Boolean.TRUE;
	private String username = "";
	private String password = "";
	private String sender = "";

	public EmailSetting() {

	}

	public void load() {
		load(PROPERTIES_PATH);
	}

	public void load(String propertiesPath) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(propertiesPath);
		this.host = propertiesUtil.getString("mail.smtp.host");
		this.port = propertiesUtil.getString("mail.smtp.port");
		this.auth = propertiesUtil.getBoolean("mail.smtp.auth");
		this.username = propertiesUtil.getString("mail.auth.username");
		this.password = propertiesUtil.getString("mail.auth.password");
		this.sender = propertiesUtil.getString("mail.sender.username");
	}

	public void set() {
		set(PROPERTIES_PATH);
	}

	public void set(String propertiesPath) {
		PropertiesUtil propertiesUtil = new PropertiesUtil(propertiesPath);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("mail.smtp.host", host);
		dataMap.put("mail.smtp.port", port);
		dataMap.put("mail.smtp.auth", auth);
		dataMap.put("mail.auth.username", username);
		dataMap.put("mail.auth.password", password);
		dataMap.put("mail.sender.username", sender);
		propertiesUtil.set(dataMap);
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public Boolean getAuth() {
		return auth;
	}

	public void setAuth(Boolean auth) {
		this.auth = auth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

}
