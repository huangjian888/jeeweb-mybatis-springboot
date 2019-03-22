package com.company.manerger.sys.common.lock.redis.impl;

import com.company.manerger.sys.common.lock.LockExecutor;
import com.company.manerger.sys.common.lock.enums.LockType;
import com.company.manerger.sys.common.lock.redis.redisson.exception.RedissonException;
import com.company.manerger.sys.common.lock.redis.redisson.handler.RedissonHandler;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class RedisLockExecutorImpl implements LockExecutor<RLock> {
    @Autowired
    private RedissonHandler redissonHandler;
    private volatile Map<String, RLock> lockMap = new ConcurrentHashMap<String, RLock>();
    private volatile Map<String, RReadWriteLock> readWriteLockMap = new ConcurrentHashMap<String, RReadWriteLock>();
    private boolean lockCached = true;

    @Override
    public RLock tryLock(LockType lockType, String name, String key, String prefix, long leaseTime, long waitTime, boolean async, boolean fair) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new RedissonException("name is null or empty");
        }
        if(StringUtils.isEmpty(key)){
            throw new RedissonException("key is null or empty");
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return tryLock(lockType,compositeKey,leaseTime,waitTime,async,fair);
    }

    @Override
    public RLock tryLock(LockType lockType, String compositeKey, long leaseTime, long waitTime, boolean async, boolean fair) throws Exception {
        if (StringUtils.isEmpty(compositeKey)) {
            throw new RedissonException("compositeKey is null or empty");
        }
        if (lockType != LockType.LOCK && fair) {
            throw new RedissonException("fair lock of Redis isn't support for " + lockType);
        }
        redissonHandler.validateStartedStatus();
        if(async) return invokeLockAsync(lockType, compositeKey, leaseTime, waitTime, fair);
        else return invokeLock(lockType, compositeKey, leaseTime, waitTime, fair);
    }

    @Override
    public void unlock(RLock rLock) throws Exception {
        if (redissonHandler.isStarted()) {
            if (rLock != null && rLock.isLocked()) {
                rLock.unlock();
            }
        }
    }

    private RLock getCacheLock(LockType lockType,String key,boolean fair){
        String newKey = lockType.toString() + "-" + key + "-" + "fair[" + fair +"]";
        RLock lock = lockMap.get(newKey);
        if (lock == null) {
            RLock newLock = getNewLock(lockType, key, fair);
            lock = lockMap.putIfAbsent(newKey, newLock);
            if (lock == null) {
                lock = newLock;
            }
        }
        return lock;
    }

    private RLock getNewLock(LockType lockType, String key, boolean fair) {
        RedissonClient redisson = redissonHandler.getRedisson();
        switch (lockType){
            case LOCK:
                if(fair) return redisson.getFairLock(key);
                else return redisson.getLock(key);
            case READ_LOCK:
                return getCachedReadWriteLock(key,fair).readLock();
            case WRITE_LOCK:
                return getCachedReadWriteLock(key,fair).writeLock();
        }
        throw new RedissonException("Invalid Redis lock type "+lockType);
    }

    private RReadWriteLock getCachedReadWriteLock(String key, boolean fair) {
        String newKey = key + "-" + "fair[" + fair + "]";
        RReadWriteLock readWriteLock = readWriteLockMap.get(newKey);
        if (readWriteLock == null) {
            RedissonClient redisson = redissonHandler.getRedisson();
            RReadWriteLock newReadWriteLock = redisson.getReadWriteLock(key);
            readWriteLock = readWriteLockMap.putIfAbsent(newKey, newReadWriteLock);
            if (readWriteLock == null) {
                readWriteLock = newReadWriteLock;
            }
        }
        return readWriteLock;
    }

    private RLock getLock(LockType lockType, String key, boolean fair) {
        if (lockCached) {
            return getCacheLock(lockType, key, fair);
        } else {
            return getNewLock(lockType, key, fair);
        }
    }

    private RLock invokeLock(LockType lockType, String key, long leaseTime, long waitTime, boolean fair) throws Exception {
        RLock lock = getLock(lockType, key, fair);
        boolean acquired = lock.tryLock(waitTime, leaseTime, TimeUnit.MILLISECONDS);
        return acquired ? lock : null;
    }

    private RLock invokeLockAsync(LockType lockType, String key, long leaseTime, long waitTime, boolean fair) throws Exception {
        RLock lock = getLock(lockType, key, fair);
        boolean acquired = lock.tryLockAsync(waitTime, leaseTime, TimeUnit.MILLISECONDS).get();
        return acquired ? lock : null;
    }

    @PreDestroy
    public void destory(){
        try{
            redissonHandler.close();
        }catch(Exception e){
            throw new RedissonException("Close Redisson failed",e);
        }
    }
}
