package com.company.manerger.sys.common.lock.redis.redisson.handler;

import org.redisson.api.RedissonClient;

public interface RedissonHandler {
    // 关闭Redisson客户端连接
    void close();

    // 获取Redisson客户端是否初始化
    boolean isInitialized();

    // 获取Redisson客户端连接是否正常
    boolean isStarted();

    // 检查Redisson是否是启动状态
    void validateStartedStatus();

    // 检查Redisson是否是关闭状态
    void validateClosedStatus();

    // 获取Redisson客户端
    RedissonClient getRedisson();
}