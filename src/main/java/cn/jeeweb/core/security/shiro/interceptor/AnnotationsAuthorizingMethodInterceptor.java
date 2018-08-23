package cn.jeeweb.core.security.shiro.interceptor;

import org.apache.shiro.aop.AnnotationResolver;
import org.apache.shiro.authz.aop.*;
import org.apache.shiro.spring.aop.SpringAnnotationResolver;
import org.apache.shiro.spring.security.interceptor.AopAllianceAnnotationsAuthorizingMethodInterceptor;

import java.util.ArrayList;
import java.util.List;

public class AnnotationsAuthorizingMethodInterceptor extends AopAllianceAnnotationsAuthorizingMethodInterceptor {

	public AnnotationsAuthorizingMethodInterceptor() {
		List<AuthorizingAnnotationMethodInterceptor> interceptors = new ArrayList<AuthorizingAnnotationMethodInterceptor>(
				5);

		AnnotationResolver resolver = new SpringAnnotationResolver();
		// we can re-use the same resolver instance - it does not retain state:
		interceptors.add(new RoleAnnotationMethodInterceptor(resolver));
		interceptors.add(new PermissionAnnotationMethodInterceptor(resolver));
		interceptors.add(new AuthenticatedAnnotationMethodInterceptor(resolver));
		interceptors.add(new UserAnnotationMethodInterceptor(resolver));
		interceptors.add(new GuestAnnotationMethodInterceptor(resolver));

		// 自定义
		interceptors.add(new RoleAllowsAnnotationMethodInterceptor());

		setMethodInterceptors(interceptors);
	}

}