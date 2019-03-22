package com.company.manerger.sys.common.queue.cache.hazelcast;

import com.hazelcast.com.eclipsesource.json.JsonObject;
import com.hazelcast.core.HazelcastInstance;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

public interface IHazelcastCacheBean {
    IHazelcastCacheBean getInstance(String cacheName);
    HazelcastInstance getHazelcastInstance();
    void put(String key,Object value);
    void update(String key,Object value);
    Object delete(String key);
    void clearAll();
    Object getHazelcastCacheObject(String key);
    Collection<? extends Object> getAllHazelcastCacheObject();
    Object getHazelcastCache();
    String getCacheName();
    JsonObject getLocalMapStats();
    Lock getLock(String lockName);
    long getSize();
    long getAtomicLong(String cacheName);
    void setAtomicLong(String cacheName,long start);
}
