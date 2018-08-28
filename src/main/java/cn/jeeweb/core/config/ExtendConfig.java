package cn.jeeweb.core.config;

import cn.jeeweb.core.disruptor.email.EmailHelper;
import cn.jeeweb.core.disruptor.sms.SmsHelper;
import cn.jeeweb.core.utils.sms.sender.HuyiSmsSender;
import cn.jeeweb.modules.email.dao.EmailDaoIml;
import cn.jeeweb.modules.sms.dao.SmsDaoIml;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexin on 2018/8/28.
 */
@Configuration
public class ExtendConfig {

    @Bean
    public SmsDaoIml smsDao(){
        return new SmsDaoIml();
    }

    @Bean
    public HuyiSmsSender smsSender(){
        return new HuyiSmsSender();
    }

    @Bean
    public SmsHelper smsHelper(SmsDaoIml smsDao,HuyiSmsSender smsSender){
        SmsHelper smsHelper = new SmsHelper();
        smsHelper.setBufferSize(1024);
        smsHelper.setHandlerCount(2);
        smsHelper.setSmsDao(smsDao);
        smsHelper.setSmsSender(smsSender);
        return smsHelper;
    }

    @Bean
    public EmailDaoIml emailDao(){
        return new EmailDaoIml();
    }

    @Bean
    public EmailHelper emailHelper(EmailDaoIml emailDao){
        EmailHelper emailHelper = new EmailHelper();
        emailHelper.setHandlerCount(2);
        emailHelper.setBufferSize(1024);
        emailHelper.setEmailDao(emailDao);
        return emailHelper;
    }
}
