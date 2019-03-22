package com.company.manerger.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.annotation.PageableDefaults;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.aspectj.annotation.Log;
import com.company.manerger.sys.service.aspectj.enums.LogType;
import com.company.manerger.sys.service.modules.sys.entity.Menu;
import com.company.manerger.sys.service.modules.sys.entity.Role;
import com.company.manerger.sys.service.modules.sys.entity.RoleMenu;
import com.company.manerger.sys.service.modules.sys.service.IMenuService;
import com.company.manerger.sys.service.modules.sys.service.IRoleMenuService;
import com.company.manerger.sys.service.modules.sys.service.IRoleService;
import com.company.manerger.sys.service.utils.UserUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @description: 消息模版控制器
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/role")
@ViewPrefix("modules/sys/role")
@RequiresPathPermission("sys:role")
@Log(title = "角色管理")
public class RoleController extends BaseBeanController<Role> {

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IMenuService menuService;
	@Autowired
	private IRoleMenuService roleMenuService;


	@GetMapping
	@RequiresMethodPermissions("view")
	public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
		return displayModelAndView("list");
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
	@PageableDefaults(sort = "id=desc")
	@Log(logType = LogType.SELECT)
	@RequiresMethodPermissions("list")
	public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
						 HttpServletResponse response) throws IOException {
		EntityWrapper<Role> entityWrapper = new EntityWrapper<>(entityClass);
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageResponse<Role> pagejson = new PageResponse<>(roleService.list(queryable,entityWrapper));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response,content);
	}

	@GetMapping(value = "add")
	public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("data", new Role());
		return displayModelAndView ("edit");
	}

	@PostMapping("add")
	@Log(logType = LogType.INSERT)
	@RequiresMethodPermissions("add")
	public Response add(Role entity, BindingResult result,
						HttpServletRequest request, HttpServletResponse response) {
		// 验证错误
		this.checkError(entity,result);
		roleService.insert(entity);
		return Response.ok("添加成功");
	}

	@GetMapping(value = "{id}/update")
	public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
							   HttpServletResponse response) {
		Role entity = roleService.selectById(id);
		model.addAttribute("data", entity);
		return displayModelAndView ("edit");
	}

	@PostMapping("{id}/update")
	@Log(logType = LogType.UPDATE)
	@RequiresMethodPermissions("update")
	public Response update(Role entity, BindingResult result,
						   HttpServletRequest request, HttpServletResponse response) {
		// 验证错误
		this.checkError(entity,result);
		roleService.insertOrUpdate(entity);
		return Response.ok("更新成功");
	}

	@PostMapping("{id}/delete")
	@Log(logType = LogType.DELETE)
	@RequiresMethodPermissions("delete")
	public Response delete(@PathVariable("id") String id) {
		roleService.deleteById(id);
		return Response.ok("删除成功");
	}

	@PostMapping("batch/delete")
	@Log(logType = LogType.DELETE)
	@RequiresMethodPermissions("delete")
	public Response batchDelete(@RequestParam("ids") String[] ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		roleService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}

	@GetMapping(value = "authMenu")
	public ModelAndView authMenu(Role role, Model model, HttpServletRequest request, HttpServletResponse response) {
		EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(Menu.class);
		entityWrapper.orderBy("sort", false);
		entityWrapper.eq("t.enabled","1");
		List<Menu> menus = menuService.selectTreeList(entityWrapper);
		List<Menu> selectMenus = menuService.findMenuByRoleId(role.getId());
		model.addAttribute("menus", JSONArray.toJSON(menus));
		model.addAttribute("selectMenus", JSONArray.toJSON(selectMenus));
		model.addAttribute("data", role);
		return displayModelAndView("authMenu");
	}

	@PostMapping(value = "/doAuthMenu")
	@Log(logType = LogType.OTHER,title = "菜单授权")
	@RequiresMethodPermissions("authMenu")
	public Response doAuthMenu(Role role, HttpServletRequest request, HttpServletResponse response) {
		try {
			String roleId = role.getId();
			String selectIds = request.getParameter("selectIds");
			if (!StringUtils.isEmpty(selectIds)){
				// 删除菜单关联
				roleMenuService.delete(new EntityWrapper<RoleMenu>(RoleMenu.class).eq("roleId", roleId));
				String[] selectMenus = selectIds.split(",");
				List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
				for (String menuId : selectMenus) {
					RoleMenu roleMenu = new RoleMenu();
					roleMenu.setRoleId(roleId);
					roleMenu.setMenuId(menuId);
					roleMenuList.add(roleMenu);
				}
				roleMenuService.insertOrUpdateBatch(roleMenuList);
				UserUtils.clearCache();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error("权限设置失败");
		}
		return Response.ok("权限设置成功");
	}
}