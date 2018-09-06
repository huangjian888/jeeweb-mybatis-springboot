package cn.jeeweb.core.security.shiro.authz.annotation;

import java.lang.annotation.*;

@Documented
@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface RolesAllowed {
	String[] value();
}