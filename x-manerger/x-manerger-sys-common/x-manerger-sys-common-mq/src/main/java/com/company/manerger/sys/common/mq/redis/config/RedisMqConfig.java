package com.company.manerger.sys.common.mq.redis.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.company.manerger.sys.common.mq.redis.RedisListener;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;

@Configuration
public class RedisMqConfig {
    @Value("${mq.redis.TopicName}")
    private String redisTopicName;

    @Bean(name = "listenerAdapter")
    MessageListenerAdapter listenerAdapter(RedisListener redisListener) {
        return new MessageListenerAdapter(redisListener, "receiveTopic");
    }

    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory redisConnectionFactory,@Qualifier(value = "listenerAdapter") MessageListenerAdapter listenerAdapter) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(redisTopicName));
        return container;
    }

    @Bean
    public RedisTemplate<Serializable, Serializable> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<>();
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        GenericFastJsonRedisSerializer valueSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
        return redisTemplate;
    }
}
