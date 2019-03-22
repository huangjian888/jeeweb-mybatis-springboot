package com.company.manerger.sys.common.lock;

import com.company.manerger.sys.common.lock.enums.LockType;

public interface LockExecutor<T> {
    /**
     * 尝试获取锁，如果获取到锁，则返回锁对象，如果未获取到锁，则返回空
     * @param lockType 锁的类型，包括LOCK(普通锁)，WRITE_LOCK(写锁)，READ_LOCK(读锁)
     * @param name 锁的名字
     * @param key 锁的Key
     * @param prefix 锁的Key 的前缀
     * @param leaseTime 持锁时间，持锁超过此时间则自动丢弃锁(单位毫秒)
     * @param waitTime 没有获取到锁时，等待时间(单位毫秒)
     * @param async 是否采用锁的异步执行方式
     * @param fair 是否采用公平锁
     * @return T
     * @throws Exception 异常
     */
    T tryLock(LockType lockType, String name, String key, String prefix, long leaseTime, long waitTime, boolean async, boolean fair) throws Exception;

    T tryLock(LockType lockType, String compositeKey, long leaseTime, long waitTime, boolean async, boolean fair) throws Exception;

    void unlock(T t) throws Exception;
}