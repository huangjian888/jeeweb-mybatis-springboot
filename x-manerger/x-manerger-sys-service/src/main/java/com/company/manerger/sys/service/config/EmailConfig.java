package com.company.manerger.sys.service.config;


import com.company.manerger.sys.common.email.disruptor.EmailDao;
import com.company.manerger.sys.common.email.disruptor.EmailHelper;
import com.company.manerger.sys.service.modules.email.dao.EmailDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailConfig {

    @Bean
    public EmailDao emailDao(){
        EmailDao emailDao=  new EmailDaoImpl();
        return emailDao;
    }

    @Bean
    public EmailHelper emailHelper(EmailDao emailDao){
        EmailHelper emailHelper=  new EmailHelper();
        emailHelper.setHandlerCount(1);
        emailHelper.setBufferSize(1024);
        emailHelper.setEmailDao(emailDao);
        return emailHelper;
    }
}
