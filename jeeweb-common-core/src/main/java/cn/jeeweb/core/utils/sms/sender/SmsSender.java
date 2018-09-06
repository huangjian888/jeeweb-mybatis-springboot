package cn.jeeweb.core.utils.sms.sender;

import cn.jeeweb.core.utils.sms.data.SmsResult;
import cn.jeeweb.core.utils.sms.data.SmsTemplate;

/**
 * 短信发射器
 * 
 * @author auth_team
 *
 */
public abstract class SmsSender {
	public static final String DEFAULT_CONFIG_FILE = "sms.properties";
	protected String configname = DEFAULT_CONFIG_FILE;

	public String getConfigname() {
		return configname;
	}

	public void setConfigname(String configname) {
		this.configname = configname;
	}

	/**
	 * 初始化配置
	 */
	protected abstract void init();

	/**
	 * 
	 * @title: name
	 * @description:发射器名称
	 * @return: void
	 */
	protected abstract String name();

	/**
	 * 
	 * 
	 * @param phone
	 *            手机号码
	 * @param templateId
	 *            模版ID
	 * @param datas
	 *            数据
	 * @return
	 */
	public abstract SmsResult send(String phone, SmsTemplate smsTemplate, String... datas);

}
