package cn.jeeweb.core.utils.sms.sender;

import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.core.utils.sms.data.SmsResult;
import cn.jeeweb.core.utils.sms.data.SmsTemplate;
import cn.jeeweb.core.utils.sms.sender.huyi.HuyiRestSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Set;

/**
 * 互亿无线
 * 
 * @author auth_team
 *
 */
public class HuyiSmsSender extends SmsSender {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private HuyiRestSDK huyiRestSDK;

	public HuyiSmsSender() {
		try {
			init();
		} catch (Exception e) {

		}
	}

	@Override
	public void init() {
		PropertiesUtil p = new PropertiesUtil(getConfigname());
		String serverUrl = p.getString("sms.server.url");
		String accountName = p.getString("sms.account.apiid");
		String accountPassword = p.getString("sms.account.apikey");
		huyiRestSDK = new HuyiRestSDK();
		huyiRestSDK.init(serverUrl);
		huyiRestSDK.setAccount(accountName, accountPassword);
	}

	@Override
	public SmsResult send(String phone, SmsTemplate smsTemplate, String... datas) {
		SmsResult smsResult = new SmsResult();
		String[] phones = phone.split(",");
		for (String singlePhone : phones) {
			smsResult = sendSingle(singlePhone, smsTemplate, datas);
		}
		return smsResult;
	}

	private SmsResult sendSingle(String phone, SmsTemplate smsTemplate, String... datas) {
		Map<String, Object> result = null;
		// 这里需要处理templateId
		String templateContent = smsTemplate.getTemplateContent();
		String content = templateContent;
		if (datas != null) {
			// 这里需要处理templateId
			Object[] dataArr = new Object[datas.length + 1];
			dataArr[0] = "";
			for (int i = 0; i < datas.length; i++) {
				dataArr[i + 1] = datas[i];
			}
			// 让索引从0开始
			content = MessageFormat.format("{0}" + templateContent, dataArr);
		}
		result = huyiRestSDK.sendMsg(phone, content);
		logger.info("HuyiRestSDK result=" + result);

		if ("2".equals(result.get("code"))) {
			// 正常返回输出data包体信息（map）
			Set<String> keySet = result.keySet();
			for (String key : keySet) {
				Object object = result.get(key);
				logger.info(key + " = " + object);
			}
		} else {
			// 异常返回输出错误码和错误信息
			logger.error("错误码=" + result.get("code") + " 错误信息= " + result.get("msg"));
		}
		return mapToResult(result);
	}

	private SmsResult mapToResult(Map<String, Object> result) {
		SmsResult requestResult = new SmsResult();
		requestResult.setSuccess(Boolean.FALSE);
		requestResult.setSenderName(name());
		if (result != null) {
			requestResult.setCode(result.get("code") + "");
			requestResult.setMsg(result.get("msg") + "");
			requestResult.setSmsid(result.get("smsid") + "");
			if ("2".equals(result.get("code"))) {
				requestResult.setSuccess(Boolean.TRUE);
			}
		}
		return requestResult;
	}

	@Override
	protected String name() {
		return "HUYI";
	}

}
