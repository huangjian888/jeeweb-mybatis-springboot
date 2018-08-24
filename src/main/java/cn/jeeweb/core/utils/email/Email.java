package cn.jeeweb.core.utils.email;

import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.core.utils.StringUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Email extends HtmlEmail {
	public static final String DEFAULT_CONFIG_FILE = "email.properties";
	public String configname = DEFAULT_CONFIG_FILE;

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	public static Email newEmail() {
		return new Email();
	}

	public void initConfig(String configname) throws EmailException {
		// 初始化配置
		PropertiesUtil propertiesUtil = new PropertiesUtil(configname);
		setHostName(propertiesUtil.getString("mail.smtp.host"));
		setSmtpPort(propertiesUtil.getInt("mail.smtp.port"));
		Boolean auth = propertiesUtil.getBoolean("mail.smtp.auth");
		if (auth) {
			setAuthenticator(new DefaultAuthenticator(propertiesUtil.getString("mail.auth.username"),
					propertiesUtil.getString("mail.auth.password")));
		}
		Boolean ssl = propertiesUtil.getBoolean("mail.smtp.open.ssl");
		if (ssl) {
			setSSLOnConnect(true);
		}
		// 设置主题的字符集为UTF-8
		setCharset("UTF-8");
		setFrom(propertiesUtil.getString("mail.sender.username"), propertiesUtil.getString("mail.sender.alias"));
	}

	public EmailResult send(String email, String subject, String content) {
		try {
			initConfig(configname);
			addTo(email);
			if (!StringUtils.isEmpty(subject)) {
				setSubject(subject);
			}
			setHtmlMsg(content);
			send();
			return EmailResult.success("发送成功");
		} catch (Exception e) {
			e.printStackTrace();
			return EmailResult.fail("发送失败");
		}
	}

}
