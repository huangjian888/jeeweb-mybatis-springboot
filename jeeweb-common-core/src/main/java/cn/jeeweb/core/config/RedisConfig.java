package cn.jeeweb.core.config;

import cn.jeeweb.core.support.redis.RedisHelper;
import cn.jeeweb.core.utils.ArrayUtils;
import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.modules.sys.Constants;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import io.lettuce.core.resource.ClientResources;
import io.lettuce.core.resource.DefaultClientResources;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.*;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;
import java.util.Set;

/**
 * Created by hexin on 2018/9/3.
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    String prefix = Constants.CACHE_NAMESPACE;

    @Bean
    public KeyGenerator keyGenerator() {
        return new KeyGenerator() {
            @Override
            public Object generate(Object o, Method method, Object... objects) {
                StringBuilder sb = new StringBuilder(prefix);
                org.springframework.cache.annotation.CacheConfig cacheConfig = o.getClass().getAnnotation(org.springframework.cache.annotation.CacheConfig.class);
                Cacheable cacheable = method.getAnnotation(Cacheable.class);
                CachePut cachePut = method.getAnnotation(CachePut.class);
                CacheEvict cacheEvict = method.getAnnotation(CacheEvict.class);
                if (cacheable != null) {
                    String[] cacheNames = cacheable.value();
                    if (org.apache.commons.lang3.ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                } else if (cachePut != null) {
                    String[] cacheNames = cachePut.value();
                    if (org.apache.commons.lang3.ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                } else if (cacheEvict != null) {
                    String[] cacheNames = cacheEvict.value();
                    if (org.apache.commons.lang3.ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                }
                if (cacheConfig != null && sb.toString().equals(prefix)) {
                    String[] cacheNames = cacheConfig.cacheNames();
                    if (org.apache.commons.lang3.ArrayUtils.isNotEmpty(cacheNames)) {
                        sb.append(cacheNames[0]);
                    }
                }
                if (sb.toString().equals(prefix)) {
                    sb.append(o.getClass().getName()).append(".").append(method.getName());
                }
                sb.append(":");
                if (objects != null) {
                    for (Object object : objects) {
                        sb.append(JSON.toJSONString(object));
                    }
                }
                return sb.toString();
            }
        };
    }

    @Bean(name = "genericObjectPoolConfig")
    public GenericObjectPoolConfig genericObjectPoolConfig(){
        PropertiesUtil propertiesUtil = new PropertiesUtil("redis.properties");
        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
        genericObjectPoolConfig.setMinIdle(propertiesUtil.getInt("redis.minIdle"));
        genericObjectPoolConfig.setMaxIdle(propertiesUtil.getInt("redis.maxIdle"));
        genericObjectPoolConfig.setMaxTotal(propertiesUtil.getInt("redis.maxTotal"));
        genericObjectPoolConfig.setMaxWaitMillis(propertiesUtil.getInt("redis.maxWaitMillis"));
        genericObjectPoolConfig.setTestOnBorrow(true);
        genericObjectPoolConfig.setTestOnReturn(true);
        // Idle时进行连接扫描
        genericObjectPoolConfig.setTestWhileIdle(true);
        // 表示idle object evitor两次扫描之间要sleep的毫秒数
        genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(30000);
        // 表示idle object evitor每次扫描的最多的对象数
        genericObjectPoolConfig.setNumTestsPerEvictionRun(10);
        // 表示一个对象至少停留在idle状态的最短时间，然后才能被idle object evitor扫描并驱逐
        // 这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
        genericObjectPoolConfig.setMinEvictableIdleTimeMillis(60000);
        return genericObjectPoolConfig;
    }

    @Bean(name = "clientResources",destroyMethod = "shutdown")
    public ClientResources clientResources(){
        return DefaultClientResources.create();
    }

    @Bean(name = "redisConnectionFactory")
    public RedisConnectionFactory redisConnectionFactory(@Qualifier("genericObjectPoolConfig") GenericObjectPoolConfig genericObjectPoolConfig,
                                                         @Qualifier("clientResources") ClientResources clientResources){
        PropertiesUtil propertiesUtil = new PropertiesUtil("redis.properties");
        LettuceConnectionFactory connectionFactory = null;
        String nodes = propertiesUtil.getString("redis.cluster.nodes");
        String master = propertiesUtil.getString("redis.master");
        String sentinels = propertiesUtil.getString("redis.sentinels");
        Duration commandTimeout = Duration.ofMillis(propertiesUtil.getInt("redis.commandTimeout", 60000));
        Duration shutdownTimeout = Duration.ofMillis(propertiesUtil.getInt("redis.shutdownTimeout", 5000));
        LettucePoolingClientConfiguration.LettucePoolingClientConfigurationBuilder builder = LettucePoolingClientConfiguration.builder()
            .poolConfig(genericObjectPoolConfig).commandTimeout(commandTimeout).shutdownTimeout(shutdownTimeout)
            .clientResources(clientResources);
        LettuceClientConfiguration clientConfiguration = builder.build();
        RedisPassword password = RedisPassword.of(propertiesUtil.getString("redis.password"));
        String host = propertiesUtil.getString("redis.host", "localhost");
        Integer port = propertiesUtil.getInt("redis.port", 6379);
        if (StringUtils.isNotEmpty(nodes)) {
            List<String> list = ArrayUtils.newArrayList(nodes.split(","));
            RedisClusterConfiguration configuration = new RedisClusterConfiguration(list);
            configuration.setMaxRedirects(propertiesUtil.getInt("redis.cluster.max-redirects"));
            configuration.setPassword(password);
            connectionFactory = new LettuceConnectionFactory(configuration, clientConfiguration);
        } else if (StringUtils.isNotEmpty(master) && StringUtils.isNotEmpty(sentinels)) {
            Set<String> set = ArrayUtils.newHashSet(sentinels.split(","));
            RedisSentinelConfiguration configuration = new RedisSentinelConfiguration(master, set);
            configuration.setPassword(password);
            connectionFactory = new LettuceConnectionFactory(configuration, clientConfiguration);
        } else {
            RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
            configuration.setPassword(password);
            configuration.setHostName(host);
            configuration.setPort(port);
            connectionFactory = new LettuceConnectionFactory(configuration, clientConfiguration);
        }
        return connectionFactory;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Serializable, Serializable> redisTemplate(@Qualifier("redisConnectionFactory") RedisConnectionFactory redisConnectionFactory) {
        PropertiesUtil propertiesUtil = new PropertiesUtil("redis.properties");
        RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        GenericFastJsonRedisSerializer valueSerializer = new GenericFastJsonRedisSerializer();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setValueSerializer(valueSerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        redisTemplate.setHashValueSerializer(valueSerializer);
        redisTemplate.setEnableTransactionSupport(new Boolean(propertiesUtil.getString("redis.enableTransaction")));
        return redisTemplate;
    }

    @Primary
    @Bean(name = "cacheManager")
    public CacheManager cacheManager(@Qualifier("redisConnectionFactory")RedisConnectionFactory redisConnectionFactory) {
        PropertiesUtil propertiesUtil = new PropertiesUtil("redis.properties");
        RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(propertiesUtil.getInt("redis.cache.ttl", 10)));
        RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory).cacheDefaults(configuration);
        if (new Boolean(propertiesUtil.getString("redis.cache.enableTransaction"))) {
            builder.transactionAware();
        }
        RedisCacheManager cacheManager = builder.build();
        return cacheManager;
    }

    @Bean(name = "redisHelper")
    public RedisHelper redisHelper(@Qualifier("redisTemplate") RedisTemplate<Serializable, Serializable> redisTemplate){
        return new RedisHelper(redisTemplate);
    }
}
