package cn.jeeweb.modules.codegen.controller;

import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.modules.codegen.entity.Column;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("${admin.url.prefix}/codegen/column")
@RequiresPathPermission("codegen:column")
public class ColumnController extends BaseCRUDController<Column, String> {
 
}
