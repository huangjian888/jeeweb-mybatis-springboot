package com.company.manerger.sys.ui.beetl.tag.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @description: Beetl自定义标签命名
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BeetlTagName {
    /**
     * 标签名称
     */
    String value() default "";
}
