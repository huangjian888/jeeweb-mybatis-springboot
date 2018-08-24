package cn.jeeweb.modules.sms.dao;

import cn.jeeweb.core.disruptor.sms.SmsDao;
import cn.jeeweb.core.disruptor.sms.SmsData;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.core.utils.sms.data.SmsResult;
import cn.jeeweb.modules.sms.entity.SmsSendLog;
import cn.jeeweb.modules.sms.entity.SmsTemplate;
import cn.jeeweb.modules.sms.service.ISmsSendLogService;
import cn.jeeweb.modules.sms.service.ISmsTemplateService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: SmsDaoIml.java
 * @package cn.jeeweb.modules.sms.dao
 * @description: 短信信息返回
 * @author: auth_team
 * @date: 2017年6月8日 上午11:20:04
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
public class SmsDaoIml implements SmsDao {
	@Autowired
	private ISmsSendLogService smsSendLogService;
	@Autowired
	private ISmsTemplateService smsTemplateService;

	@Override
	public void doStart() {

	}

	@Override
	public void doSend(String eventId, SmsData smsData) {
		SmsSendLog smsSendLog = new SmsSendLog();
		smsSendLog.setId(eventId);
		String templateId = smsData.getSmsTemplate().getTemplateId();
		try {
			SmsTemplate smsTemplateEntity = smsTemplateService
					.selectOne(new EntityWrapper<SmsTemplate>().eq("templateId", templateId));
			if (smsTemplateEntity != null) {
				smsSendLog.setBusinessType(smsTemplateEntity.getBusinessType());
			} else {
				smsSendLog.setBusinessType("99");
			}
		} catch (Exception e) {
			smsSendLog.setBusinessType("99");
		}

		smsSendLog.setTemplateContent(smsData.getSmsTemplate().getTemplateContent());
		smsSendLog.setTemplateId(smsData.getSmsTemplate().getTemplateId());
		smsSendLog.setPhone(smsData.getPhone());
		smsSendLog.setSenddata(StringUtils.join(smsData.getDatas(), ","));
		smsSendLog.setStatus("0");
		smsSendLogService.insert(smsSendLog);
	}

	@Override
	public void doResult(String eventId, SmsData smsData, SmsResult smsResult) {
		SmsSendLog smsSendLog = smsSendLogService.selectById(eventId);
		smsSendLog.setCode(smsResult.getCode());
		smsSendLog.setMsg(smsResult.getMsg());
		smsSendLog.setSmsid(smsResult.getSmsid());
		if (smsResult.isSuccess()) {
			smsSendLog.setStatus("1");
		} else {
			smsSendLog.setStatus("0");
		}
		smsSendLog.setResponseDate(new Date());
		smsSendLogService.insertOrUpdate(smsSendLog);
	}

	@Override
	public void doShutdown() {

	}

}
