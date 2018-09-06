package cn.jeeweb.core.utils.sms.sender.cloopen;

import cn.jeeweb.core.utils.DateUtils;
import cn.jeeweb.core.utils.http.SSLHttpClient;
import cn.jeeweb.core.utils.security.EncryptUtil;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.AbstractHttpMessage;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Map.Entry;

public class CCPRestSDK {
	protected Logger logger = Logger.getLogger(CCPRestSDK.class);
	int status;
	private static final int Request_Get = 0;

	private static final int Request_Post = 1;
	private static final String Account_Info = "AccountInfo";
	private static final String Create_SubAccount = "SubAccounts";
	private static final String Get_SubAccounts = "GetSubAccounts";
	private static final String Query_SubAccountByName = "QuerySubAccountByName";

	private static final String SMSMessages = "SMS/Messages";
	private static final String TemplateSMS = "SMS/TemplateSMS";
	private static final String Query_SMSTemplate = "SMS/QuerySMSTemplate";
	private static final String LandingCalls = "Calls/LandingCalls";
	private static final String VoiceVerify = "Calls/VoiceVerify";
	private static final String IvrDial = "ivr/dial";
	private static final String BillRecords = "BillRecords";
	private static final String queryCallState = "ivr/call";
	private static final String callResult = "CallResult";
	private static final String mediaFileUpload = "Calls/MediaFileUpload";
	private String SERVER_IP;
	private String SERVER_PORT;
	private String ACCOUNT_SID;
	private String ACCOUNT_TOKEN;
	private String SUBACCOUNT_SID;
	private String SUBACCOUNT_Token;
	public String App_ID;
	private BodyType BODY_TYPE = BodyType.Type_XML;
	public String Callsid;

	public enum BodyType {
		Type_XML, Type_JSON;
	}

	public enum AccountType {
		Accounts, SubAccounts;
	}

	/**
	 * 初始化服务地址和端口
	 * 
	 * @param serverIP
	 *            必选参数 服务器地址
	 * @param serverPort
	 *            必选参数 服务器端口
	 */
	public void init(String serverIP, String serverPort) {
		if (isEmpty(serverIP) || isEmpty(serverPort)) {
			logger.fatal("初始化异常:serverIP或serverPort为空");
			throw new IllegalArgumentException(
					"必选参数:" + (isEmpty(serverIP) ? " 服务器地址 " : "") + (isEmpty(serverPort) ? " 服务器端口 " : "") + "为空");
		}
		SERVER_IP = serverIP;
		SERVER_PORT = serverPort;
	}

	/**
	 * 初始化主帐号信息
	 * 
	 * @param accountSid
	 *            必选参数 主帐号
	 * @param accountToken
	 *            必选参数 主帐号TOKEN
	 */
	public void setAccount(String accountSid, String accountToken) {
		if (isEmpty(accountSid) || isEmpty(accountToken)) {
			logger.fatal("初始化异常:accountSid或accountToken为空");
			throw new IllegalArgumentException(
					"必选参数:" + (isEmpty(accountSid) ? " 主帐号" : "") + (isEmpty(accountToken) ? " 主帐号TOKEN " : "") + "为空");
		}
		ACCOUNT_SID = accountSid;
		ACCOUNT_TOKEN = accountToken;
	}

	/**
	 * 初始化子帐号信息
	 * 
	 * @param subAccountSid
	 *            必选参数 子帐号
	 * @param subAccountToken
	 *            必选参数 子帐号TOKEN
	 */
	public void setSubAccount(String subAccountSid, String subAccountToken) {
		if (isEmpty(subAccountSid) || isEmpty(subAccountToken)) {
			logger.fatal("初始化异常:subAccountSid或subAccountToken为空");
			throw new IllegalArgumentException("必选参数:" + (isEmpty(subAccountSid) ? " 子帐号" : "")
					+ (isEmpty(subAccountToken) ? " 子帐号TOKEN " : "") + "为空");
		}
		SUBACCOUNT_SID = subAccountSid;
		SUBACCOUNT_Token = subAccountToken;
	}

	/**
	 * 初始化应用Id
	 * 
	 * @param appId
	 *            必选参数 应用Id
	 */
	public void setAppId(String appId) {
		if (isEmpty(appId)) {
			logger.fatal("初始化异常:appId为空");
			throw new IllegalArgumentException("必选参数: 应用Id 为空");
		}
		App_ID = appId;
	}

	/**
	 * 话单下载
	 * 
	 * @param date
	 *            必选参数 day 代表前一天的数据（从00:00 – 23:59）
	 * @param keywords
	 *            可选参数 客户的查询条件，由客户自行定义并提供给云通讯平台。默认不填忽略此参数
	 * @return
	 */
	public HashMap<String, Object> billRecords(String date, String keywords) {

		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if ((isEmpty(date))) {
			logger.fatal("必选参数: 日期  为空");
			throw new IllegalArgumentException("必选参数: 日期  为空");
		}
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			// e1.printStackTrace();
			logger.error(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, BillRecords);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("date", date);
				if (!(isEmpty(keywords)))
					json.addProperty("keywords", keywords);

				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><BillRecords>");
				sb.append("<appId>").append(App_ID).append("</appId>").append("<date>").append(date).append("</date>");
				if (!(isEmpty(keywords)))
					sb.append("<keywords>").append(keywords).append("</keywords>");

				sb.append("</BillRecords>").toString();
				requsetbody = sb.toString();
			}
			logger.info("billRecords Request body = : " + requsetbody);
			// 打印包体
			logger.info("请求的包体：" + requsetbody);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);

			status = response.getStatusLine().getStatusCode();

			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("billRecords response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 发起IVR外呼请求
	 * 
	 * @param number
	 *            必选参数 待呼叫号码，为Dial节点的属性
	 * @param userdata
	 *            可选参数 用户数据，在<startservice>通知中返回，只允许填写数字字符，为Dial节点的属性
	 * @param record
	 *            可选参数 是否录音，可填项为true和false，默认值为false不录音，为Dial节点的属性
	 * @param disnumber
	 *            可选参数 用户方的显号号码，根据平台侧显号规则控制。
	 * @return
	 */
	public HashMap<String, Object> ivrDial(String number, String userdata, boolean record, String disnumber) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if (isEmpty(number)) {
			logger.fatal("必选参数: 待呼叫号码   为空");
			throw new IllegalArgumentException("必选参数: 待呼叫号码   为空");
		}
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, IvrDial);
			String requsetbody = "";

			StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><Request>");
			sb.append("<Appid>").append(App_ID).append("</Appid>").append("<Dial number=").append("\"").append(number)
					.append("\"");
			if (record) {
				sb.append(" record=").append("\"").append(record).append("\"");
			}
			if (userdata != null) {
				sb.append(" userdata=").append("\"").append(userdata).append("\"");
			}
			if (disnumber != null) {
				sb.append(" disnumber=").append("\"").append(disnumber).append("\"");
			}
			sb.append("></Dial></Request>").toString();
			requsetbody = sb.toString();

			logger.info("ivrDial Request body = : " + requsetbody);
			logger.info("请求的包体：" + requsetbody);

			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();

			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("ivrDial response body = " + result);
		try {
			return xmlToMap(result);
		} catch (Exception e) {
			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 发起语音验证码请求
	 * 
	 * @param verifyCode
	 *            必选参数 验证码内容，为数字和英文字母，不区分大小写，长度4-8位
	 * @param to
	 *            必选参数 接收号码
	 * @param displayNum
	 *            可选参数 显示主叫号码，显示权限由服务侧控制
	 * @param playTimes
	 *            可选参数 循环播放次数，1－3次，默认播放1次
	 * @param respUrl
	 *            可选参数 语音验证码状态通知回调地址，云通讯平台将向该Url地址发送呼叫结果通知
	 * @param lang
	 *            可选参数 语言类型
	 * @param userData
	 *            可选参数 第三方私有数据
	 * @param welcomePrompt
	 *            可选参数 wav格式的文件名，欢迎提示音，在播放验证码语音前播放此内容，配合verifyCode使用，默认值空，
	 *            当playVerifyCode为空有效。
	 * @param playVerifyCode
	 *            可选参数
	 *            wav格式的文件名，语音验证码的内容全部播放此节点下的全部语音文件，也就是实现了语音验证码功能播放用户自己的语音文件，
	 *            该参数和verifyCode二者不能同时为空，当二者都不为空时优先使用playVerifyCode。
	 * @param maxCallTime
	 *            可选参数 最大通话时长
	 * @return
	 */
	public HashMap<String, Object> voiceVerify(String verifyCode, String to, String displayNum, String playTimes,
			String respUrl, String lang, String userData, String welcomePrompt, String playVerifyCode,
			String maxCallTime) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if ((isEmpty(verifyCode)) || (isEmpty(to)))
			throw new IllegalArgumentException(
					"必选参数:" + (isEmpty(verifyCode) ? " 验证码内容 " : "") + (isEmpty(to) ? " 接收号码 " : "") + "为空");
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, VoiceVerify);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("verifyCode", verifyCode);
				json.addProperty("to", to);
				if (!(isEmpty(displayNum)))
					json.addProperty("displayNum", displayNum);

				if (!(isEmpty(playTimes)))
					json.addProperty("playTimes", playTimes);

				if (!(isEmpty(respUrl)))
					json.addProperty("respUrl", respUrl);
				if (!(isEmpty(lang)))
					json.addProperty("lang", lang);
				if (!(isEmpty(userData)))
					json.addProperty("userData", userData);
				if (!(isEmpty(welcomePrompt)))
					json.addProperty("welcomePrompt", welcomePrompt);
				if (!(isEmpty(playVerifyCode)))
					json.addProperty("playVerifyCode", playVerifyCode);
				if (!(isEmpty(maxCallTime)))
					json.addProperty("maxCallTime", maxCallTime);

				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><VoiceVerify>");
				sb.append("<appId>").append(App_ID).append("</appId>").append("<verifyCode>").append(verifyCode)
						.append("</verifyCode>").append("<to>").append(to).append("</to>");
				if (!(isEmpty(displayNum)))
					sb.append("<displayNum>").append(displayNum).append("</displayNum>");

				if (!(isEmpty(playTimes)))
					sb.append("<playTimes>").append(playTimes).append("</playTimes>");

				if (!(isEmpty(respUrl)))
					sb.append("<respUrl>").append(respUrl).append("</respUrl>");
				if (!(isEmpty(lang)))
					sb.append("<lang>").append(lang).append("</lang>");
				if (!(isEmpty(userData)))
					sb.append("<userData>").append(userData).append("</userData>");
				if (!(isEmpty(welcomePrompt)))
					sb.append("<welcomePrompt>").append(welcomePrompt).append("</welcomePrompt>");
				if (!(isEmpty(playVerifyCode)))
					sb.append("<playVerifyCode>").append(playVerifyCode).append("</playVerifyCode>");
				if (!(isEmpty(maxCallTime)))
					sb.append("<maxCallTime>").append(maxCallTime).append("</maxCallTime>");

				sb.append("</VoiceVerify>").toString();
				requsetbody = sb.toString();
			}

			logger.info("voiceVerify Request body = : " + requsetbody);
			logger.info("请求的包体：" + requsetbody);

			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}

		logger.info("voiceVerify response body = " + result);

		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 发送外呼通知请求
	 * 
	 * @param to
	 *            必选参数 被叫号码
	 * @param mediaName
	 *            可选参数 语音文件名称，格式 wav。与mediaTxt不能同时为空，不为空时mediaTxt属性失效
	 * @param mediaTxt
	 *            可选参数 文本内容，默认值为空
	 * @param displayNum
	 *            可选参数 显示的主叫号码，显示权限由服务侧控制
	 * @param playTimes
	 *            可选参数 循环播放次数，1－3次，默认播放1次
	 * @param respUrl
	 *            可选参数 外呼通知状态通知回调地址，云通讯平台将向该Url地址发送呼叫结果通知
	 * @param userData
	 *            可选参数 用户私有数据
	 * @param txtSpeed
	 *            可选参数 文本转语音后的发音速度，取值范围：-500至500，当mediaTxt有效才生效，默认值为0。
	 * @param txtVolume
	 *            可选参数 文本转语音后的音量大小，取值范围：-20至20，当mediaTxt有效才生效，默认值为0。
	 * @param txtPitch
	 *            可选参数 文本转语音后的音调，取值范围：-500至500，当mediaTxt有效才生效，默认值为0。
	 * @param txtBgsound
	 *            可选参数 文本转语音后的背景音编号，目前云通讯平台支持6种背景音，1到6的六种背景音编码，0为不需要背景音。
	 *            暂时不支持第三方自定义背景音。当mediaTxt有效才生效。
	 * @param playMode
	 *            可选参数 是否同时播放文本和语音文件 , 0、否 1、是，默认0。优先播放文本。
	 * @return
	 */
	public HashMap<String, Object> landingCall(String to, String mediaName, String mediaTxt, String displayNum,
			String playTimes, String respUrl, String userData, String txtSpeed, String txtVolume, String txtPitch,
			String txtBgsound, String playMode) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if (isEmpty(to))
			throw new IllegalArgumentException("必选参数:" + (isEmpty(to) ? " 被叫号码 " : "") + "为空");
		if ((isEmpty(mediaName)) && (isEmpty(mediaTxt)))
			throw new IllegalArgumentException("参数语音文件名称和参数语音文本内容不能同时为空");
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, LandingCalls);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("to", to);

				if (!(isEmpty(mediaName)))
					json.addProperty("mediaName", mediaName);

				if (!(isEmpty(mediaTxt)))
					json.addProperty("mediaTxt", mediaTxt);

				if (!(isEmpty(displayNum)))
					json.addProperty("displayNum", displayNum);
				if (!(isEmpty(playTimes)))
					json.addProperty("playTimes", playTimes);

				if (!(isEmpty(respUrl)))
					json.addProperty("respUrl", respUrl);
				if (!(isEmpty(userData)))
					json.addProperty("userData", userData);
				if (!(isEmpty(txtSpeed)))
					json.addProperty("txtSpeed", txtSpeed);
				if (!(isEmpty(txtVolume)))
					json.addProperty("txtVolume", txtVolume);
				if (!(isEmpty(txtPitch)))
					json.addProperty("txtPitch", txtPitch);
				if (!(isEmpty(txtBgsound)))
					json.addProperty("txtBgsound", txtBgsound);
				if (!(isEmpty(playMode)))
					json.addProperty("playMode", playMode);

				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><LandingCall>");
				sb.append("<appId>").append(App_ID).append("</appId>").append("<to>").append(to).append("</to>");
				if (!(isEmpty(mediaName)))
					sb.append("<mediaName>").append(mediaName).append("</mediaName>");
				else if (!(isEmpty(mediaName)))
					sb.append("<mediaName>").append(mediaName).append("</mediaName>");

				if (!(isEmpty(mediaTxt)))
					sb.append("<mediaTxt>").append(mediaTxt).append("</mediaTxt>");

				if (!(isEmpty(displayNum)))
					sb.append("<displayNum>").append(displayNum).append("</displayNum>");
				if (!(isEmpty(playTimes)))
					sb.append("<playTimes>").append(playTimes).append("</playTimes>");

				if (!(isEmpty(respUrl)))
					sb.append("<respUrl>").append(respUrl).append("</respUrl>");
				if (!(isEmpty(userData)))
					sb.append("<userData>").append(userData).append("</userData>");
				if (!(isEmpty(txtSpeed)))
					sb.append("<txtSpeed>").append(txtSpeed).append("</txtSpeed>");
				if (!(isEmpty(txtVolume)))
					sb.append("<txtVolume>").append(txtVolume).append("</txtVolume>");
				if (!(isEmpty(txtPitch)))
					sb.append("<txtPitch>").append(txtPitch).append("</txtPitch>");
				if (!(isEmpty(txtBgsound)))
					sb.append("<txtBgsound>").append(txtBgsound).append("</txtBgsound>");
				if (!(isEmpty(playMode)))
					sb.append("<playMode>").append(playMode).append("</playMode>");

				sb.append("</LandingCall>").toString();
				requsetbody = sb.toString();
			}
			logger.info("landingCalls Request body = : " + requsetbody);

			logger.info("请求的包体：" + requsetbody);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}

		logger.info("landingCall response body = " + result);

		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 发送短信模板请求
	 * 
	 * @param to
	 *            必选参数 短信接收端手机号码集合，用英文逗号分开，每批发送的手机号数量不得超过100个
	 * @param templateId
	 *            必选参数 模板Id
	 * @param datas
	 *            可选参数 内容数据，用于替换模板中{序号}
	 * @return
	 */
	public HashMap<String, Object> sendTemplateSMS(String to, String templateId, String[] datas) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if ((isEmpty(to)) || (isEmpty(App_ID)) || (isEmpty(templateId)))
			throw new IllegalArgumentException(
					"必选参数:" + (isEmpty(to) ? " 手机号码 " : "") + (isEmpty(templateId) ? " 模板Id " : "") + "为空");
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";

		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, TemplateSMS);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("to", to);
				json.addProperty("templateId", templateId);
				if (datas != null) {
					StringBuilder sb = new StringBuilder("[");
					for (String s : datas) {
						sb.append("\"" + s + "\"" + ",");
					}
					sb.replace(sb.length() - 1, sb.length(), "]");
					JsonParser parser = new JsonParser();
					JsonArray Jarray = parser.parse(sb.toString()).getAsJsonArray();
					json.add("datas", Jarray);
				}
				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><TemplateSMS>");
				sb.append("<appId>").append(App_ID).append("</appId>").append("<to>").append(to).append("</to>")
						.append("<templateId>").append(templateId).append("</templateId>");
				if (datas != null) {
					sb.append("<datas>");
					for (String s : datas) {
						sb.append("<data>").append(s).append("</data>");
					}
					sb.append("</datas>");
				}
				sb.append("</TemplateSMS>").toString();
				requsetbody = sb.toString();
			}
			// 打印包体
			logger.info("请求的包体：" + requsetbody);
			logger.info("sendTemplateSMS Request body =  " + requsetbody);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);

			HttpResponse response = httpclient.execute(httppost);

			// 获取响应码

			status = response.getStatusLine().getStatusCode();

			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误" + "Https请求返回码：" + status);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}

		logger.info("sendTemplateSMS response body = " + result);

		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 获取子帐号信息
	 * 
	 * @param appId
	 *            必选参数 应用Id
	 * @param friendlyName
	 *            必选参数 子帐号名称
	 * @return
	 */
	public HashMap<String, Object> querySubAccount(String friendlyName) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if ((isEmpty(friendlyName))) {
			logger.fatal("必选参数: 子帐号名称 为空");
			throw new IllegalArgumentException("必选参数: 子帐号名称 为空");
		}
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, Query_SubAccountByName);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("friendlyName", friendlyName);
				requsetbody = json.toString();
			} else {
				requsetbody = "<?xml version='1.0' encoding='utf-8'?><SubAccount>" + "<appId>" + App_ID + "</appId>"
						+ "<friendlyName>" + friendlyName + "</friendlyName>" + "</SubAccount>";
			}
			logger.info("querySubAccountByName Request body =  " + requsetbody);
			logger.info("请求的包体：" + requsetbody);

			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}

		logger.info("querySubAccount result " + result);

		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}

	}

	/**
	 * 获取子帐号
	 * 
	 * @param startNo
	 *            可选参数 开始的序号，默认从0开始
	 * @param offset
	 *            可选参数 一次查询的最大条数，最小是1条，最大是100条
	 * @return
	 */
	public HashMap<String, Object> getSubAccounts(String startNo, String offset) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, Get_SubAccounts);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				if (!(isEmpty(startNo)))
					json.addProperty("startNo", startNo);
				if (!(isEmpty(offset)))
					json.addProperty("offset", offset);
				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><SubAccount>");
				sb.append("<appId>").append(App_ID).append("</appId>");
				if (!(isEmpty(startNo)))
					sb.append("<startNo>").append(startNo).append("</startNo>");
				if (!(isEmpty(offset)))
					sb.append("<offset>").append(offset).append("</offset>");
				sb.append("</SubAccount>").toString();
				requsetbody = sb.toString();
			}
			logger.info("GetSubAccounts Request body =  " + requsetbody);
			logger.info("请求的包体：" + requsetbody);

			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("getSubAccounts result " + result);

		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 获取主帐号信息查询
	 * 
	 * @return
	 */
	public HashMap<String, Object> queryAccountInfo() {
		if ((isEmpty(SERVER_IP))) {
			return getMyError("172004", "IP为空");
		}
		if ((isEmpty(SERVER_PORT))) {
			return getMyError("172005", "端口错误");
		}
		if ((isEmpty(ACCOUNT_SID))) {
			return getMyError("172006", "主帐号为空");
		}
		if ((isEmpty(ACCOUNT_TOKEN))) {
			return getMyError("172007", "主帐号TOKEN为空");
		}

		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.fatal(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpGet httpGet = (HttpGet) getHttpRequestBase(0, Account_Info);
			HttpResponse response = httpclient.execute(httpGet);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("queryAccountInfo response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 创建子帐号
	 * 
	 * @param friendlyName
	 *            必选参数 子帐号名称。可由英文字母和阿拉伯数字组成子帐号唯一名称，推荐使用电子邮箱地址
	 * @return
	 */
	public HashMap<String, Object> createSubAccount(String friendlyName) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if (isEmpty(friendlyName)) {
			logger.fatal("必选参数: 子帐号名称 为空");
			throw new IllegalArgumentException("必选参数: 子帐号名称 为空");
		}

		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, Create_SubAccount);
			String requsetbody = "";

			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("friendlyName", friendlyName);
				requsetbody = json.toString();
			} else {
				requsetbody = "<?xml version='1.0' encoding='utf-8'?><SubAccount>" + "<appId>" + App_ID + "</appId>"
						+ "<friendlyName>" + friendlyName + "</friendlyName>" + "</SubAccount>";
			}
			logger.info("CreateSubAccount Request body =  " + requsetbody);
			logger.info("请求的包体：" + requsetbody);

			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);

			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();

			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("createSubAccount response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 短信模板查询
	 * 
	 * @param templateId
	 *            可选参数 模板Id，不带此参数查询全部可用模板
	 * @return
	 */
	public HashMap<String, Object> QuerySMSTemplate(String templateId) {
		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;

		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, Query_SMSTemplate);
			String requsetbody = "";

			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				json.addProperty("appId", App_ID);
				json.addProperty("templateId", templateId);
				requsetbody = json.toString();
			} else {
				requsetbody = "<?xml version='1.0' encoding='utf-8'?><Request>" + "<appId>" + App_ID + "</appId>"
						+ "<templateId>" + templateId + "</templateId>" + "</Request>";
			}
			logger.info("QuerySMSTemplate Request body =  " + requsetbody);
			// 打印包体
			logger.info("请求的包体：" + requsetbody);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);

			HttpResponse response = httpclient.execute(httppost);

			// 获取响应码

			status = response.getStatusLine().getStatusCode();

			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				result = EntityUtils.toString(entity, "UTF-8");
			}

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("QuerySMSTemplate response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 呼叫状态查询
	 * 
	 * @param callid
	 *            必选参数 呼叫Id
	 * @param action
	 *            可选参数 查询结果通知的回调url地址
	 * @return
	 */
	public HashMap<String, Object> QueryCallState(String callid, String action) {

		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if ((isEmpty(callid))) {
			logger.fatal("必选参数: callid  为空");
			throw new IllegalArgumentException("必选参数: callid 为空");
		}
		Callsid = callid;
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, queryCallState);
			String requsetbody = "";
			if (BODY_TYPE == BodyType.Type_JSON) {
				JsonObject json = new JsonObject();
				JsonObject json2 = new JsonObject();
				json.addProperty("Appid", App_ID);
				json2.addProperty("callid", callid);
				if (!(isEmpty(action)))
					json2.addProperty("action", action);
				json.addProperty("QueryCallState", json2.toString());
				requsetbody = json.toString();
			} else {
				StringBuilder sb = new StringBuilder("<?xml version='1.0' encoding='utf-8'?><Request>");
				sb.append("<Appid>").append(App_ID).append("</Appid>").append("<QueryCallState callid=").append("\"")
						.append(callid).append("\"");
				if (action != null) {
					sb.append(" action=").append("\"").append(action).append("\"").append("/");
				}

				sb.append("></Request>").toString();
				requsetbody = sb.toString();
			}
			logger.info("queryCallState Request body = : " + requsetbody);
			logger.info("请求的包体：" + requsetbody);

			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(new ByteArrayInputStream(requsetbody.getBytes("UTF-8")));
			requestBody.setContentLength(requsetbody.getBytes("UTF-8").length);
			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("billRecords response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 呼叫结果查询
	 * 
	 * @param callSid
	 *            必选参数 呼叫Id
	 * @return
	 */
	public HashMap<String, Object> CallResult(String callSid) {
		if ((isEmpty(SERVER_IP))) {
			return getMyError("172004", "IP为空");
		}
		if ((isEmpty(SERVER_PORT))) {
			return getMyError("172005", "端口错误");
		}
		if ((isEmpty(ACCOUNT_SID))) {
			return getMyError("172006", "主帐号为空");
		}
		if ((isEmpty(ACCOUNT_TOKEN))) {
			return getMyError("172007", "主帐号TOKEN为空");
		}
		Callsid = callSid;
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = null;
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.fatal(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpGet httpGet = (HttpGet) getHttpRequestBase(0, callResult);
			HttpResponse response = httpclient.execute(httpGet);

			status = response.getStatusLine().getStatusCode();

			logger.info("Https请求返回状态码：" + status);
			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("queryAccountInfo response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	/**
	 * 语音文件上传
	 * 
	 * @param filename
	 *            必选参数 文件名
	 * @param fis
	 *            必选参数 二进制数据流
	 * @return
	 */
	public String Filename;

	public HashMap<String, Object> MediaFileUpload(String filename, FileInputStream fis) {

		HashMap<String, Object> validate = accountValidate();
		if (validate != null)
			return validate;
		if ((isEmpty(filename))) {
			logger.fatal("必选参数: filename  为空");
			throw new IllegalArgumentException("必选参数: filename 为空");
		}
		if (fis == null) {
			logger.fatal("必选参数: fis  为空");
			throw new IllegalArgumentException("请检查设置的文件");
		}

		Filename = filename;
		SSLHttpClient chc = new SSLHttpClient();
		DefaultHttpClient httpclient = new DefaultHttpClient();
		try {
			httpclient = chc.registerSSL(SERVER_IP, "TLS", Integer.parseInt(SERVER_PORT), "https");
		} catch (Exception e1) {
			e1.printStackTrace();
			logger.error(e1.getMessage());
			throw new RuntimeException("初始化httpclient异常" + e1.getMessage());
		}
		String result = "";
		try {
			HttpPost httppost = (HttpPost) getHttpRequestBase(1, mediaFileUpload);

			logger.info("MediaFileUpload Request body = : " + fis);
			BasicHttpEntity requestBody = new BasicHttpEntity();
			requestBody.setContent(fis);
			requestBody.setContentLength(fis.available());
			logger.info("请求的包体：" + requestBody);

			httppost.setEntity(requestBody);
			HttpResponse response = httpclient.execute(httppost);
			status = response.getStatusLine().getStatusCode();
			logger.info("Https请求返回状态码：" + status);

			HttpEntity entity = response.getEntity();
			if (entity != null)
				result = EntityUtils.toString(entity, "UTF-8");

			EntityUtils.consume(entity);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172001", "网络错误");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return getMyError("172002", "无返回");
		} finally {
			if (httpclient != null)
				httpclient.getConnectionManager().shutdown();
		}
		logger.info("billRecords response body = " + result);
		try {
			if (BODY_TYPE == BodyType.Type_JSON) {
				return jsonToMap(result);
			} else {
				return xmlToMap(result);
			}
		} catch (Exception e) {

			return getMyError("172003", "返回包体错误");
		}
	}

	private HashMap<String, Object> jsonToMap(String result) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		JsonParser parser = new JsonParser();
		JsonObject asJsonObject = parser.parse(result).getAsJsonObject();
		Set<Entry<String, JsonElement>> entrySet = asJsonObject.entrySet();
		HashMap<String, Object> hashMap2 = new HashMap<String, Object>();

		for (Entry<String, JsonElement> m : entrySet) {
			if ("statusCode".equals(m.getKey()) || "statusMsg".equals(m.getKey()))
				hashMap.put(m.getKey(), m.getValue().getAsString());
			else {
				if ("SubAccount".equals(m.getKey()) || "totalCount".equals(m.getKey())
						|| "smsTemplateList".equals(m.getKey()) || "token".equals(m.getKey())
						|| "callSid".equals(m.getKey()) || "state".equals(m.getKey()) || "downUrl".equals(m.getKey())) {
					if (!"SubAccount".equals(m.getKey()) && !"smsTemplateList".equals(m.getKey()))
						hashMap2.put(m.getKey(), m.getValue().getAsString());
					else {
						try {
							if ((m.getValue().toString().trim().length() <= 2)
									&& !m.getValue().toString().contains("[")) {
								hashMap2.put(m.getKey(), m.getValue().getAsString());
								hashMap.put("data", hashMap2);
								break;
							}
							if (m.getValue().toString().contains("[]")) {
								hashMap2.put(m.getKey(), new JsonArray());
								hashMap.put("data", hashMap2);
								continue;
							}
							JsonArray asJsonArray = parser.parse(m.getValue().toString()).getAsJsonArray();
							ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
							for (JsonElement j : asJsonArray) {
								Set<Entry<String, JsonElement>> entrySet2 = j.getAsJsonObject().entrySet();
								HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
								for (Entry<String, JsonElement> m2 : entrySet2) {
									hashMap3.put(m2.getKey(), m2.getValue().getAsString());
								}
								arrayList.add(hashMap3);
							}
							hashMap2.put(m.getKey(), arrayList);
						} catch (Exception e) {
							JsonObject asJsonObject2 = parser.parse(m.getValue().toString()).getAsJsonObject();
							Set<Entry<String, JsonElement>> entrySet2 = asJsonObject2.entrySet();
							HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
							for (Entry<String, JsonElement> m2 : entrySet2) {
								hashMap3.put(m2.getKey(), m2.getValue().getAsString());
							}
							hashMap2.put(m.getKey(), hashMap3);
							hashMap.put("data", hashMap2);
						}

					}
					hashMap.put("data", hashMap2);
				} else {

					JsonObject asJsonObject2 = parser.parse(m.getValue().toString()).getAsJsonObject();
					Set<Entry<String, JsonElement>> entrySet2 = asJsonObject2.entrySet();
					HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
					for (Entry<String, JsonElement> m2 : entrySet2) {
						hashMap3.put(m2.getKey(), m2.getValue().getAsString());
					}
					if (hashMap3.size() != 0) {
						hashMap2.put(m.getKey(), hashMap3);
					} else {
						hashMap2.put(m.getKey(), m.getValue().getAsString());
					}
					hashMap.put("data", hashMap2);
				}
			}
		}
		return hashMap;
	}

	/**
	 * @description 将xml字符串转换成map
	 * @param xml
	 * @return Map
	 */
	private HashMap<String, Object> xmlToMap(String xml) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		Document doc = null;
		try {
			doc = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = doc.getRootElement(); // 获取根节点
			HashMap<String, Object> hashMap2 = new HashMap<String, Object>();
			ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
			for (Iterator<?> i = rootElt.elementIterator(); i.hasNext();) {
				Element e = (Element) i.next();
				if ("statusCode".equals(e.getName()) || "statusMsg".equals(e.getName()))
					map.put(e.getName(), e.getText());
				else {
					if ("SubAccount".equals(e.getName()) || "TemplateSMS".equals(e.getName())
							|| "totalCount".equals(e.getName()) || "token".equals(e.getName())
							|| "callSid".equals(e.getName()) || "state".equals(e.getName())
							|| "downUrl".equals(e.getName())) {
						if (!"SubAccount".equals(e.getName()) && !"TemplateSMS".equals(e.getName())) {
							hashMap2.put(e.getName(), e.getText());
						} else if ("SubAccount".equals(e.getName())) {

							HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
							for (Iterator<?> i2 = e.elementIterator(); i2.hasNext();) {
								Element e2 = (Element) i2.next();
								hashMap3.put(e2.getName(), e2.getText());
							}
							arrayList.add(hashMap3);
							hashMap2.put("SubAccount", arrayList);
						} else if ("TemplateSMS".equals(e.getName())) {

							HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
							for (Iterator<?> i2 = e.elementIterator(); i2.hasNext();) {
								Element e2 = (Element) i2.next();
								hashMap3.put(e2.getName(), e2.getText());
							}
							arrayList.add(hashMap3);
							hashMap2.put("TemplateSMS", arrayList);
						}
						map.put("data", hashMap2);
					} else {

						HashMap<String, Object> hashMap3 = new HashMap<String, Object>();
						for (Iterator<?> i2 = e.elementIterator(); i2.hasNext();) {
							Element e2 = (Element) i2.next();
							// hashMap2.put(e2.getName(),e2.getText());
							hashMap3.put(e2.getName(), e2.getText());
						}
						if (hashMap3.size() != 0) {
							hashMap2.put(e.getName(), hashMap3);
						} else {
							hashMap2.put(e.getName(), e.getText());
						}
						map.put("data", hashMap2);
					}
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return map;
	}

	private HttpRequestBase getHttpRequestBase(int get, String action)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return getHttpRequestBase(get, action, AccountType.Accounts);
	}

	private HttpRequestBase getHttpRequestBase(int get, String action, AccountType mAccountType)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		String timestamp = DateUtils.formatDate(new Date(), "yyyyMMddHHmmss");
		EncryptUtil eu = new EncryptUtil();
		String sig = "";
		String acountName = "";
		String acountType = "";
		if (mAccountType == AccountType.Accounts) {
			acountName = ACCOUNT_SID;
			sig = ACCOUNT_SID + ACCOUNT_TOKEN + timestamp;
			acountType = "Accounts";
		} else {
			acountName = SUBACCOUNT_SID;
			sig = SUBACCOUNT_SID + SUBACCOUNT_Token + timestamp;
			acountType = "SubAccounts";
		}
		String signature = eu.md5Digest(sig);

		String url = getBaseUrl().append("/" + acountType + "/").append(acountName).append("/" + action + "?sig=")
				.append(signature).toString();
		if (callResult.equals(action)) {
			url = url + "&callsid=" + Callsid;
		}
		if (queryCallState.equals(action)) {
			url = url + "&callid=" + Callsid;
		}
		if (mediaFileUpload.equals(action)) {
			url = url + "&appid=" + App_ID + "&filename=" + Filename;
		}
		logger.info(getmethodName(action) + " url = " + url);
		// logger.info(getmethodName(action) + " url = " + url);
		HttpRequestBase mHttpRequestBase = null;
		if (get == Request_Get)
			mHttpRequestBase = new HttpGet(url);
		else if (get == Request_Post)
			mHttpRequestBase = new HttpPost(url);
		if (IvrDial.equals(action)) {
			setHttpHeaderXML(mHttpRequestBase);
		} else if (mediaFileUpload.equals(action)) {
			setHttpHeaderMedia(mHttpRequestBase);
		} else {
			setHttpHeader(mHttpRequestBase);
		}

		String src = acountName + ":" + timestamp;

		String auth = eu.base64Encoder(src);
		mHttpRequestBase.setHeader("Authorization", auth);
		logger.info("请求的Url：" + mHttpRequestBase);// 打印Url
		return mHttpRequestBase;

	}

	private String getmethodName(String action) {
		if (action.equals(Account_Info)) {
			return "queryAccountInfo";
		} else if (action.equals(Create_SubAccount)) {
			return "createSubAccount";
		} else if (action.equals(Get_SubAccounts)) {
			return "getSubAccounts";
		} else if (action.equals(Query_SubAccountByName)) {
			return "querySubAccount";
		} else if (action.equals(SMSMessages)) {
			return "sendSMS";
		} else if (action.equals(TemplateSMS)) {
			return "sendTemplateSMS";
		} else if (action.equals(LandingCalls)) {
			return "landingCalls";
		} else if (action.equals(VoiceVerify)) {
			return "voiceVerify";
		} else if (action.equals(IvrDial)) {
			return "ivrDial";
		} else if (action.equals(BillRecords)) {
			return "billRecords";
		} else {
			return "";
		}
	}

	private void setHttpHeaderXML(AbstractHttpMessage httpMessage) {
		httpMessage.setHeader("Accept", "application/xml");
		httpMessage.setHeader("Content-Type", "application/xml;charset=utf-8");
	}

	private void setHttpHeaderMedia(AbstractHttpMessage httpMessage) {
		if (BODY_TYPE == BodyType.Type_JSON) {
			httpMessage.setHeader("Accept", "application/json");
			httpMessage.setHeader("Content-Type", "application/octet-stream;charset=utf-8;");
		} else {
			httpMessage.setHeader("Accept", "application/xml");
			httpMessage.setHeader("Content-Type", "application/octet-stream;charset=utf-8;");
		}
	}

	private void setHttpHeader(AbstractHttpMessage httpMessage) {
		if (BODY_TYPE == BodyType.Type_JSON) {
			httpMessage.setHeader("Accept", "application/json");
			httpMessage.setHeader("Content-Type", "application/json;charset=utf-8");

		} else {
			httpMessage.setHeader("Accept", "application/xml");
			httpMessage.setHeader("Content-Type", "application/xml;charset=utf-8");
		}
	}

	private StringBuffer getBaseUrl() {
		StringBuffer sb = new StringBuffer("https://");
		sb.append(SERVER_IP).append(":").append(SERVER_PORT);
		sb.append("/2013-12-26");
		return sb;
	}

	private boolean isEmpty(String str) {
		return (("".equals(str)) || (str == null));
	}

	private HashMap<String, Object> getMyError(String code, String msg) {
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		hashMap.put("statusCode", code);
		hashMap.put("statusMsg", msg);
		return hashMap;
	}

	private HashMap<String, Object> accountValidate() {
		if ((isEmpty(SERVER_IP))) {
			return getMyError("172004", "IP为空");
		}
		if ((isEmpty(SERVER_PORT))) {
			return getMyError("172005", "端口错误");
		}
		if ((isEmpty(ACCOUNT_SID))) {
			return getMyError("172006", "主帐号为空");
		}
		if ((isEmpty(ACCOUNT_TOKEN))) {
			return getMyError("172007", "主帐号TOKEN为空");
		}
		if ((isEmpty(App_ID))) {
			return getMyError("172012", "应用ID为空");
		}
		return null;
	}

}