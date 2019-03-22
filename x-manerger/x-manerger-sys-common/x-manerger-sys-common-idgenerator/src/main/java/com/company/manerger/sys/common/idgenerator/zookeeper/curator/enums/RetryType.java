package com.company.manerger.sys.common.idgenerator.zookeeper.curator.enums;

public enum RetryType {
    EXPONENTIAL_BACKOFF_RETRY("exponentialBackoffRetry"),
    BOUNDED_EXPONENTIAL_BACKOFF_RETRY("boundedExponentialBackoffRetry"),
    RETRY_NTIMES("retryNTimes"),
    RETRY_FOREVER("retryForever"),
    RETRY_UNTIL_ELAPSED("retryUntilElapsed");

    private String value;

    private RetryType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static RetryType format(String value) {
        for (RetryType type : RetryType.values()) {
            if (type.getValue().equalsIgnoreCase(value.trim())) {
                return type;
            }
        }
        throw new IllegalArgumentException("Mismatched type with value=" + value);
    }

    @Override
    public String toString() {
        return value;
    }
}
