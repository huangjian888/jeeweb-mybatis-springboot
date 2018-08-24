package cn.jeeweb.core.disruptor.email;

import cn.jeeweb.core.utils.email.Email;
import cn.jeeweb.core.utils.email.EmailResult;
import com.lmax.disruptor.WorkHandler;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: SmsHandler.java
 * @package cn.jeeweb.core.disruptor.sms
 * @description: 内容消费者
 * @author: auth_team
 * @date: 2017年6月7日 下午11:20:32
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class EmailHandler implements WorkHandler<EmailEvent> {
	private EmailDao emailDao;

	public EmailHandler(EmailDao emailDao) {
		this.emailDao = emailDao;
	}

	@Override
	public void onEvent(EmailEvent event) throws Exception {
		EmailResult emailResult = Email.newEmail().send(event.getEmailData().getEmail(),
				event.getEmailData().getSubject(), event.getEmailData().getContent());
		if (event.getHandlerCallBack() != null) {
			event.getHandlerCallBack().onResult(emailResult);
		}

		if (emailDao != null) {
			emailDao.doResult(event.getId(), event.getEmailData(), emailResult);
		}
	}

}