package com.company.manerger.sys.service.modules.email.service.impl;

import com.company.manerger.sys.common.email.disruptor.EmailHelper;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.common.utils.mapper.JsonMapper;
import com.company.manerger.sys.service.modules.email.entity.EmailSendLog;
import com.company.manerger.sys.service.modules.email.entity.EmailTemplate;
import com.company.manerger.sys.service.modules.email.service.IEmailSendLogService;
import com.company.manerger.sys.service.modules.email.service.IEmailSendService;
import com.company.manerger.sys.service.modules.email.service.IEmailTemplateService;
import freemarker.cache.StringTemplateLoader;
import freemarker.template.Configuration;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 邮件发送
 */
@Service("emailSendService")
public class EmailSendServiceImpl implements IEmailSendService {

    @Autowired
    private IEmailTemplateService emailTemplateService;
    @Autowired
    private IEmailSendLogService emailSendLogService;
    @Autowired
    private EmailHelper emailHelper; //自动注入的Bean

    @Value("${spring.mail.sender}")
    private String sender; //发送的人

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public void send(String email, String code, Map<String, Object> datas) {
        String[] emails = { email };
        send(emails,code,datas);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public void send(String[] emails, String code, Map<String, Object> datas) {
        EmailTemplate template = emailTemplateService.selectOne(new EntityWrapper<EmailTemplate>().eq("code", code));
        if (datas == null) {
            datas = new HashMap<>();
        }
        if (template == null){
            return ;
        }
        String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
        String subject = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateSubject()), datas);
        // List<EmailSendLog> emailSendLogList = new ArrayList<EmailSendLog>();
        for (String email: emails) {
            EmailSendLog emailSendLog = new EmailSendLog();
            emailSendLog.setEmail(email);
            emailSendLog.setSubject(subject);
            emailSendLog.setContent(content);
            emailSendLog.setMsg("发送成功");
            emailSendLog.setSendCode(code);
            emailSendLog.setResponseDate(new Date());
            emailSendLog.setSendData(JsonMapper.toJsonString(datas));
            emailSendLog.setStatus(EmailSendLog.EMAIL_SEND_STATUS_IN);
            emailSendLog.setTryNum(0);
            emailSendLog.setDelFlag("0");
            // emailSendLogList.add(emailSendLog);
            emailSendLogService.insert(emailSendLog);
            // 发送邮件
            sendEmail(emailSendLog.getId(),email,subject,content);
        }
        /*if (emailSendLogList.size()>0) {
            emailSendLogService.insertBatch(emailSendLogList);
        }*/
    }

     private void sendEmail(String eventId,String to,String subject,String text){
        try {
            MimeMessage message = emailHelper.createMimeMessage(null);//创建一个MINE消息
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(sender);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text,true);
            emailHelper.sendAsync(eventId,message,null);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
     }

    private String parseContent(String content,Map<String, Object> dataMap) {
        try {
            String tempname = StringUtils.hashKeyForDisk(content);
            Configuration configuration = new Configuration();
            configuration.setNumberFormat("#");
            StringTemplateLoader stringLoader = new StringTemplateLoader();
            stringLoader.putTemplate(tempname, content);
            freemarker.template.Template template = new freemarker.template.Template(tempname, new StringReader(content));
            StringWriter stringWriter = new StringWriter();
            template.process(dataMap, stringWriter);
            configuration.setTemplateLoader(stringLoader);
            content = stringWriter.toString();
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("模板解析失败");
        }
        return content;
    }

    @Override
    public void send(String eventId, String email, String code, Map<String, Object> datas) {
        String[] emails = { email };
        send(eventId,emails,code,datas);
    }

    @Override
    public void send(String eventId, String[] emails, String code, Map<String, Object> datas) {
        EmailTemplate template = emailTemplateService.selectOne(new EntityWrapper<EmailTemplate>().eq("code", code));
        if (datas == null) {
            datas = new HashMap<>();
        }
        if (template == null){
            return ;
        }
        String content = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateContent()), datas);
        String subject = parseContent(StringEscapeUtils.unescapeHtml4(template.getTemplateSubject()), datas);
        for (String email: emails) {
            // 发送邮件
            sendEmail(eventId,email,subject,content);
        }
    }
}
