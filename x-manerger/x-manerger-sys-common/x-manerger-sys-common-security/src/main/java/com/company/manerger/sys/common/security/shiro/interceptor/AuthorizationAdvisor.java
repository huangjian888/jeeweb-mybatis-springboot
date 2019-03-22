package com.company.manerger.sys.common.security.shiro.interceptor;

import com.company.manerger.sys.common.base.mvc.controller.BaseController;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RolesAllowed;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 权限注解处理器
 *
 */
@SuppressWarnings({ "unchecked", "serial" })
public class AuthorizationAdvisor extends AuthorizationAttributeSourceAdvisor {

	// 权限注解
	private static final Class<? extends Annotation>[] AUTHZ_ANNOTATION_CLASSES = new Class[] { RolesAllowed.class,
			RequiresPermissions.class, RequiresRoles.class, RequiresUser.class, RequiresGuest.class,
			RequiresAuthentication.class };

	// web注解
	private static final Class<? extends Annotation>[] WEB_ANNOTATION_CLASSES = new Class[] { RequestMapping.class };

	/**
	 * Create a new AuthorizationAttributeSourceAdvisor.
	 */
	public AuthorizationAdvisor() {
		setAdvice(new AnnotationsAuthorizingMethodInterceptor());
	}

	/**
	 * 匹配带有注解的方法
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public boolean matches(Method method, Class targetClass) {
		boolean flag = super.matches(method, targetClass);

		// 如果方法上没有权限注解，尝试获取类上的默认权限注解
		if (!flag && isAuthzAnnotationPresent(targetClass) && isWebAnnotationPresent(method)) {
			flag = true;
		}

		return flag;
	}

	/**
	 * 查看BaseController的子类是否有权限注解
	 * 
	 * @param clazz
	 * @return
	 */
	private boolean isAuthzAnnotationPresent(Class<BaseController> clazz) {
		for (Class<? extends Annotation> annClass : AUTHZ_ANNOTATION_CLASSES) {
			Annotation a = AnnotationUtils.findAnnotation(clazz, annClass);
			if (a != null) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 查看方法是否有web注解，是否是一个rest接口
	 * 
	 * @param method
	 * @return
	 */
	private boolean isWebAnnotationPresent(Method method) {
		for (Class<? extends Annotation> annClass : WEB_ANNOTATION_CLASSES) {
			Annotation a = AnnotationUtils.findAnnotation(method, annClass);
			if (a != null) {
				return true;
			}
		}
		return false;
	}

}