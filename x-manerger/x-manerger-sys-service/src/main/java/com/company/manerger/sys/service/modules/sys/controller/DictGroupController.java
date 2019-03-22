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
import com.company.manerger.sys.service.modules.sys.entity.DictGroup;
import com.company.manerger.sys.service.modules.sys.service.IDictGroupService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.company.manerger.sys.ui.beetl.tag.dict.DictUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/dict/group")
@ViewPrefix("modules/sys/dict/group")
@RequiresPathPermission("sys:dict")
@Log(title = "字典分组")
public class DictGroupController extends BaseBeanController<DictGroup> {

	@Autowired
	private IDictGroupService dictGroupService;


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
	@RequiresMethodPermissions("group:list")
	public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
						 HttpServletResponse response) throws IOException {
		EntityWrapper<DictGroup> entityWrapper = new EntityWrapper<>(entityClass);
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageResponse<DictGroup> pagejson = new PageResponse<>(dictGroupService.list(queryable,entityWrapper));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response,content);
	}

	@GetMapping(value = "add")
	public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("data", new DictGroup());
		return displayModelAndView ("edit");
	}

	@PostMapping("add")
	@Log(logType = LogType.INSERT)
	@RequiresMethodPermissions("group:create")
	public Response add(DictGroup entity, BindingResult result,
						HttpServletRequest request, HttpServletResponse response) {
		// 验证错误
		this.checkError(entity,result);
		dictGroupService.insert(entity);
		return Response.ok("添加成功");
	}

	@GetMapping(value = "{id}/update")
	public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
							   HttpServletResponse response) {
		DictGroup entity = dictGroupService.selectById(id);
		model.addAttribute("data", entity);
		return displayModelAndView ("edit");
	}

	@PostMapping("{id}/update")
	@Log(logType = LogType.UPDATE)
	@RequiresMethodPermissions("group:update")
	public Response update(DictGroup entity, BindingResult result,
						   HttpServletRequest request, HttpServletResponse response) {
		// 验证错误
		this.checkError(entity,result);
		dictGroupService.insertOrUpdate(entity);
		return Response.ok("更新成功");
	}

	@PostMapping("{id}/delete")
	@RequiresMethodPermissions("group:delete")
	public Response delete(@PathVariable("id") String id) {
		dictGroupService.deleteById(id);
		return Response.ok("删除成功");
	}

	@RequestMapping(value = "/forceRefresh", method = RequestMethod.POST)
	@ResponseBody
	@Log(logType = LogType.OTHER,title = "字典刷新")
	@RequiresMethodPermissions("force:refresh")
	public Response forceRefresh(HttpServletRequest request, HttpServletResponse response) {
		try {
			DictUtils.clear();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error("字典刷新失败" + e.getMessage());
		}
		return Response.ok("字典刷新成功");
	}

}