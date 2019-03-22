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
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.common.bean.ResponseError;
import com.company.manerger.sys.service.modules.sys.data.SysDatabaseEnum;
import com.company.manerger.sys.service.modules.sys.entity.DataSource;
import com.company.manerger.sys.service.modules.sys.service.IDataSourceService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * @description: 消息模版控制器
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/datasource")
@ViewPrefix("modules/sys/datasource")
@RequiresPathPermission("sys:datasource")
public class DataSourceController extends BaseBeanController<DataSource> {

	@Autowired
	private IDataSourceService dataSourceService;


	@GetMapping
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
	public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
						 HttpServletResponse response) throws IOException {
		EntityWrapper<DataSource> entityWrapper = new EntityWrapper<>(entityClass);
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageResponse<DataSource> pagejson = new PageResponse<>(dataSourceService.list(queryable,entityWrapper));
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response,content);
	}

	@GetMapping(value = "add")
	public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("data", new DataSource());
		return displayModelAndView ("edit");
	}

	@PostMapping("add")
	public Response add(DataSource entity, BindingResult result,
						HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	@GetMapping(value = "{id}/update")
	public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
							   HttpServletResponse response) {
		DataSource entity = dataSourceService.selectById(id);
		model.addAttribute("data", entity);
		return displayModelAndView ("edit");
	}

	@PostMapping("{id}/update")
	public Response update(DataSource entity, BindingResult result,
						   HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	@PostMapping("/save")
	public Response doSave(DataSource entity, HttpServletRequest request, HttpServletResponse response,
						   BindingResult result) {
		if (hasError(entity, result)) {
			// 错误提示
			String errorMsg = errorMsg(result);
			if (!StringUtils.isEmpty(errorMsg)) {
				return Response.error(ResponseError.NORMAL_ERROR,errorMsg);
			} else {
				return Response.error(ResponseError.NORMAL_ERROR,"保存失败");
			}
		}
		try {
			if (StringUtils.isEmpty(entity.getId())) {
				dataSourceService.insert(entity);
			} else {
				dataSourceService.insertOrUpdate(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.error(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
		}
		return Response.ok("保存成功");
	}

	@PostMapping("{id}/delete")
	public Response delete(@PathVariable("id") String id) {
		dataSourceService.deleteById(id);
		return Response.ok("删除成功");
	}

	@PostMapping("batch/delete")
	public Response batchDelete(@RequestParam("ids") String[] ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		dataSourceService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}

	@RequestMapping(value = "dataSourceParameter")
	@ResponseBody
	public Response dataSourceParameter(@RequestParam String dbType) {
		SysDatabaseEnum sysDatabaseEnum = SysDatabaseEnum.toEnum(dbType);
		if (sysDatabaseEnum != null) {
			Map<String, String> map = new HashMap<String, String>();
			map.put("driverClass", sysDatabaseEnum.getDriverClass());
			map.put("url", sysDatabaseEnum.getUrl());
			map.put("dbtype", sysDatabaseEnum.getDbtype());
			return Response.ok().putObject(map);
		}
		return Response.ok();
	}

}