package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.JeewebPropertiesUtil;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.Menu;
import cn.jeeweb.modules.sys.entity.Role;
import cn.jeeweb.modules.sys.entity.RoleMenu;
import cn.jeeweb.modules.sys.service.IMenuService;
import cn.jeeweb.modules.sys.service.IRoleMenuService;
import cn.jeeweb.modules.sys.utils.UserUtils;
import com.alibaba.fastjson.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("${admin.url.prefix}/sys/role")
@RequiresPathPermission("sys:role")
public class RoleController extends BaseCRUDController<Role, String> {

	@Resource
	private IMenuService menuService;
	@Resource
	private IRoleMenuService roleMenuService;

	@RequestMapping(value = "authMenu", method = RequestMethod.GET)
	public String authMenu(Role role, Model model, HttpServletRequest request, HttpServletResponse response) {
		EntityWrapper<Menu> entityWrapper = new EntityWrapper<Menu>(Menu.class);
		entityWrapper.orderBy("sort", false);
		List<Menu> menus = menuService.selectTreeList(entityWrapper);
		List<Menu> selectMenus = menuService.findMenuByRoleId(role.getId());
		model.addAttribute("menus", JSONArray.toJSON(menus));
		model.addAttribute("selectMenus", JSONArray.toJSON(selectMenus));
		model.addAttribute("data", role);
		return display("authMenu");
	}

	@RequestMapping(value = "/doAuthMenu", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doAuthMenu(Role role, HttpServletRequest request, HttpServletResponse response) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("权限设置成功");
		try {
			String roleId = role.getId();
			// 删除菜单关联
			roleMenuService.delete(new EntityWrapper<RoleMenu>(RoleMenu.class).eq("roleId", roleId));
			String selectMenu = request.getParameter("selectMenus");
			String[] selectMenus = selectMenu.split(",");
			List<RoleMenu> roleMenuList = new ArrayList<RoleMenu>();
			for (String menuId : selectMenus) {
				RoleMenu roleMenu = new RoleMenu();
				roleMenu.setRoleId(roleId);
				roleMenu.setMenuId(menuId);
				roleMenuList.add(roleMenu);
			}
			roleMenuService.insertOrUpdateBatch(roleMenuList);
			UserUtils.clearCache();
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("权限设置失败");
		}
		return ajaxJson;
	}

	@RequiresMethodPermissions("create")
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String _showCreate(Model model, HttpServletRequest request, HttpServletResponse response) {
		String creteaView = showCreate(newModel(), model, request, response);
		if (!model.containsAttribute("data")) {
			model.addAttribute("data", newModel());
		}
		if (!StringUtils.isEmpty(creteaView)) {
			return creteaView;
		}
		return display("edit");
	}

	@RequiresMethodPermissions("update")
	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String _showUpdate(@PathVariable("id") String id, Model model, HttpServletRequest request, HttpServletResponse response) {
		Role entity = get(id);
		model.addAttribute("data", entity);
		String updateView = showUpdate(newModel(), model, request, response);
		if (!StringUtils.isEmpty(updateView)) {
			return updateView;
		}
		return display("edit");
	}

	@RequiresMethodPermissions("delete")
	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson delete(@PathVariable("id") String id) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		if (JeewebPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许删除！");
			return ajaxJson;
		}
		try {
			commonService.deleteById(id);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequiresMethodPermissions("delete")
	@RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		if (JeewebPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许删除！");
			return ajaxJson;
		}
		try {
			List<String> idList = java.util.Arrays.asList(ids);
			commonService.deleteBatchIds(idList);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}
}
