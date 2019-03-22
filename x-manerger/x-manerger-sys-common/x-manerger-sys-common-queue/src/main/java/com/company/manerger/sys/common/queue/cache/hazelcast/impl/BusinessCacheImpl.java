package com.company.manerger.sys.common.queue.cache.hazelcast.impl;

import com.company.manerger.sys.common.queue.cache.hazelcast.IHazelcastCacheBean;
import com.hazelcast.com.eclipsesource.json.JsonObject;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

/**
 * 模拟一个业务缓存类,当业务缓存类超过一定的数量之后，将作为是否需要进入排队的条件
 */
public class BusinessCacheImpl implements IHazelcastCacheBean {
    @Autowired
    public HazelcastInstance hazelcastInstance;
    private String cacheName;

    @Override
    public IHazelcastCacheBean getInstance(String cacheName) {
        this.cacheName = cacheName;
        return this;
    }

    @Override
    public HazelcastInstance getHazelcastInstance() {
        return hazelcastInstance;
    }

    @Override
    public void put(String key, Object value) {
        getHazelcastInstance().getMap(getCacheName()).put(key,value);
    }

    @Override
    public void update(String key, Object value) {
        getHazelcastInstance().getMap(getCacheName()).put(key,value);
    }

    @Override
    public Object delete(String key) {
        return getHazelcastInstance().getMap(getCacheName()).remove(key);
    }

    @Override
    public void clearAll() {
        getHazelcastInstance().getMap(getCacheName()).clear();
    }

    @Override
    public Object getHazelcastCacheObject(String key) {
        return getHazelcastInstance().getMap(getCacheName()).get(key);
    }

    @Override
    public Collection<? extends Object> getAllHazelcastCacheObject() {
        return getHazelcastInstance().getMap(getCacheName()).keySet();
    }

    @Override
    public Object getHazelcastCache() {
        return getHazelcastInstance().getMap(getCacheName());
    }

    @Override
    public String getCacheName() {
        return cacheName;
    }

    @Override
    public JsonObject getLocalMapStats() {
        return getHazelcastInstance().getMap(getCacheName()).getLocalMapStats().toJson();
    }

    @Override
    public Lock getLock(String lockName) {
        return getHazelcastInstance().getLock(lockName);
    }

    @Override
    public long getSize() {
        return getHazelcastInstance().getMap(getCacheName()).size();
    }

    @Override
    public long getAtomicLong(String cacheName) {
        return getHazelcastInstance().getAtomicLong(getCacheName()).incrementAndGet();
    }

    @Override
    public void setAtomicLong(String cacheName, long start) {
        getHazelcastInstance().getAtomicLong(getCacheName()).set(start);
    }
}
