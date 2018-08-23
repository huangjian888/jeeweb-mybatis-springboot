package cn.jeeweb.core.security.shiro.interceptor;

import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import org.apache.http.util.TextUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.subject.Subject;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限拦截器
 * 
 * @author auth_team
 *
 */
public class PermissionInterceptorAdapter extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			RequiresMethodPermissions requiresMethodPermissions = handlerMethod.getMethodAnnotation(RequiresMethodPermissions.class);
			if (requiresMethodPermissions != null) {
				if(!TextUtils.isEmpty(request.getParameter("callbackType")) && request.getParameter("callbackType").equalsIgnoreCase("json")){
					RequiresPathPermission requiresPathPermission = AnnotationUtils.findAnnotation(handlerMethod.getBean().getClass(), RequiresPathPermission.class);
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
						boolean  hasPermission = getSubject().isPermitted(permission);
						if(!hasPermission){
							onAccessDenied(request,response);
							return false;
						}
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
						boolean hasPermissionAll = getSubject().isPermittedAll(newPerms);
						if(!hasPermissionAll){
							onAccessDenied(request,response);
							return false;
						}
						return true;
					}
					if (Logical.OR.equals(requiresMethodPermissions.logical())) {
						boolean hasAtLeastOnePermission = false;
						for (String permission : perms) {
							if (!StringUtils.isEmpty(basePermission)) {
								permission = basePermission + ":" + permission;
							}
							if (getSubject().isPermitted(permission)){
								hasAtLeastOnePermission = true;
							}
						}
						if (!hasAtLeastOnePermission) {
							onAccessDenied(request,response);
							return false;
						}
						return true;
					}
					return true;
				}else{
					RequiresPathPermission requiresPathPermission = AnnotationUtils.findAnnotation(handlerMethod.getBean().getClass(), RequiresPathPermission.class);
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
						System.out.println("------------permission:"+permission);
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
		}
		return true;
	}

	private void onAccessDenied(HttpServletRequest request, HttpServletResponse response)throws IOException {
		if(!TextUtils.isEmpty(request.getParameter("callbackType")) && request.getParameter("callbackType").equalsIgnoreCase("json")){
			AjaxJson ajaxJson = new AjaxJson();
			ajaxJson.fail("没有相应的操作权限！请联系管理员分配权限...");
			response.setCharacterEncoding("UTF-8");
			response.setHeader("Content-type", "application/json;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println(JSON.toJSONString(ajaxJson));
			out.flush();
			out.close();
		}
	}

	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}

}