package cn.jeeweb.core.support.redis;


import cn.jeeweb.modules.sys.Constants;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by hexin on 2018/9/3.
 */
public class RedisCacheManager implements CacheManager {
    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();
    private String keyPrefix = Constants.REDIS_SHIRO_CACHE;

    public String getKeyPrefix() {
        return keyPrefix;
    }
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        System.out.println("获取名称为: " + name + " 的RedisCache实例");
        Cache c = caches.get(name);
        if (c == null) {
            RedisCache cache = new RedisCache<K, V>(keyPrefix);
            caches.put(name, cache);
//            c = cache;
        }
        System.out.println("getCache:"+ name +":"+c);
        return c;
    }
}
