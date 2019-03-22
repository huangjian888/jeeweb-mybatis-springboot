package com.company.manerger.sys.common.mq.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMqListener {
    public final String activeMqQueueName = "activemq.publish.queue";
    public final String activeMqTopicName = "activemq.publish.topic";

    @JmsListener(destination = activeMqQueueName, containerFactory = "jmsListenerContainerQueue")
    public void receiveQueue(String message){
        /**
         * 消费者回调
         */
    }

    @JmsListener(destination = activeMqTopicName, containerFactory = "jmsListenerContainerTopic")
    public void receiveTopic(String message){
        /**
         * 订阅回调
         */

    }
}
