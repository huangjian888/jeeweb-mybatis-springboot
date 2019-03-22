package com.company.manerger.sys.common.base.filter.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 另外，有些情况不想显示过滤后内容的话，可以用StringEscapeUtils.unescapeHtml4()这个方法，
 * 把StringEscapeUtils.escapeHtml4()转义之后的字符恢复原样。
 *
 */
public class XssFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		chain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) request), response);
	}

	@Override
	public void destroy() {
	}
}
