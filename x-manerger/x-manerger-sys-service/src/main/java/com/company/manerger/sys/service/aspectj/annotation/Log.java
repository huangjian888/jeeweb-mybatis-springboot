package com.company.manerger.sys.service.aspectj.annotation;

import com.company.manerger.sys.service.aspectj.enums.LogType;

import java.lang.annotation.*;

/**
 * @description: 自定义操作日志记录注解
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log
{
    /** 标题或模块 */
    String title() default "";

    /** 功能 */
    LogType logType() default LogType.OTHER;

    /** 请求参数 */
    boolean requestParam() default true;

}
