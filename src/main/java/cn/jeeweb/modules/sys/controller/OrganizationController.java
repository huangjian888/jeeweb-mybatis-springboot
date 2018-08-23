package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseTreeController;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.modules.sys.entity.Organization;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${admin.url.prefix}/sys/organization")
@RequiresPathPermission("sys:organization")
public class OrganizationController extends BaseTreeController<Organization, String> {
	
}
