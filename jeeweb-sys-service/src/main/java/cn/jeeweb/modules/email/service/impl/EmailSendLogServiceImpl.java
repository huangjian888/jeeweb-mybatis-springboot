package cn.jeeweb.modules.email.service.impl;

import cn.jeeweb.core.common.service.impl.CommonServiceImpl;
import cn.jeeweb.modules.email.entity.EmailSendLog;
import cn.jeeweb.modules.email.mapper.EmailSendLogMapper;
import cn.jeeweb.modules.email.service.IEmailSendLogService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.transaction.annotation.Transactional;

/**   
 * @Title: 邮件发送日志
 * @Description: 邮件发送日志
 * @author jeeweb
 * @date 2017-06-10 07:46:06
 * @version V1.0   
 *
 */
@Transactional
@Service(interfaceClass = IEmailSendLogService.class)
public class EmailSendLogServiceImpl  extends CommonServiceImpl<EmailSendLogMapper, EmailSendLog> implements IEmailSendLogService {

	 
	 
}
