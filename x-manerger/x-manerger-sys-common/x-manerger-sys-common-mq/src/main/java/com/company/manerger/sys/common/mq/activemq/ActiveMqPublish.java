package com.company.manerger.sys.common.mq.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import javax.jms.Topic;

@Component
public class ActiveMqPublish {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource(name = "activeMqQueue")
    private Queue queue;
    @Resource(name = "activeMqTopic")
    private Topic topic;

    public void sendMessage(Destination destination,final String message){
        jmsMessagingTemplate.convertAndSend(destination,message);
    }

    /**
     *生产/消费模式
     */
    public void sendMessageToQueue(final String message){
        jmsMessagingTemplate.convertAndSend(queue,message);
    }

    /**
     * 发布/订阅模式
     */
    public void sendMessageToTopic(final String message){
        jmsMessagingTemplate.convertAndSend(topic,message);
    }
}
