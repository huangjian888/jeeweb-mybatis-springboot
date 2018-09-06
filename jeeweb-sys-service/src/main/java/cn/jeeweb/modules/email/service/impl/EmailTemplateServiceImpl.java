package cn.jeeweb.modules.email.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.email.entity.EmailTemplate;
import cn.jeeweb.modules.email.mapper.EmailTemplateMapper;
import cn.jeeweb.modules.email.service.IEmailTemplateService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 邮件发送模板
 * @Description: 邮件发送模板
 * @author jeeweb
 * @date 2017-06-10 07:46:14
 * @version V1.0   
 *
 */
@Transactional
@Service(interfaceClass = IEmailTemplateService.class)
public class EmailTemplateServiceImpl  extends CommonServiceImpl<EmailTemplateMapper,EmailTemplate> implements IEmailTemplateService {

}
