package com.company.generator.manager.filter;

import com.company.generator.manager.common.constant.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 另外，有些情况不想显示过滤后内容的话，可以用StringEscapeUtils.unescapeHtml()这个方法，
 * 把StringEscapeUtils.escapeHtml()转义之后的字符恢复原样。
 */
public class LoginFilter implements Filter {
	//登陆URL
	private String loginUrl="";


	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest= (HttpServletRequest) request;
		HttpServletResponse httpResponse= (HttpServletResponse) response;
		HttpSession session = httpRequest.getSession();
		//设置当前的URL
		String servletPath=httpRequest.getServletPath();
		if (!loginUrl.equals(servletPath)){
			Boolean loginSucces= (Boolean) session.getAttribute(Constants.LOGIN_SUCCES_KEY);
			if (loginSucces==null||!loginSucces) {
				httpResponse.sendRedirect(loginUrl);
			}
		}else{
			//更新session
			session.setAttribute(Constants.LOGIN_SUCCES_KEY, Boolean.TRUE);
		}
		return;
	}

	@Override
	public void destroy() {
	}
}
