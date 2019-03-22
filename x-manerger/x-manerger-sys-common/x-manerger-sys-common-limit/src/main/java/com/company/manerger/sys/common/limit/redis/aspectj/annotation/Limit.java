package com.company.manerger.sys.common.limit.redis.aspectj.annotation;

import com.company.manerger.sys.common.limit.redis.aspectj.enums.LimitType;

import java.lang.annotation.*;

/**
 * 限流
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Limit {
    /**
     * 资源的名字
     * @return String
     */
    String name() default "";

    /**
     * 资源的key
     * @return String
     */
    String key() default "";

    /**
     * 资源key的前缀,拼接key
     * @return String
     */
    String prefix() default "";

    /**
     * 给定的时间段
     * 单位秒
     * @return int
     */
    int limitPeriod();

    /**
     * 最多的访问限制次数
     * @return int
     */
    int limitCount();

    /**
     * 类型
     * @return LimitType
     */
    LimitType limitType() default LimitType.CUSTOMER;
}
