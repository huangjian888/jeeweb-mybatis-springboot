package cn.jeeweb.sso.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.sso.service.ISsoUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hexin on 2018/9/13.
 */

@Controller
@RequestMapping("/auth")
public class SsoAuthController extends BaseController {

    @Resource
    private ISsoUserService ssoUserService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView login(){
        return new ModelAndView("modules/sys/login/login");
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, HttpServletRequest response, Model model){
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        return null;
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletRequest response, Model model){

        return new ModelAndView("modules/sys/login/login");
    }
}
