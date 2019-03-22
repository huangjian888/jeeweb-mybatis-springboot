package com.company.manerger.sys.common.queue.cache.hazelcast.enums;

public enum CacheEnum {
    CACHE_HAZELCAST_QUEUEUP("CacheHazelCastQueueUp"),
    CACHE_HAZELCAST_ONLINE_USER("CacheHazelCastOnLineUser"),
    CACHE_HAZELCAST_BUSINESS("CacheHazelCastBusiness")
    ;

    private String value;
    private CacheEnum(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    @Override
    public String toString() {
        return value;
    }
}
