package com.company.manerger.sys.common.lock.redis.redisson.exception;

public class RedissonException extends RuntimeException {
    private static final long serialVersionUID = -1;

    public RedissonException() {
        super();
    }

    public RedissonException(String message) {
        super(message);
    }

    public RedissonException(String message, Throwable cause) {
        super(message, cause);
    }

    public RedissonException(Throwable cause) {
        super(cause);
    }
}