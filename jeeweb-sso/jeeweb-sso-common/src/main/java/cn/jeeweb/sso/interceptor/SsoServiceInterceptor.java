package cn.jeeweb.sso.interceptor;

import cn.jeeweb.sso.SsoConstants;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by hexin on 2018/9/12.
 */
public class SsoServiceInterceptor  implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object sessionAttribute = session.getAttribute(SsoConstants.FLAG_SESSION_LOGIN);
        if(sessionAttribute != null){
            String redirectUrl = request.getParameter(SsoConstants.PARAMETER_REDIRECT);
            response.sendRedirect(redirectUrl + "?" + SsoConstants.PARAMETER_TOKEN + "=" + sessionAttribute.toString());
            return true;
        }else {
            //转发当前请求
            request.setAttribute(SsoConstants.PARAMETER_REDIRECT, request.getParameter(SsoConstants.PARAMETER_REDIRECT));
            request.getRequestDispatcher("/auth/login").forward(request, response);
            return false;
        }
    }
}
