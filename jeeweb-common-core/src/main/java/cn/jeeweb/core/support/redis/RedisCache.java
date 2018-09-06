package cn.jeeweb.core.support.redis;

import cn.jeeweb.core.utils.CacheUtils;
import cn.jeeweb.modules.sys.Constants;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.util.CollectionUtils;

import java.io.Serializable;
import java.util.*;

/**
 * Created by hexin on 2018/9/3.
 */
public class RedisCache<K, V> implements Cache<K, V> {
    private String keyPrefix = Constants.REDIS_SHIRO_CACHE;

    public String getKeyPrefix() {
        return keyPrefix;
    }
    public void setKeyPrefix(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }

    public RedisCache(String prefix) {
        // set the prefix
        this.keyPrefix = prefix;
    }

    @Override
    public V get(K key) throws CacheException {
        System.out.println("根据key从Redis中获取对象 key [" + key + "]");
        @SuppressWarnings("unchecked")
        V value = (V) CacheUtils.getCache().getFire(getKey(key));
        return value;
    }

    @Override
    public V put(K key, V value) throws CacheException {
        System.out.println("根据key从存储 key [" + key + "]");
        CacheUtils.getCache().set(getKey(key), (Serializable)value);
        return value;
    }

    @Override
    public V remove(K key) throws CacheException {
        System.out.println("从redis中删除 key [" + key + "]");
        V previous = get(key);
        CacheUtils.getCache().del(getKey(key));
        return previous;
    }

    @Override
    public void clear() throws CacheException {
        System.out.println("从redis中删除所有元素");
        CacheUtils.getCache().delAll(this.keyPrefix + "*");
    }

    @Override
    public int size() {
        return CacheUtils.getCache().getAll(this.keyPrefix + "*").size();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Set<K> keys() {
        Set<Object> keys = CacheUtils.getCache().getAll(this.keyPrefix + "*");
        if (CollectionUtils.isEmpty(keys)) {
            return Collections.emptySet();
        } else {
            Set<K> newKeys = new HashSet<K>();
            for (Object key : keys) {
                newKeys.add((K)key);
            }
            return newKeys;
        }
    }

    @Override
    public Collection<V> values() {
        Set<Object> keys = CacheUtils.getCache().getAll(this.keyPrefix + "*");
        if (!CollectionUtils.isEmpty(keys)) {
            List<V> values = new ArrayList<V>(keys.size());
            for (Object key : keys) {
                @SuppressWarnings("unchecked")
                V value = get((K)key);
                if (value != null) {
                    values.add(value);
                }
            }
            return Collections.unmodifiableList(values);
        } else {
            return Collections.emptyList();
        }
    }

    private String getKey(K key) {
        return this.keyPrefix + key;
    }
}
