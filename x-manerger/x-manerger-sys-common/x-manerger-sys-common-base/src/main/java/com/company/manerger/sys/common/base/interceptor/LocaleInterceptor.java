package com.company.manerger.sys.common.base.interceptor;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * 国际化的拦截器
 */
public class LocaleInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object,
                                Exception exception) throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object,
                           ModelAndView modelAndView) throws Exception {

	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		String langType = "zh";
		if (langType.equals("zh")) {
			Locale locale = new Locale("zh", "CN");
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		} else if (langType.equals("en")) {
			Locale locale = new Locale("en", "US");
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME, locale);
		} else
			request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,
					LocaleContextHolder.getLocale());

		return true;
	}

}
