//接口类型：互亿无线触发短信接口，支持发送验证码短信、订单通知短信等。
//账户注册：请通过该地址开通账户http://sms.ihuyi.com/register.html
//注意事项：
//（1）调试期间，请用默认的模板进行测试，默认模板详见接口文档；
//（2）请使用 用户名(例如：cf_demo123)及 APIkey来调用接口，APIkey在会员中心可以获取；
//（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；
package com.company.manerger.sys.common.sms.utils.huyi;

import com.company.manerger.sys.common.utils.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HuyiRestSDK {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());

	private String SERVER_URL;
	private String ACCOUNT_NAME;
	private String ACCOUNT_PASSWORD;

	/**
	 * 初始化服务地址和端口
	 * 
	 * @param serverUrl
	 *            必选参数 服务器地址
	 */
	public void init(String serverUrl) {
		if (StringUtils.isEmpty(serverUrl)) {
			logger.error("初始化异常:serverUrl为空");
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
			logger.error("初始化异常:accountName或accountPassword为空");
			throw new IllegalArgumentException("必选参数:" + (StringUtils.isEmpty(accountName) ? " 帐号" : "")
					+ (StringUtils.isEmpty(accountPassword) ? " 密码 " : "") + "为空");
		}
		ACCOUNT_NAME = accountName;
		ACCOUNT_PASSWORD = accountPassword;
	}

	public Map<String, Object> sendMsg(String mobile, String content){
		Map<String, Object> resultData = new HashMap<String, Object>();
		HttpClient  httpClient = new DefaultHttpClient();
		if ((StringUtils.isEmpty(mobile)) || (StringUtils.isEmpty(content)) )
			throw new IllegalArgumentException(
					"必选参数:" + (StringUtils.isEmpty(mobile) ? " 手机号码 " : "") + (StringUtils.isEmpty(content) ? " 內容 " : "") + "为空");
		int status=0;
		try {
			HttpPost httppost = new HttpPost(SERVER_URL+"?method=Submit");
			// 设置参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
			params.add(new BasicNameValuePair("account", ACCOUNT_NAME));
			params.add(new BasicNameValuePair("password", ACCOUNT_PASSWORD));
			params.add(new BasicNameValuePair("mobile", mobile));
			params.add(new BasicNameValuePair("content", content));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"GBK");
			httppost.setEntity(entity);
			// 发送请求
			HttpResponse httpresponse = httpClient.execute(httppost);
			status=httpresponse.getStatusLine().getStatusCode();
			if(status == 200)
			{
				// 获取返回数据
				HttpEntity responseEntity = httpresponse.getEntity();
				String body = EntityUtils.toString(responseEntity);
				if (responseEntity != null) {
					responseEntity.consumeContent();
				}

				Document doc = DocumentHelper.parseText(body);
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
			}
		}catch (UnsupportedEncodingException e) {
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


	/**
	 * 获得发送的内容
	 *
	 * @title: getReply
	 * @description: TODO(这里用一句话描述这个方法的作用)
	 * @return
	 * @return: Map<String,Object>
	 */
	public Map<String, Object> getReply() {
		Map<String, Object> resultData = new HashMap<String, Object>();
		HttpClient  httpClient = new DefaultHttpClient();
		int status=0;
		try {
			HttpPost httppost = new HttpPost(SERVER_URL+"?method=GetReply");
			// 设置参数
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// 查看密码请登录用户中心->验证码、通知短信->帐户及签名设置->APIKEY
			params.add(new BasicNameValuePair("account", ACCOUNT_NAME));
			params.add(new BasicNameValuePair("password", ACCOUNT_PASSWORD));
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(params,"GBK");
			httppost.setEntity(entity);
			// 发送请求
			HttpResponse httpresponse = httpClient.execute(httppost);
			status=httpresponse.getStatusLine().getStatusCode();
			if(status == 200)
			{
				// 获取返回数据
				HttpEntity responseEntity = httpresponse.getEntity();
				String body = EntityUtils.toString(responseEntity);
				if (responseEntity != null) {
					responseEntity.consumeContent();
				}

				Document doc = DocumentHelper.parseText(body);
				Element root = doc.getRootElement();

				String code = root.elementText("code");
				String msg = root.elementText("msg");
				String smsid = root.elementText("smsid");
				resultData.put("code", code);
				resultData.put("msg", msg);
				resultData.put("smsid", smsid);
				if ("2".equals(code)) {
					logger.info("短信获取成功");
				} else {
					logger.error(msg);
				}
			}
		}catch (UnsupportedEncodingException e) {
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

}