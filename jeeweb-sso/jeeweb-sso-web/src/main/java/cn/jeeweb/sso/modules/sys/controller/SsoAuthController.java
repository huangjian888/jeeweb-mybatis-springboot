package cn.jeeweb.sso.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.modules.sys.entity.User;
import cn.jeeweb.sso.SsoConstants;
import cn.jeeweb.sso.entity.SsoUser;
import cn.jeeweb.sso.service.ISsoUserService;
import cn.jeeweb.sso.utils.SsoAuthUtil;
import com.alibaba.fastjson.JSON;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hexin on 2018/9/13.
 */

@Controller
@RequestMapping("/auth")
public class SsoAuthController extends BaseController {

    @Resource
    private ISsoUserService ssoUserService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpServletRequest response, Model model){
        model.addAttribute("showCaptcha", "0");
        return new ModelAndView("modules/sys/login/login");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public void login(HttpServletRequest request, HttpServletResponse response, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isMobileLogin = Boolean.getBoolean(request.getParameter("mobile"));
        String redirectUrl = request.getParameter(SsoConstants.PARAMETER_REDIRECT);
        System.out.println("login redirectUrl:"+redirectUrl);
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password) || TextUtils.isEmpty(redirectUrl)){
            request.setAttribute("shiroLoginFailure", "shiroLoginFailure");
            request.setAttribute("error", "用户名密码等信息不能为空...");
            return;
        }
        AjaxJson ret = ssoUserService.findByUsername(username,password);
        if(ret.getRet() == AjaxJson.RET_FAIL){
            ret = ssoUserService.findByEmail(username,password);
            if(ret.getRet() == AjaxJson.RET_FAIL){
                ret = ssoUserService.findByPhone(username,password);
            }
        }
        if(ret.getRet() == AjaxJson.RET_SUCCESS){
            String token = ssoUserService.generateToken((String) ret.getData());
            System.out.println("login token:"+token);
            request.getSession().setAttribute(SsoConstants.FLAG_SESSION_LOGIN, token);
            try {
                response.sendRedirect(redirectUrl + "?" +SsoConstants.PARAMETER_TOKEN + "=" +token);
            } catch (IOException e) {
                e.printStackTrace();
                request.setAttribute("error", e.getMessage());
            }
        }else{
            request.setAttribute("error", ret.getMsg());
        }
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletRequest response, Model model){
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate();
        }
        model.addAttribute(SsoConstants.PARAMETER_REDIRECT, request.getParameter(SsoConstants.PARAMETER_REDIRECT));
        return new ModelAndView("modules/sys/login/login");
    }


}
