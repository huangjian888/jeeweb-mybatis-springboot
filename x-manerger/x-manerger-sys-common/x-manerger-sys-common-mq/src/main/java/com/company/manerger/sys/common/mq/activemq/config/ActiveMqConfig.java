package com.company.manerger.sys.common.mq.activemq.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

@Configuration
public class ActiveMqConfig {
    @Value("${mq.activeMq.QueueName}")
    private String activeMqQueueName;
    @Value("${mq.activeMq.TopicName}")
    private String activeMqTopicName;
    @Value("${mq.activeMq.userName}")
    private String userName;
    @Value("${mq.activeMq.passWord}")
    private String passWord;
    @Value("${mq.activeMq.brokerUrl}")
    private String brokerUrl;

    @Bean(name = "activeMqQueue")
    public Queue activeMqQueue(){
        return new ActiveMQQueue(activeMqQueueName);
    }

    @Bean(name = "activeMqTopic")
    public Topic activeMqTopic(){
        return new ActiveMQTopic(activeMqTopicName);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(userName, passWord, brokerUrl);
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);
        return bean;
    }

}
