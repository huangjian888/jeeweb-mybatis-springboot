package com.company.manerger.sys.common.email.disruptor;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.context.properties.PropertyMapper;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.nio.charset.Charset;
import java.util.Map;
import java.util.Properties;

/**
 * 文件上传Factory
 */
public final class MailSenderFactory {

    public static JavaMailSender build(MailProperties mailProperties){
        if (mailProperties == null){
            return SpringContextHolder.getBean(JavaMailSender.class);
        }else{
            JavaMailSenderImpl sender = new JavaMailSenderImpl();
            MailSenderCondition.build(sender,mailProperties);
        }
        return null;
    }

    /**
     * 发生器构建
     */
    public static class MailSenderCondition{

        public static  void build(JavaMailSenderImpl sender,MailProperties mailPropertie){
            new MailSenderCondition(sender,mailPropertie);
        }
        public MailSenderCondition(JavaMailSenderImpl sender,MailProperties mailProperties){
            this.applyProperties(sender,mailProperties);
        }
        private void applyProperties(JavaMailSenderImpl sender,MailProperties mailProperties) {
            PropertyMapper map = PropertyMapper.get();
            map.from(mailProperties::getHost).to(sender::setHost);
            map.from(mailProperties::getPort).whenNonNull().to(sender::setPort);
            map.from(mailProperties::getUsername).to(sender::setUsername);
            map.from(mailProperties::getPassword).to(sender::setPassword);
            map.from(mailProperties::getProtocol).to(sender::setProtocol);
            map.from(mailProperties::getDefaultEncoding).whenNonNull().as(Charset::name).to(sender::setDefaultEncoding);
            map.from(mailProperties::getProperties).whenNot(Map::isEmpty).as(this::asProperties).to(sender::setJavaMailProperties);
        }

    private Properties asProperties(Map<String, String> source) {
        Properties properties = new Properties();
        properties.putAll(source);
        return properties;
    }
    }
}