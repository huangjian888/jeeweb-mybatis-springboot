package cn.jeeweb.modules.email.service;

import cn.jeeweb.core.disruptor.email.EmailEvent.EmailHandlerCallBack;
import cn.jeeweb.core.utils.email.EmailResult;

/**
 * @Title: 邮件模版
 * @Description: 邮件模版
 * @author jeeweb
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
public interface IEmailSendService {
	/**
	 * 
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送邮件
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public void sendAsyncEmailByCode(String email, String code, String... datas);

	/**
	 * 
	 * @title: sendAsyncEmailByCode
	 * @description: 通过模版编码发送邮件
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public void sendAsyncEmailByCode(String email, String code, EmailHandlerCallBack callBack, String... datas);

	/**
	 * 
	 * @title: sendSyncEmailByCode
	 * @description: 通过模版编码发送邮件
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public EmailResult sendSyncEmailByCode(String email, String code, String... datas);

	/**
	 * 
	 * @title: sendAsyncEmail
	 * @description: 通过內容异步方式发送邮件
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public void sendAsyncEmail(String email, String subject, String content, String... datas);

	/**
	 * 
	 * @title: sendAsyncEmail
	 * @description: 通过內容异步方式发送邮件
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public void sendAsyncEmail(String email, String subject, String content, EmailHandlerCallBack callBack,
                               String... datas);

	/**
	 * 
	 * @title: sendSyncEmail
	 * @description: 通过內容同步方式发送邮件
	 * @param email
	 * @param code
	 * @param datas
	 * @return
	 */
	public EmailResult sendSyncEmail(String email, String subject, String content, String... datas);

}
