package cn.jeeweb.modules.sms.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.sms.entity.SmsTemplate;
import cn.jeeweb.modules.sms.mapper.SmsTemplateMapper;
import cn.jeeweb.modules.sms.service.ISmsTemplateService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Title: 短信模版
 * @Description: 短信模版
 * @author jeeweb
 * @date 2017-06-08 10:50:52
 * @version V1.0
 *
 */
@Transactional
@Service("smsTemplateService")
public class SmsTemplateServiceImpl extends CommonServiceImpl<SmsTemplateMapper,SmsTemplate> implements ISmsTemplateService {
}
