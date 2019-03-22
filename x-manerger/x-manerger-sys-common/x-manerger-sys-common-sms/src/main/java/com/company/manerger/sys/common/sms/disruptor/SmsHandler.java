package com.company.manerger.sys.common.sms.disruptor;

import com.company.manerger.sys.common.sms.client.ISmsClient;
import com.company.manerger.sys.common.sms.data.SmsResult;
import com.lmax.disruptor.WorkHandler;

/**
 *
 * @description: 内容消费者
 *
 */
public class SmsHandler implements WorkHandler<SmsEvent> {
	private ISmsClient smsClient;
	private SmsDao smsDao;

	public SmsHandler(ISmsClient smsClient, SmsDao smsDao) {
		this.smsClient = smsClient;
		this.smsDao = smsDao;
	}

	@Override
	public void onEvent(SmsEvent event) throws Exception {
		if (event.getSmsData().getSmsConfigProperties()!=null){
			smsClient.init(event.getSmsData().getSmsConfigProperties());
		}
		SmsResult smsResult = null;
		if (event.getSmsData().getDatas()!=null){
			smsResult = smsClient.send(event.getSmsData().getPhone(),
					event.getSmsData().getSmsTemplate(),
					event.getSmsData().getDatas());
		}else{
			smsResult = smsClient.send(event.getSmsData().getPhone(),
					event.getSmsData().getSmsTemplate());
		}
		if (event.getHandlerCallBack() != null) {
			event.getHandlerCallBack().onResult(smsResult);
		}
		if (smsDao != null) {
			smsDao.doResult(event.getId(), event.getSmsData(), smsResult);
		}
		//休息1000毫秒
		Thread.sleep(6000);
	}

	//通过模板或的SDK
	

}