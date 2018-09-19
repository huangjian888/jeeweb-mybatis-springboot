package cn.jeeweb.sso.modules.sys;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by hexin on 2018/9/19.
 */
@Controller
@RequestMapping("/auth")
public class SsoClientController {

    /**
     * sso client test
     * @param request
     * @param response
     * @param model
     */
    @RequestMapping(value = "/login")
    public void login(HttpServletRequest request, HttpServletResponse response, Model model){
        System.out.println("Sso client login");
    }
}
