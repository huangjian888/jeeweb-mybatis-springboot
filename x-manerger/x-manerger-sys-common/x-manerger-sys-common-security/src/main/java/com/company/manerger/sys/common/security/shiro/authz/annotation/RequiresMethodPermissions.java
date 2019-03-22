package com.company.manerger.sys.common.security.shiro.authz.annotation;

import org.apache.shiro.authz.annotation.Logical;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义权限控制器
 *
 */
@Target({ ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiresMethodPermissions {

	String[] value();

	Logical logical() default Logical.AND;

}
