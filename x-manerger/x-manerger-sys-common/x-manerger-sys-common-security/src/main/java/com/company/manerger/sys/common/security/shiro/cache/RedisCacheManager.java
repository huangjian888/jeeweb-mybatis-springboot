package com.company.manerger.sys.common.security.shiro.cache;


import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class RedisCacheManager implements CacheManager {

    private RedisTemplate<Object, Object> redisTemplate;

    public RedisCacheManager()
    {

    }

    public RedisCacheManager(RedisTemplate<Object, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public <K, V> Cache<K, V> getCache(String name) throws CacheException {
        return new ShiroCache<K, V>(name, redisTemplate);
    }

    public RedisTemplate<Object, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public class ShiroCache<K, V> implements Cache<K, V> {

        private static final String REDIS_SHIRO_CACHE = "company-shiro-cache:";
        private String cacheKey;
        private RedisTemplate<K, V> redisTemplate;
        private long globExpire = 30;

        public RedisTemplate<K, V> getRedisTemplate() {
            return redisTemplate;
        }

        public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
            this.redisTemplate = redisTemplate;
        }

        @SuppressWarnings("rawtypes")
        public ShiroCache(String name, RedisTemplate client) {
            this.cacheKey = REDIS_SHIRO_CACHE + name + ":";
            this.redisTemplate = client;
        }

        @Override
        public V get(K key) throws CacheException {
            redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
            return redisTemplate.boundValueOps(getCacheKey(key)).get();
        }

        @Override
        public V put(K key, V value) throws CacheException {
            V old = get(key);
            redisTemplate.boundValueOps(getCacheKey(key)).set(value);
            return old;
        }

        @Override
        public V remove(K key) throws CacheException {
            V old = get(key);
            redisTemplate.delete(getCacheKey(key));
            return old;
        }

        @Override
        public void clear() throws CacheException {
            redisTemplate.delete(keys());
        }

        @Override
        public int size() {
            return keys().size();
        }

        @Override
        public Set<K> keys() {
            return redisTemplate.keys(getCacheKey("*"));
        }

        @Override
        public Collection<V> values() {
            Set<K> set = keys();
            List<V> list = new ArrayList<V>();
            for (K s : set) {
                list.add(get(s));
            }
            return list;
        }

        private K getCacheKey(Object k) {
            return (K) (this.cacheKey + k);
        }
    }

}
