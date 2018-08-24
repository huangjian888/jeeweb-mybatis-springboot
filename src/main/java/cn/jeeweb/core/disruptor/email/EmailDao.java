package cn.jeeweb.core.disruptor.email;

import cn.jeeweb.core.utils.email.EmailResult;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: SmsDao.java
 * @package cn.jeeweb.core.disruptor.sms
 * @description: 短信dao
 * @author: auth_team
 * @date: 2017年6月8日 上午8:42:47
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 * 
 */
public interface EmailDao {
	/**
	 * 
	 * @title: doStart
	 * @description:初始化回调
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doStart();

	/**
	 * 
	 * @title: doShutdown
	 * @description:关闭
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doShutdown();

	/**
	 * 
	 * @title: doShutdown
	 * @description:发送短信
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doSend(String eventId, EmailData emailData);

	/**
	 * 
	 * @title: doShutdown
	 * @description:响应
	 * @return: void
	 */
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public void doResult(String eventId, EmailData emailData, EmailResult emailResult);
}