package cn.jeeweb.sso.interceptor;

import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.sso.SsoConstants;
import cn.jeeweb.sso.config.SsoProperties;
import cn.jeeweb.sso.service.remote.SsoRemoteService;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hexin on 2018/9/12.
 */
public class SsoClientInterceptor implements HandlerInterceptor {
    private SsoRemoteService ssoRemoteService;
    private SsoProperties ssoProperties;

    public SsoClientInterceptor(SsoRemoteService ssoRemoteService,SsoProperties ssoProperties){
        this.ssoRemoteService = ssoRemoteService;
        this.ssoProperties = ssoProperties;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object sessionAttribute = session.getAttribute(SsoConstants.FLAG_SESSION_LOGIN);
        if(sessionAttribute == null){
            String token = request.getParameter(SsoConstants.PARAMETER_TOKEN);
            if(token != null){
                AjaxJson ret = ssoRemoteService.parseToken(token,request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
                if(ret.getRet() == AjaxJson.RET_SUCCESS){
                    session.setAttribute(SsoConstants.FLAG_SESSION_LOGIN,token);
                    session.setAttribute(SsoConstants.FLAG_LOGIN_USER,ret.getData());
                    return true;
                }else{
                    redirectSsoService(request,response);
                    return false;
                }
            }else {
                redirectSsoService(request,response);
                return false;
            }
        }else {
            //验证token
            String token = sessionAttribute.toString();
            AjaxJson ret = ssoRemoteService.parseToken(token,request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
            if(ret.getRet() == AjaxJson.RET_SUCCESS){
                session.setAttribute(SsoConstants.FLAG_SESSION_LOGIN,token);
                session.setAttribute(SsoConstants.FLAG_LOGIN_USER,ret.getData());
                return true;
            }else{
                redirectSsoService(request,response);
                return false;
            }
        }
    }

    private void redirectSsoService(HttpServletRequest request, HttpServletResponse response){
        String redirectBaseUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getRequestURI();
        String ssoServiceUrl = ssoProperties.getSsoServiceUrl()+"?"+SsoConstants.PARAMETER_REDIRECT +"="+ redirectBaseUrl;
        try {
            response.sendRedirect(ssoServiceUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
