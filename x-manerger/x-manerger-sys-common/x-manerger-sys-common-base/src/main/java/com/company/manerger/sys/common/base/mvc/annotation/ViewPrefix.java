package com.company.manerger.sys.common.base.mvc.annotation;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewPrefix {
	String value() default "";
}