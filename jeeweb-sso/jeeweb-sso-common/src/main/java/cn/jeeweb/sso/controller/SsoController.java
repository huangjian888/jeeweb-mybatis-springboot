package cn.jeeweb.sso.controller;

import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.utils.SpringContextHolder;
import cn.jeeweb.sso.SsoConstants;
import cn.jeeweb.sso.service.ISsoUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hexin on 2018/9/17.
 */

@Controller
@RequestMapping("/auth")
public class SsoController {

    @RequestMapping("/parseToken")
    @ResponseBody
    public AjaxJson parseToken(HttpServletRequest request, HttpServletResponse response){
        ISsoUserService ssoUserService = SpringContextHolder.getBean(ISsoUserService.class);
        String token = request.getParameter(SsoConstants.PARAMETER_TOKEN);
        String clientUrl = request.getParameter(SsoConstants.PARAMETER_CLIENT_URL);
        AjaxJson ajaxJson = ssoUserService.parseToken(token,clientUrl);
        return ajaxJson;
    }

    @RequestMapping("/clearToken")
    @ResponseBody
    public AjaxJson clearToken(HttpServletRequest request, HttpServletResponse response){
        AjaxJson ajaxJson = new AjaxJson();
        return ajaxJson;
    }
}
