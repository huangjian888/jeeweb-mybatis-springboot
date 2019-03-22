package com.company.manerger.sys.common.mq.rocketmq;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RocketMqPublish {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送
     * @param destination
     * @param payload
     */
    public void syncSend(String destination, Object payload){
        rocketMQTemplate.syncSend(destination,payload);
    }

    /**
     * 同步发送
     * @param destination
     * @param message
     */
    public void syncSend(String destination, Message<?> message){
        rocketMQTemplate.syncSend(destination, message);
    }

    /**
     * 异步发送
     * @param destination
     * @param payload
     * @param sendCallback
     */
    public void asyncSend(String destination, Object payload, SendCallback sendCallback){
        rocketMQTemplate.asyncSend(destination, payload, sendCallback);
    }

    /**
     * 用特殊标签发送消息
     * @param destination
     * @param tag
     * @param payload
     */
    public void convertAndSend(String destination,String tag,Object payload){
        String _destination = destination + ":" + tag;
        rocketMQTemplate.convertAndSend(_destination,payload);
    }

    /**
     * 事务消息
     * @param txProducerGroup
     * @param destination
     * @param message
     * @param arg
     */
    public void sendMessageInTransaction(String txProducerGroup, String destination, Message<?> message, Object arg){
        rocketMQTemplate.sendMessageInTransaction(txProducerGroup,destination,message,arg);
    }

    /**
     * 其他方式参考rocketMQTemplate ->顺序发送/消费...
     */
}
