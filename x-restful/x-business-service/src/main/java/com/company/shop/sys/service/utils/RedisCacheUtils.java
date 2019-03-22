package com.company.shop.sys.service.utils;

import com.company.shop.sys.service.support.redis.CacheManager;

/**
 * Created by hexin on 2018/11/30.
 * redis缓存工具类
 */
public class RedisCacheUtils {
    private static CacheManager redisCacheManager;

    public static CacheManager getRedisCacheManager() {
        return redisCacheManager;
    }

    public static void setRedisCacheManager(CacheManager redisCacheManager) {
        RedisCacheUtils.redisCacheManager = redisCacheManager;
    }
}
