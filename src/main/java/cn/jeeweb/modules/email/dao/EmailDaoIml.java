package cn.jeeweb.modules.email.dao;

import cn.jeeweb.core.disruptor.email.EmailDao;
import cn.jeeweb.core.disruptor.email.EmailData;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.email.EmailResult;
import cn.jeeweb.modules.email.entity.EmailSendLog;
import cn.jeeweb.modules.email.service.IEmailSendLogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: EmailDaoIml.java
 * @package cn.jeeweb.modules.email.dao
 * @description: 邮件信息返回
 * @author: auth_team
 * @date: 2017年6月8日 上午11:20:04
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class EmailDaoIml implements EmailDao {
	@Autowired
	private IEmailSendLogService emailSendLogService;

	@Override
	public void doStart() {

	}

	@Override
	public void doSend(String eventId, EmailData emailData) {
		EmailSendLog emailSendLog = new EmailSendLog();
		emailSendLog.setId(eventId);
		emailSendLog.setBusinessType(emailData.getBusinessType());
		emailSendLog.setSubject(emailData.getSubject());
		emailSendLog.setContent(emailData.getContent());
		emailSendLog.setEmail(emailData.getEmail());
		emailSendLog.setSenddata(StringUtils.join(emailData.getDatas(), ","));
		emailSendLog.setStatus("0");
		emailSendLogService.insert(emailSendLog);
	}

	@Override
	public void doResult(String eventId, EmailData emailData, EmailResult emailResult) {
		EmailSendLog emailSendLog = emailSendLogService.selectById(eventId);
		emailSendLog.setMsg(emailResult.getMsg());
		if (emailResult.isSuccess()) {
			emailSendLog.setStatus("1");
		} else {
			emailSendLog.setStatus("0");
		}
		emailSendLog.setResponseDate(new Date());
		emailSendLogService.insertOrUpdate(emailSendLog);
	}

	@Override
	public void doShutdown() {

	}

}
