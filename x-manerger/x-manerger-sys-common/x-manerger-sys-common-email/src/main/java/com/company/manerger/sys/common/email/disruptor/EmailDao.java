package com.company.manerger.sys.common.email.disruptor;

import com.company.manerger.sys.common.email.data.EmailResult;

/**
 * @description: 短信dao
 */
public interface EmailDao {

	/**
	 * 
	 * @title: doResult
	 * @description:响应
	 * @return: void
	 */
	public void doResult(String eventId, EmailData emailData, EmailResult emailResult);
}