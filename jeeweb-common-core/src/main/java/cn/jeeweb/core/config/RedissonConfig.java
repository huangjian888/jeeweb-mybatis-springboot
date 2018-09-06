package cn.jeeweb.core.config;

import cn.jeeweb.core.support.redis.Client;
import cn.jeeweb.core.support.redis.RedissonHelper;
import cn.jeeweb.core.utils.PropertiesUtil;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hexin on 2018/9/4.
 */
@Configuration
public class RedissonConfig {

    @Bean(name = "redissonClient")
    public RedissonClient redissonClient(){
        PropertiesUtil propertiesUtil = new PropertiesUtil("redis.properties");
        Client client = new Client();
        String nodes = propertiesUtil.getString("redis.cluster.nodes");
        String master = propertiesUtil.getString("redis.master");
        String sentinels = propertiesUtil.getString("redis.sentinels");
        if (StringUtils.isNotBlank(nodes)) {
            client.setNodeAddresses(nodes);
        } else if (StringUtils.isNotEmpty(master) && StringUtils.isNotEmpty(sentinels)) {
            client.setMasterAddress(master);
            client.setSlaveAddresses(sentinels);
        } else {
            String address = "redis://" + propertiesUtil.getString("redis.host") + ":" + propertiesUtil.getString("redis.port");
            client.setAddress(address);
        }
        client.setPassword(propertiesUtil.getString("redis.password"));
        client.setTimeout(propertiesUtil.getInt("redis.timeout"));
        return client.getRedissonClient();
    }

    @Bean(name = "redissonHelper")
    public RedissonHelper redissonHelper(@Qualifier("redissonClient") RedissonClient redissonClient){
        RedissonHelper redissonHelper = new RedissonHelper();
        redissonHelper.setRedissonClient(redissonClient);
        return redissonHelper;
    }

}
