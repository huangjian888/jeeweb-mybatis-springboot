package cn.jeeweb.core.support.redis;

import cn.jeeweb.core.utils.ArrayUtils;
import cn.jeeweb.core.utils.CacheUtils;
import cn.jeeweb.core.utils.PropertiesUtil;
import org.redisson.api.RBucket;
import org.redisson.api.RScript.Mode;
import org.redisson.api.RScript.ReturnType;
import org.redisson.api.RType;
import org.redisson.api.RedissonClient;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 *
 * Redis缓存辅助类
 *
 */
public class RedissonHelper implements CacheManager {
    private RedissonClient redissonClient;
    private final Integer EXPIRE = new PropertiesUtil("redis.properties").getInt("redis.expiration");

    public void setClient(Client Client) {
        redissonClient = Client.getRedissonClient();
        CacheUtils.setLockManager(this);
    }

    public void setRedissonClient(RedissonClient redissonClient) {
        this.redissonClient = redissonClient;
        CacheUtils.setLockManager(this);
    }

    private RBucket<Object> getRedisBucket(String key) {
        return redissonClient.getBucket(key);
    }

    @Override
    public final Object get(final String key) {
        RBucket<Object> temp = getRedisBucket(key);
        return temp.get();
    }

    @Override
    public Object get(String key, Integer expire) {
        RBucket<Object> temp = getRedisBucket(key);
        expire(temp, expire);
        return temp.get();
    }

    @Override
    public Object getFire(String key) {
        RBucket<Object> temp = getRedisBucket(key);
        expire(temp, EXPIRE);
        return temp.get();
    }

    @Override
    public final void set(final String key, final Serializable value) {
        RBucket<Object> temp = getRedisBucket(key);
        temp.set(value);
        expire(temp, EXPIRE);
    }

    @Override
    public final void set(final String key, final Serializable value, int seconds) {
        RBucket<Object> temp = getRedisBucket(key);
        temp.set(value);
        expire(temp, seconds);
    }

    public final void multiSet(final Map<String, Object> temps) {
        redissonClient.getBuckets().set(temps);
    }

    @Override
    public final Boolean exists(final String key) {
        RBucket<Object> temp = getRedisBucket(key);
        return temp.isExists();
    }

    @Override
    public final void del(final String key) {
        redissonClient.getKeys().delete(key);
    }

    @Override
    public final void delAll(final String pattern) {
        redissonClient.getKeys().deleteByPattern(pattern);
    }

    @Override
    public final String type(final String key) {
        RType type = redissonClient.getKeys().getType(key);
        if (type == null) {
            return null;
        }
        return type.getClass().getName();
    }

    /**
     * 在某段时间后失效
     *
     * @return
     */
    private final void expire(final RBucket<Object> bucket, final int seconds) {
        bucket.expire(seconds, TimeUnit.SECONDS);
    }

    /**
     * 在某个时间点失效
     *
     * @param key
     * @param unixTime
     * @return
     *
     */
    @Override
    public final Boolean expireAt(final String key, final long unixTime) {
        return redissonClient.getBucket(key).expireAt(new Date(unixTime));
    }

    @Override
    public final Long ttl(final String key) {
        RBucket<Object> rBucket = getRedisBucket(key);
        return rBucket.remainTimeToLive();
    }

    @Override
    public final Object getSet(final String key, final Serializable value) {
        RBucket<Object> rBucket = getRedisBucket(key);
        return rBucket.getAndSet(value);
    }

    @Override
    public Set<Object> getAll(String pattern) {
        Set<Object> set = ArrayUtils.newHashSet();
        Iterable<String> keys = redissonClient.getKeys().getKeysByPattern(pattern);
        for (String key : keys) {
            set.add(getRedisBucket(key).get());
        }
        return set;
    }

    @Override
    public Set<Object> getAll(String pattern, Integer expire) {
        Set<Object> set = ArrayUtils.newHashSet();
        Iterable<String> keys = redissonClient.getKeys().getKeysByPattern(pattern);
        for (String key : keys) {
            RBucket<Object> bucket = getRedisBucket(key);
            expire(bucket, expire);
            set.add(bucket.get());
        }
        return set;
    }

    @Override
    public Boolean expire(String key, int seconds) {
        RBucket<Object> bucket = getRedisBucket(key);
        expire(bucket, seconds);
        return true;
    }

    @Override
    public void hset(String key, Serializable field, Serializable value) {
        redissonClient.getMap(key).put(field, value);
    }

    @Override
    public Object hget(String key, Serializable field) {
        return redissonClient.getMap(key).get(field);
    }

    @Override
    public void hdel(String key, Serializable field) {
        redissonClient.getMap(key).remove(field);
    }

    public void sadd(String key, Serializable value) {
        redissonClient.getSet(key).add(value);
    }

    public Set<Object> sall(String key) {
        return redissonClient.getSet(key).readAll();
    }

    public boolean sdel(String key, Serializable value) {
        return redissonClient.getSet(key).remove(value);
    }

    @Override
    public boolean lock(String key, String requestId, long seconds) {
        return redissonClient.getBucket(key).trySet(requestId, seconds, TimeUnit.SECONDS);
    }

    @Override
    public boolean unlock(String key, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        return redissonClient.getScript().eval(Mode.READ_WRITE, script, ReturnType.BOOLEAN,
            ArrayUtils.newArrayList(key), requestId);
    }

    @Override
    public boolean setnx(String key, Serializable value) {
        return redissonClient.getBucket(key).trySet(value);
    }

    @Override
    public Long incr(String key) {
        return redissonClient.getAtomicLong(key).incrementAndGet();
    }

    @Override
    public void setrange(String key, long offset, String value) {
    }

    @Override
    public String getrange(String key, long startOffset, long endOffset) {
        return null;
    }
}
