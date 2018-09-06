package ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.entity.${entityName?cap_first};

/**   
 * @Title: ${functionName}
 * @Description: ${functionDesc}
 * @author ${functionAuthor}
 * @date ${time}
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("${r'${admin.url.prefix}'}/${moduleName}/${entityName?lower_case}")
@RequiresPathPermission("${moduleName}:${entityName?lower_case}")
public class ${entityName?cap_first}Controller extends BaseCRUDController<${entityName?cap_first}, String> {

}
