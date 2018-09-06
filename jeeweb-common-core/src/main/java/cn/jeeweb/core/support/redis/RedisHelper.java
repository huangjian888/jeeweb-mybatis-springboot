package cn.jeeweb.core.support.redis;

import cn.jeeweb.core.utils.ArrayUtils;
import cn.jeeweb.core.utils.PropertiesUtil;
import cn.jeeweb.core.utils.SpringContextHolder;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.types.Expiration;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import cn.jeeweb.core.utils.CacheUtils;

public final class RedisHelper implements CacheManager {
    private RedisTemplate<Serializable, Serializable> redisTemplate;
    private final Integer EXPIRE = new PropertiesUtil("redis.properties").getInt("redis.expiration");

    public RedisHelper(RedisTemplate<Serializable, Serializable> redisTemplate) {
        this.redisTemplate = redisTemplate;
        CacheUtils.setCacheManager(this);
    }

    @SuppressWarnings("unchecked")
    public RedisTemplate<Serializable, Serializable> getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = SpringContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }

    @Override
    public final Object get(final String key) {
        return getRedisTemplate().boundValueOps(key).get();
    }

    @Override
    public final Object get(final String key, Integer expire) {
        expire(key, expire);
        return getRedisTemplate().boundValueOps(key).get();
    }

    @Override
    public final Object getFire(final String key) {
        expire(key, EXPIRE);
        return getRedisTemplate().boundValueOps(key).get();
    }

    @Override
    public final Set<Object> getAll(final String pattern) {
        Set<Object> values = ArrayUtils.newHashSet();
        Set<Serializable> keys = getRedisTemplate().keys(pattern);
        for (Serializable key : keys) {
            values.add(getRedisTemplate().opsForValue().get(key));
        }
        return values;
    }

    @Override
    public final Set<Object> getAll(final String pattern, Integer expire) {
        Set<Object> values = ArrayUtils.newHashSet();
        Set<Serializable> keys = getRedisTemplate().keys(pattern);
        for (Serializable key : keys) {
            expire(key.toString(), expire);
            values.add(getRedisTemplate().opsForValue().get(key));
        }
        return values;
    }

    @Override
    public final void set(final String key, final Serializable value, int seconds) {
        getRedisTemplate().boundValueOps(key).set(value);
        expire(key, seconds);
    }

    @Override
    public final void set(final String key, final Serializable value) {
        getRedisTemplate().boundValueOps(key).set(value);
        expire(key, EXPIRE);
    }

    @Override
    public final Boolean exists(final String key) {
        return getRedisTemplate().hasKey(key);
    }

    @Override
    public final void del(final String key) {
        getRedisTemplate().delete(key);
    }

    @Override
    public final void delAll(final String pattern) {
        getRedisTemplate().delete(getRedisTemplate().keys(pattern));
    }

    @Override
    public final String type(final String key) {
        return getRedisTemplate().type(key).getClass().getName();
    }

    /**
     * 在某段时间后失效
     * @return
     */
    @Override
    public final Boolean expire(final String key, final int seconds) {
        return getRedisTemplate().expire(key, seconds, TimeUnit.SECONDS);
    }

    /**
     * 在某个时间点失效
     * @param key
     * @param unixTime
     * @return
     */
    @Override
    public final Boolean expireAt(final String key, final long unixTime) {
        return getRedisTemplate().expireAt(key, new Date(unixTime));
    }

    @Override
    public final Long ttl(final String key) {
        return getRedisTemplate().getExpire(key, TimeUnit.SECONDS);
    }

    @Override
    public final void setrange(final String key, final long offset, final String value) {
        getRedisTemplate().boundValueOps(key).set(value, offset);
    }

    @Override
    public final String getrange(final String key, final long startOffset, final long endOffset) {
        return getRedisTemplate().boundValueOps(key).get(startOffset, endOffset);
    }

    @Override
    public final Object getSet(final String key, final Serializable value) {
        return getRedisTemplate().boundValueOps(key).getAndSet(value);
    }

    @Override
    public boolean setnx(String key, Serializable value) {
        return getRedisTemplate().boundValueOps(key).setIfAbsent(value);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private byte[] rawKey(Object key) {
        Assert.notNull(key, "non null key required");
        RedisSerializer keySerializer = getRedisTemplate().getKeySerializer();
        if (keySerializer == null && key instanceof byte[]) {
            return (byte[])key;
        }
        return keySerializer.serialize(key);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    private byte[] rawValue(Object value) {
        RedisSerializer valueSerializer = getRedisTemplate().getValueSerializer();
        if (valueSerializer == null && value instanceof byte[]) {
            return (byte[])value;
        }
        return valueSerializer.serialize(value);
    }

    @Override
    public boolean lock(String key, String requestId, long seconds) {
        return getRedisTemplate().execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.set(rawKey(key), rawValue(requestId), Expiration.seconds(seconds),
                    SetOption.ifAbsent());
            }
        });
    }

    @Override
    public boolean unlock(String key, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        return getRedisTemplate().execute(new DefaultRedisScript<Boolean>(script, Boolean.class), ArrayUtils.newArrayList(key), requestId);
    }

    @Override
    public void hset(String key, Serializable field, Serializable value) {
        getRedisTemplate().boundHashOps(key).put(field, value);
    }

    @Override
    public Object hget(String key, Serializable field) {
        return getRedisTemplate().boundHashOps(key).get(field);
    }

    @Override
    public void hdel(String key, Serializable field) {
        getRedisTemplate().boundHashOps(key).delete(field);
    }

    @Override
    public Long incr(String key) {
        return getRedisTemplate().boundValueOps(key).increment(1L);
    }

}
