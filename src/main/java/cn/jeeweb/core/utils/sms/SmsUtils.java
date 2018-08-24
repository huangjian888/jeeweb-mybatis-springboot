package cn.jeeweb.core.utils.sms;

import cn.jeeweb.core.utils.sms.data.SmsTemplate;
import cn.jeeweb.core.utils.sms.exception.NullException;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: SmsUtils.java
 * @package cn.jeeweb.core.utils.sms
 * @description: 短信发送工具测试类
 * @author: auth_team
 * @date: 2017年6月7日 下午11:11:00
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class SmsUtils {
	public static void main(String[] args) throws NullException {
		String templateContent = "您的验证码是：{1}。请不要把验证码泄露给其他人。";
		SmsTemplate smsTemplate = SmsTemplate.newTemplateByContent(templateContent);
		SmsManager.getSmsManager().send("15085980308,14785571304", smsTemplate, "2345");
	}
}
