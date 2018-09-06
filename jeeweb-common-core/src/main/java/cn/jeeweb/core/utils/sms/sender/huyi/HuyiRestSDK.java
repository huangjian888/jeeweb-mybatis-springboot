//接口类型：互亿无线触发短信接口，支持发送验证码短信、订单通知短信等。
//账户注册：请通过该地址开通账户http://sms.ihuyi.com/register.html
//注意事项：
//（1）调试期间，请用默认的模板进行测试，默认模板详见接口文档；
//（2）请使用 用户名(例如：cf_demo123)及 APIkey来调用接口，APIkey在会员中心可以获取；
//（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；
package cn.jeeweb.core.utils.sms.sender.huyi;

import cn.jeeweb.core.utils.StringUtils;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author auth_team
 *
 */
public class HuyiRestSDK {
	protected Logger logger = Logger.getLogger(HuyiRestSDK.class);

	private String SERVER_URL;
	private String ACCOUNT_NAME;
	private String ACCOUNT_PASSWORD;

	/**
	 * 初始化服务地址和端口
	 * 
	 * @param serverIP
	 *            必选参数 服务器地址
	 * @param serverPort
	 *            必选参数 服务器端口
	 */
	public void init(String serverUrl) {
		if (StringUtils.isEmpty(serverUrl)) {
			//logger.fatal("初始化异常:serverUrl为空");
			throw new IllegalArgumentException("必选参数:" + (StringUtils.isEmpty(serverUrl) ? " 服务器地址 " : "") + "为空");
		}
		SERVER_URL = serverUrl;
	}

	/**
	 * 设置帐号
	 * 
	 * @param accountName
	 * @param accountPassword
	 */
	public void setAccount(String accountName, String accountPassword) {
		if (StringUtils.isEmpty(accountName) || StringUtils.isEmpty(accountPassword)) {
			//logger.fatal("初始化异常:accountName或accountPassword为空");
			throw new IllegalArgumentException("必选参数:" + (StringUtils.isEmpty(accountName) ? " 帐号" : "")
					+ (StringUtils.isEmpty(accountPassword) ? " 密码 " : "") + "为空");
		}
		ACCOUNT_NAME = accountName;
		ACCOUNT_PASSWORD = accountPassword;
	}

	public Map<String, Object> sendMsg(String mobile, String content) {
		Map<String, Object> resultData = new HashMap<String, Object>();
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(SERVER_URL);
		if ((StringUtils.isEmpty(mobile)) || (StringUtils.isEmpty(content)) )
			throw new IllegalArgumentException(
					"必选参数:" + (StringUtils.isEmpty(mobile) ? " 手机号码 " : "") + (StringUtils.isEmpty(content) ? " 內容 " : "") + "为空");
		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType", "application/x-www-form-urlencoded;charset=GBK");

		NameValuePair[] data = { // 提交短信
				new NameValuePair("account", ACCOUNT_NAME), new NameValuePair("password", ACCOUNT_PASSWORD),
				// 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
				// new NameValuePair("password",
				// util.StringUtil.MD5Encode("密码")),
				new NameValuePair("mobile", mobile), new NameValuePair("content", content), };
		method.setRequestBody(data);
		int status = 0;
		try {
			client.executeMethod(method);
			status = method.getStatusCode();
			String SubmitResult = method.getResponseBodyAsString();

			Document doc = DocumentHelper.parseText(SubmitResult);
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String smsid = root.elementText("smsid");
			resultData.put("code", code);
			resultData.put("msg", msg);
			resultData.put("smsid", smsid);
			if ("2".equals(code)) {
				logger.info("短信发送成功");
			} else {
				logger.error(msg);
			}
		} catch (HttpException e) {
			e.printStackTrace();
			return getMyError("172001", "网络错误" + "Https请求返回码：" + status);
		} catch (IOException e) {
			e.printStackTrace();
			return getMyError("172001", "网络错误" + "Https请求返回码：" + status);
		} catch (DocumentException e) {
			e.printStackTrace();
			return getMyError("18000", "文件解析错误" + "Https请求返回码：" + status);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		}

		return resultData;
	}

	private HashMap<String, Object> getMyError(String code, String msg) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("code", code);
		hashMap.put("msg", msg);
		return hashMap;
	}

	public static void main(String[] args) {
		HuyiRestSDK huyiRestSDK = new HuyiRestSDK();
		huyiRestSDK.init("http://106.ihuyi.com/webservice/sms.php?method=Submit");
		huyiRestSDK.setAccount("cf_gzkj", "7ff0011de57c90b04c1bfe22ae7c8a10");
		huyiRestSDK.sendMsg("15085980308", "您的验证码是：123456。请不要把验证码泄露给其他人。");
	}

}