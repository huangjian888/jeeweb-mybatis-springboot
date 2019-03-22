package com.company.manerger.sys.common.sms.disruptor;

import com.company.manerger.sys.common.sms.data.SmsResult;

/**
 * @description: 短信dao
 * 
 */
public interface SmsDao {
	/**
	 * 
	 * @title: doResult
	 * @description:响应
	 * @return: void
	 */
	void doResult(String eventId, SmsData smsData, SmsResult smsResult);
}