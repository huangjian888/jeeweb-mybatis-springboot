package com.company.generator.manager.controller;


import com.company.generator.manager.common.constant.Constants;
import com.company.manerger.sys.common.base.mvc.controller.BaseController;
import com.company.manerger.sys.common.utils.MessageUtils;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("${admin.url.prefix}")
public class LoginController extends BaseController {

	/**
	 * 登陆
	 * @param request
	 * @param model
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/login")
	public ModelAndView getLogin(HttpServletRequest request, Model model, HttpSession session) {
		Boolean loginSucces= (Boolean) session.getAttribute(Constants.LOGIN_SUCCES_KEY);
		if (loginSucces!=null&&loginSucces) {
			return new ModelAndView("redirect:/admin");
		}
		if (request.getMethod().equals("POST")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Environment env= SpringContextHolder.getBean(Environment.class);
			String configUser=env.getProperty("generator.admin.username");
			String configPwd=env.getProperty("generator.admin.password");
			if (StringUtils.isEmpty(username)||!username.equals(configUser)
					|| StringUtils.isEmpty(password)||!password.equals(configPwd)){
				model.addAttribute(Constants.ERROR_MSG_KEY, MessageUtils.getMessage("login.valid.error"));
				return new ModelAndView("modules/generator/login/login");
			}else{
				session.setAttribute(Constants.LOGIN_SUCCES_KEY, Boolean.TRUE);
				return new ModelAndView("redirect:/admin");
			}
		}
		return new ModelAndView("modules/generator/login/login");
	}

	/**
	 * 退出
	 * @param session
	 * @return
	 */
	@GetMapping(value ="/logout")
	public ModelAndView logout(HttpSession session) {
		session.setAttribute(Constants.LOGIN_SUCCES_KEY, Boolean.FALSE);
		return new ModelAndView("redirect:/admin/login");
	}
}
