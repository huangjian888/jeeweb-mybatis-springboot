package com.company.business.goods.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.company.business.goods.common.constant.GlobalConstant;
import com.company.business.goods.support.redis.RedisHelper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.lang.reflect.Method;

@Configuration
@ConfigurationProperties(prefix = "company.redis")
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    private String prefix = GlobalConstant.CACHE_NAMESPACE;
    private int expiration = 600;

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public void setExpiration(int expiration) {
        this.expiration = expiration;
    }


    @Primary
    @Bean(name = "cacheManager")
    public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
        //初始化一个RedisCacheWriter
        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(connectionFactory);
        RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig();
        //初始化RedisCacheManager
        RedisCacheManager cacheManager = new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
        return cacheManager;
    }

    @Bean
    public KeyGenerator redisKeyGenerator() {

        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb = new StringBuilder(prefix);
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object obj : params) {
                    sb.append(obj.toString());
                }
                return sb.toString();
            }
        };
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

    @Bean(name = "redisHelper")
    public RedisHelper redisHelper(@Qualifier("redisTemplate") RedisTemplate<Serializable, Serializable> redisTemplate) {
        return new RedisHelper(redisTemplate, expiration);
    }
}
