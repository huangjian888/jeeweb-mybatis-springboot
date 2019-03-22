package com.company.manerger.sys.common.security.shiro.interceptor;

import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.common.utils.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.subject.Subject;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 权限拦截器
 *
 */
public class PermissionInterceptorAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			RequiresMethodPermissions requiresMethodPermissions = handlerMethod
					.getMethodAnnotation(RequiresMethodPermissions.class);
			if (requiresMethodPermissions != null) {
				RequiresPathPermission requiresPathPermission = AnnotationUtils
						.findAnnotation(handlerMethod.getBean().getClass(), RequiresPathPermission.class);
				String basePermission = "";
				if (requiresPathPermission != null) {
					basePermission = requiresPathPermission.value();
				}
				String[] perms = requiresMethodPermissions.value();

				if (perms.length == 1) {
					String permission = perms[0];
					if (!StringUtils.isEmpty(basePermission)) {
						permission = basePermission + ":" + perms[0];
					}
					getSubject().checkPermission(permission);
					return true;
				}
				if (Logical.AND.equals(requiresMethodPermissions.logical())) {
					String[] newPerms = new String[perms.length];
					for (int i = 0; i < perms.length; i++) {
						String perm = perms[i];
						if (!StringUtils.isEmpty(basePermission)) {
							perm = basePermission + ":" + perm;
						}
						newPerms[i] = perm;
					}
					getSubject().checkPermissions(newPerms);
					return true;
				}
				if (Logical.OR.equals(requiresMethodPermissions.logical())) {
					boolean hasAtLeastOnePermission = false;
					for (String permission : perms) {
						if (!StringUtils.isEmpty(basePermission)) {
							permission = basePermission + ":" + permission;
						}
						if (getSubject().isPermitted(permission))
							hasAtLeastOnePermission = true;
					}
					if (!hasAtLeastOnePermission) {
						String permission = perms[0];
						if (!StringUtils.isEmpty(basePermission)) {
							permission = basePermission + ":" + permission;
						}
						getSubject().checkPermission(permission);
					}
					return true;
				}
			}
		}
		return true;

	}

	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}

}