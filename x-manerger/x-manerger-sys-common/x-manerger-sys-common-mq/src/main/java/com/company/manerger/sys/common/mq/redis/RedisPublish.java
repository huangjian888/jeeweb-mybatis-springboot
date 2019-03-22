package com.company.manerger.sys.common.mq.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class RedisPublish {
    @Autowired
    private RedisTemplate<Serializable, Serializable> redisTemplate;

    /**
     * 发布/订阅模式 redis不适合生产消费模式,消费监听只能轮训
     */
    public void sendMessageToTopic(String channel,String message){
        redisTemplate.convertAndSend(channel,message);
    }
}
