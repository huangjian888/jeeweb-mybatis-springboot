package cn.jeeweb.core.utils.sms.sender;

import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.core.utils.sms.data.SmsResult;
import cn.jeeweb.core.utils.sms.data.SmsTemplate;
import cn.jeeweb.core.utils.sms.sender.cloopen.CCPRestSDK;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 云通讯短信发送
 * 
 * @author auth_team
 *
 */
@SuppressWarnings("unchecked")
public class CCPSmsSender extends SmsSender {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	private CCPRestSDK restAPI = new CCPRestSDK();;

	public CCPSmsSender() {
		try {
			init();
		} catch (Exception e) {

		}
	}

	@Override
	public void init() {

		// ******************************注释*********************************************
		// *初始化服务器地址和端口 *
		// *沙盒环境（用于应用开发调试）：restAPI.init("sandboxapp.cloopen.com", "8883");*
		// *生产环境（用户应用上线使用）：restAPI.init("app.cloopen.com", "8883"); *
		// *******************************************************************************
		PropertiesUtil p = new PropertiesUtil(getConfigname());
		String serverIP = p.getString("sms.serverip");
		String serverPort = p.getString("sms.serverport");
		String accountSid = p.getString("sms.accountsid");
		String accountToken = p.getString("sms.accounttoken");
		String appid = p.getString("sms.appid");
		// String templateId = p.readProperty("sms.smstemplateId");
		restAPI.init(serverIP, serverPort);
		// ******************************注释*********************************************
		// *初始化主帐号和主帐号令牌,对应官网开发者主账号下的ACCOUNT SID和AUTH TOKEN *
		// *ACOUNT SID和AUTH TOKEN在登陆官网后，在“应用-管理控制台”中查看开发者主账号获取*
		// *参数顺序：第一个参数是ACOUNT SID，第二个参数是AUTH TOKEN。 *
		// *******************************************************************************
		restAPI.setAccount(accountSid, accountToken);

		// ******************************注释*********************************************
		// *初始化应用ID *
		// *测试开发可使用“测试Demo”的APP ID，正式上线需要使用自己创建的应用的App ID *
		// *应用ID的获取：登陆官网，在“应用-应用列表”，点击应用名称，看应用详情获取APP ID*
		// *******************************************************************************
		restAPI.setAppId(appid);
	}

	@Override
	public SmsResult send(String phone, SmsTemplate smsTemplate, String... datas) {
		HashMap<String, Object> result = null;
		String templateId = smsTemplate.getTemplateId();
		result = restAPI.sendTemplateSMS(phone, templateId, datas);
		logger.info("SDKTestSendTemplateSMS result=" + result);
		if ("000000".equals(result.get("statusCode"))) {
			// 正常返回输出data包体信息（map）
			HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for (String key : keySet) {
				Object object = data.get(key);
				logger.info(key + " = " + object);
			}
		} else {
			// 异常返回输出错误码和错误信息
			logger.error("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
		}
		return mapToResult(result);
	}

	private SmsResult mapToResult(Map<String, Object> result) {
		SmsResult requestResult = new SmsResult();
		requestResult.setSuccess(Boolean.FALSE);
		requestResult.setSenderName(name());
		if (result != null) {
			if ("000000".equals(result.get("statusCode"))) {
				requestResult.setCode(result.get("statusCode") + "");
				requestResult.setMsg("发送成功");
				// 正常返回输出data包体信息（map）
				HashMap<String, Object> data = (HashMap<String, Object>) result.get("data");
				requestResult.setSmsid(data.get("smsMessageSid") + "");
				requestResult.setSuccess(Boolean.TRUE);
			} else {
				requestResult.setSuccess(Boolean.FALSE);
				requestResult.setCode(result.get("statusCode") + "");
				requestResult.setMsg(result.get("statusMsg") + "");
			}
		}
		return requestResult;
	}

	@Override
	protected String name() {
		return "CCP";
	}

	public static void main(String[] args) {
		// 70585
		SmsTemplate smsTemplate = SmsTemplate.newTemplateById("70585");
		CCPSmsSender ccpSmsSender = new CCPSmsSender();
		ccpSmsSender.send("15085980308,18166727295", smsTemplate, "2345");
	}
}
