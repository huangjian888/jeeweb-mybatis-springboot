package com.company.manerger.sys.common.lock.zookeeper.impl;

import com.company.manerger.sys.common.lock.LockExecutor;
import com.company.manerger.sys.common.lock.enums.LockType;
import com.company.manerger.sys.common.lock.zookeeper.curator.exception.CuratorException;
import com.company.manerger.sys.common.lock.zookeeper.curator.handler.CuratorHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.framework.recipes.locks.InterProcessReadWriteLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PreDestroy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class ZookeeperLockExecutorImpl implements LockExecutor<InterProcessMutex> {
    @Autowired
    private CuratorHandler curatorHandler;
    private volatile Map<String, InterProcessMutex> lockMap = new ConcurrentHashMap<String, InterProcessMutex>();
    private volatile Map<String, InterProcessReadWriteLock> readWriteLockMap = new ConcurrentHashMap<String, InterProcessReadWriteLock>();
    private boolean lockCached = true;
    @Value("${lock.prefix:lockPrefix}")
    private String prefix;

    @Override
    public InterProcessMutex tryLock(LockType lockType, String name, String key, String prefix, long leaseTime, long waitTime, boolean async, boolean fair) throws Exception {
        if (StringUtils.isEmpty(name)) {
            throw new CuratorException("Name is null or empty");
        }
        if (StringUtils.isEmpty(key)) {
            throw new CuratorException("Key is null or empty");
        }
        String compositeKey = prefix + "_" + name + "_" + key;
        return tryLock(lockType, compositeKey, leaseTime, waitTime, async, fair);
    }

    @Override
    public InterProcessMutex tryLock(LockType lockType, String compositeKey, long leaseTime, long waitTime, boolean async, boolean fair) throws Exception {
        if (StringUtils.isEmpty(compositeKey)) {
            throw new CuratorException("Composite key is null or empty");
        }
        if (fair) {
            throw new CuratorException("Fair lock of Zookeeper isn't support for " + lockType);
        }
        if (async) {
            throw new CuratorException("Async lock of Zookeeper isn't support for " + lockType);
        }
        curatorHandler.validateStartedStatus();
        InterProcessMutex interProcessMutex = getLock(lockType, compositeKey,prefix);
        boolean acquired = interProcessMutex.acquire(waitTime, TimeUnit.MILLISECONDS);
        return acquired ? interProcessMutex : null;
    }

    @Override
    public void unlock(InterProcessMutex interProcessMutex) throws Exception {
        if (curatorHandler.isStarted()) {
            if (interProcessMutex != null && interProcessMutex.isAcquiredInThisProcess()) {
                interProcessMutex.release();
            }
        }
    }

    private InterProcessMutex getLock(LockType lockType, String key,String prefix) {
        if (lockCached) {
            return getCachedLock(lockType, key,prefix);
        } else {
            return getNewLock(lockType, key,prefix);
        }
    }

    private InterProcessMutex getCachedLock(LockType lockType, String key,String prefix) {
        String path = curatorHandler.getPath(prefix, key);
        String newKey = path + "-" + lockType;
        InterProcessMutex lock = lockMap.get(newKey);
        if (lock == null) {
            InterProcessMutex newLock = getNewLock(lockType, key,prefix);
            lock = lockMap.putIfAbsent(newKey, newLock);
            if (lock == null) {
                lock = newLock;
            }
        }
        return lock;
    }

    private InterProcessMutex getNewLock(LockType lockType, String key,String prefix) {
        String path = curatorHandler.getPath(prefix, key);
        CuratorFramework curator = curatorHandler.getCurator();
        switch (lockType) {
            case LOCK:
                return new InterProcessMutex(curator, path);
            case READ_LOCK:
                return getCachedReadWriteLock(lockType, key,prefix).readLock();
            case WRITE_LOCK:
                return getCachedReadWriteLock(lockType, key,prefix).writeLock();
        }
        throw new CuratorException("Invalid Zookeeper lock type for " + lockType);
    }

    private InterProcessReadWriteLock getCachedReadWriteLock(LockType lockType, String key,String prefix) {
        String path = curatorHandler.getPath(prefix, key);
        String newKey = path;
        InterProcessReadWriteLock readWriteLock = readWriteLockMap.get(newKey);
        if (readWriteLock == null) {
            CuratorFramework curator = curatorHandler.getCurator();
            InterProcessReadWriteLock newReadWriteLock = new InterProcessReadWriteLock(curator, path);
            readWriteLock = readWriteLockMap.putIfAbsent(newKey, newReadWriteLock);
            if (readWriteLock == null) {
                readWriteLock = newReadWriteLock;
            }
        }
        return readWriteLock;
    }

    @PreDestroy
    public void destory(){
        try{
            curatorHandler.close();
        }catch(Exception e){
            throw new CuratorException("Close Curator failed",e);
        }
    }
}
