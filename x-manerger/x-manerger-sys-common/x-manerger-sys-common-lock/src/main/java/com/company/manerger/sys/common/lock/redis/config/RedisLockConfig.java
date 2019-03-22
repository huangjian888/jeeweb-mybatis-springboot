package com.company.manerger.sys.common.lock.redis.config;

import com.company.manerger.sys.common.lock.LockExecutor;
import com.company.manerger.sys.common.lock.redis.condition.RedisLockCondition;
import com.company.manerger.sys.common.lock.redis.impl.RedisLockExecutorImpl;
import com.company.manerger.sys.common.lock.redis.redisson.handler.RedissonHandler;
import com.company.manerger.sys.common.lock.redis.redisson.handler.RedissonHandlerImpl;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisLockConfig {
    @Value("${redisson.path}")
    private String redissonPath;

    @Bean
    @Conditional(RedisLockCondition.class)
    public RedissonHandler redissonHandler() {
        return new RedissonHandlerImpl(redissonPath);
    }

    @Bean(name = "redisLockExecutor")
    @Conditional(RedisLockCondition.class)
    public LockExecutor<RLock> redisLockExecutor() {
        return new RedisLockExecutorImpl();
    }
}
