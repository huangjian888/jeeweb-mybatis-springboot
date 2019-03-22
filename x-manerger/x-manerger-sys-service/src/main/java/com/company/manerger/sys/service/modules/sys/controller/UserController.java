package com.company.manerger.sys.service.modules.sys.controller;

import cn.afterturn.easypoi.entity.vo.NormalExcelConstants;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;
import cn.afterturn.easypoi.view.PoiBaseView;
import com.company.manerger.sys.common.base.http.DuplicateValid;
import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.http.ValidResponse;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.annotation.PageableDefaults;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.common.utils.DateUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.aspectj.annotation.Log;
import com.company.manerger.sys.service.aspectj.enums.LogType;
import com.company.manerger.sys.service.modules.sys.entity.*;
import com.company.manerger.sys.service.modules.sys.service.*;
import com.company.manerger.sys.service.utils.UserUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
@RequestMapping("${company.admin.url.prefix}/sys/user")
@ViewPrefix("modules/sys/user")
@RequiresPathPermission("sys:user")
@Log(title = "用户管理")
public class UserController extends BaseBeanController<User> {
	@Autowired
	private IUserService userService;

	@Autowired
	private IUserRoleService userRoleService;

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IOrganizationService organizationService;
	@Autowired
	private IUserOrganizationService userOrganizationService;


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
		EntityWrapper<User> entityWrapper = new EntityWrapper<>(entityClass);
		propertyPreFilterable.addQueryProperty("id");
		// 子查询
		String organizationid = request.getParameter("organizationid");
		if (!StringUtils.isEmpty(organizationid)) {
			entityWrapper.eq("uo.organization_id", organizationid);
		}
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageResponse<User> pagejson = new PageResponse<>(userService.list(queryable,entityWrapper));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response,content);
	}

	@GetMapping(value = "add")
	public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("data", new User());
		// 查询所有的角色List
		List<Role> allRoles = roleService.selectList(new EntityWrapper<Role>());
		request.setAttribute("allRoles", allRoles);
		return displayModelAndView ("create");
	}

	@PostMapping("add")
	@Log(logType = LogType.INSERT)
	@RequiresMethodPermissions("add")
	public Response add(User entity, BindingResult result,
						HttpServletRequest request, HttpServletResponse response) {
		// 验证错误
		this.checkError(entity,result);
		userService.insert(entity);
		//保存之后
		afterSave(entity,request);
		return Response.ok("添加成功");
	}

	@GetMapping(value = "{id}/update")
	public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
							   HttpServletResponse response) {
		User user = userService.selectById(id);
		model.addAttribute("data", user);
		// 查询所有的角色List
		List<Role> allRoles = roleService.selectList(new EntityWrapper<Role>());
		request.setAttribute("allRoles", allRoles);
		if (!StringUtils.isEmpty(user.getId())) {
			// 查找关联角色
			List<Role> userRoles = roleService.findListByUserId(user.getId());
			List<String> roleIdList = new ArrayList<>();
			for (Role role: userRoles) {
				roleIdList.add(role.getId());
			}
			request.setAttribute("roleIdList", roleIdList);
			List<Organization> organizations = organizationService.findListByUserId(user.getId());
			String organizationIds = "";
			String organizationNames = "";
			for (Organization organization : organizations) {
				if (!StringUtils.isEmpty(organizationIds)) {
					organizationIds += ",";
					organizationNames += ",";
				}
				String organizationId = organization.getId();
				organizationIds += organizationId;
				organizationNames += organization.getName();

			}
			request.setAttribute("organizationIds", organizationIds);
			request.setAttribute("organizationNames", organizationNames);
		}

		return displayModelAndView ("edit");
	}

	@PostMapping("{id}/update")
	@Log(logType = LogType.UPDATE)
	@RequiresMethodPermissions("update")
	public Response update(User entity, BindingResult result,
						   HttpServletRequest request, HttpServletResponse response) {
		// 验证错误
		this.checkError(entity,result);
		userService.insertOrUpdate(entity);
		//保存之后
		afterSave(entity,request);
		return Response.ok("更新成功");
	}

	@PostMapping("{id}/delete")
	@Log(logType = LogType.DELETE)
	@RequiresMethodPermissions("delete")
	public Response delete(@PathVariable("id") String id) {
		userService.deleteById(id);
		return Response.ok("删除成功");
	}

	@PostMapping("batch/delete")
	@Log(logType = LogType.DELETE)
	@RequiresMethodPermissions("delete")
	public Response batchDelete(@RequestParam("ids") String[] ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		userService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}

	@GetMapping(value = "{id}/changePassword")
	public ModelAndView changePassword(@PathVariable("id") String id, Model model, HttpServletRequest request,
								 HttpServletResponse response) {
		User user = userService.selectById(id);
		model.addAttribute("data", user);
		return displayModelAndView("changePassword");
	}

	@PostMapping(value = "{id}/changePassword")
	@Log(logType = LogType.OTHER,title = "修改成功")
	@RequiresMethodPermissions("change:password")
	public Response changePassword(@PathVariable("id") String id, HttpServletRequest request,
								   HttpServletResponse response) {
		String password = request.getParameter("password");
		userService.changePassword(id, password);
		return Response.ok("密码修改成功");
	}

	@GetMapping(value = "{id}/avatar")
	public ModelAndView avatar(@PathVariable("id") String id, Model model, HttpServletRequest request,
						 HttpServletResponse response) {
		User user = userService.selectById(id);
		model.addAttribute("data", user);
		return displayModelAndView("avatar");
	}

	@PostMapping(value = "{id}/avatar")
	@Log(logType = LogType.OTHER,title = "修改头像")
	@RequiresMethodPermissions("avatar")
	public Response avatar(User user, HttpServletRequest request, HttpServletResponse response) {
		try {
			User oldUser = userService.selectById(user.getId());
			BeanUtils.copyProperties(user,oldUser);
			userService.insertOrUpdate(oldUser);
			String currentUserId = UserUtils.getUser().getId();
			if (currentUserId.equals(user.getId())) {
				UserUtils.clearCache();
			}
		} catch (Exception e) {
			e.printStackTrace();
			Response.error("头像修改失败");
		}
		return Response.ok("头像修改成功");
	}

	public void afterSave(User entity, HttpServletRequest request) {
		// 删除角色关联
		String[] roleIdList = request.getParameterValues("roleIdList");
		if (roleIdList != null && roleIdList.length > 0) {
			userRoleService.delete(new EntityWrapper<UserRole>(UserRole.class).eq("userId", entity.getId()));
			List<UserRole> userRoleList = new ArrayList<UserRole>();
			for (String roleid : roleIdList) {
				UserRole userRole = new UserRole();
				userRole.setUserId(entity.getId());
				userRole.setRoleId(roleid);
				userRoleList.add(userRole);
			}
			userRoleService.insertBatch(userRoleList);
		}

		// 删除部门关联
		String organizationIdListStr = request.getParameter("organizationIds");
		if (!StringUtils.isEmpty(organizationIdListStr)) {
			String[] organizationIdList = organizationIdListStr.split(",");
			if (organizationIdList != null && organizationIdList.length > 0) {
				userOrganizationService.delete(new EntityWrapper<UserOrganization>(UserOrganization.class).eq("userId", entity.getId()));
				List<UserOrganization> userOrganizationList = new ArrayList<UserOrganization>();
				for (String organizationId : organizationIdList) {
					UserOrganization userOrganization = new UserOrganization();
					userOrganization.setUserId(entity.getId());
					userOrganization.setOrganizationId(organizationId);
					userOrganizationList.add(userOrganization);
				}
				userOrganizationService.insertBatch(userOrganizationList);
			}
		}
	}

	@GetMapping(value = "info")
	public ModelAndView info(@RequestParam(required = false) String id, Model model, HttpServletRequest request,
					   HttpServletResponse response) {
		User user = userService.selectById(id);
		model.addAttribute("data", user);
		return displayModelAndView("info");
	}

	@RequestMapping("export")
	@Log(logType = LogType.EXPORT)
	@RequiresMethodPermissions("export")
	public void export(ModelMap map, Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
						  HttpServletResponse response) throws IOException {
		EntityWrapper<User> entityWrapper = new EntityWrapper<User>(entityClass);
		// 子查询
		String organizationid = request.getParameter("organizationid");
		if (!StringUtils.isEmpty(organizationid)) {
			entityWrapper.eq("uo.organization_id", organizationid);
		}
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, User.class);
		List<User> userList = userService.listWithNoPage(queryable,entityWrapper);
		String title = "用户信息";
		ExportParams params = new ExportParams(title, title, ExcelType.XSSF);
		map.put(NormalExcelConstants.DATA_LIST, userList);
		map.put(NormalExcelConstants.CLASS, User.class);
		map.put(NormalExcelConstants.PARAMS, params);
		map.put("fileName",title+ "-" + DateUtils.getDateTime());
		PoiBaseView.render(map, request, response, NormalExcelConstants.EASYPOI_EXCEL_VIEW);
	}

	@PostMapping(value = "validate")
	public ValidResponse validate(DuplicateValid duplicateValid, HttpServletRequest request) {
		ValidResponse validResponse = new ValidResponse();
		Boolean valid = Boolean.FALSE;
		try {
			EntityWrapper<User> entityWrapper = new EntityWrapper<User>(entityClass);
			valid = userService.doValid(duplicateValid,entityWrapper);
			if (valid) {
				validResponse.setStatus("y");
				validResponse.setInfo("验证通过!");
			} else {
				validResponse.setStatus("n");
				if (!StringUtils.isEmpty(duplicateValid.getErrorMsg())) {
					validResponse.setInfo(duplicateValid.getErrorMsg());
				} else {
					validResponse.setInfo("当前信息重复!");
				}
			}
		} catch (Exception e) {
			validResponse.setStatus("n");
			validResponse.setInfo("验证异常，请检查字段是否正确!");
		}
		return validResponse;
	}

	@RequestMapping(value = "queryDynamicDataSource")
	public void queryDynamicDataSource(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String pwd = userService.queryDynamicDataSource();
	}
}