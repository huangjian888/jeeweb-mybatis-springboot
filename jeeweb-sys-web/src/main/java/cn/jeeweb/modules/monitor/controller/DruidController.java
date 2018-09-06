package cn.jeeweb.modules.monitor.controller;

import cn.jeeweb.core.common.controller.BaseController;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("${admin.url.prefix}/monitor/druid")
@RequiresPathPermission("monitor:druid")
public class DruidController extends BaseController {

	@RequiresMethodPermissions("index")
	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
		return display("index");
	}
}
