package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseTreeController;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.modules.sys.entity.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${admin.url.prefix}/sys/menu")
@RequiresPathPermission("sys:menu")
public class MenuController extends BaseTreeController<Menu, String> {

}
