package com.company.generator.manager.interceptor;

import com.company.generator.manager.common.constant.Constants;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 公共拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private String loginUrl="";

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletRequest httpRequest= (HttpServletRequest) request;
        HttpServletResponse httpResponse= (HttpServletResponse) response;
        HttpSession session = httpRequest.getSession();
        //设置当前的URL
        String servletPath=httpRequest.getServletPath();
        if (!loginUrl.equals(servletPath)){
            Boolean loginSucces= (Boolean) session.getAttribute(Constants.LOGIN_SUCCES_KEY);
            if (loginSucces==null||!loginSucces) {
                httpResponse.sendRedirect(loginUrl);
                return false;
            }else{
                //更新session
                session.setAttribute(Constants.LOGIN_SUCCES_KEY, Boolean.TRUE);
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }

}
