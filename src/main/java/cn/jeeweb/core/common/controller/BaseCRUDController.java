package cn.jeeweb.core.common.controller;

import cn.jeeweb.core.common.data.DuplicateValid;
import cn.jeeweb.core.common.entity.AbstractEntity;
import cn.jeeweb.core.common.service.ICommonService;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.model.PageJson;
import cn.jeeweb.core.model.ValidJson;
import cn.jeeweb.core.query.annotation.PageableDefaults;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.query.utils.QueryableConvertUtils;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.utils.JeewebPropertiesUtil;
import cn.jeeweb.core.utils.ObjectUtils;
import cn.jeeweb.core.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public abstract class BaseCRUDController<Entity extends AbstractEntity<ID>, ID extends Serializable>
		extends BaseBeanController<Entity> {

	protected ICommonService<Entity> commonService;

	/**
	 * 设置基础service
	 *
	 * @param baseService
	 */
	@Autowired
	public void setCommonService(ICommonService<Entity> commonService) {
		this.commonService = commonService;
	}

	public Entity get(ID id) {
		if (!ObjectUtils.isNullOrEmpty(id)) {
			return commonService.selectById(id);
		} else {
			return newModel();
		}
	}

	/**
	 * list 运行之前
	 * 
	 * @param model
	 * @param request
	 * @param response
	 */
	public void preList(Model model, HttpServletRequest request, HttpServletResponse response) {
	}

	@RequiresMethodPermissions("list")
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
		preList(model, request, response);
		System.out.println("display:"+display("list"));
		return display("list");
	}

	/**
	 * 在异步获取数据之前
	 * 
	 * @param model
	 * @param request
	 * @param response
	 */
	public void preAjaxList(Queryable queryable, EntityWrapper<Entity> entityWrapper, HttpServletRequest request, HttpServletResponse response) {


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
//		System.out.println("request:"+JSON.toJSONString(request.getAttributeNames()));
		System.out.println("propertyPreFilterable:"+JSON.toJSONString(propertyPreFilterable));
		EntityWrapper<Entity> entityWrapper = new EntityWrapper<Entity>(entityClass);
		preAjaxList(queryable,entityWrapper, request, response);
		propertyPreFilterable.addQueryProperty("id");
		// 预处理
		QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<Entity> pagejson = new PageJson<Entity>(commonService.list(queryable,entityWrapper));
		String content = JSON.toJSONString(pagejson, filter);
		System.out.println("content:"+content);
		StringUtils.printJson(response, content);
	}

	public String showView(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	/**
	 * 
	 * @title: _view
	 * @description: 查看
	 * @param model
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @return: String
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String _view(Model model, @PathVariable("id") ID id, HttpServletRequest request,
                        HttpServletResponse response) {
		Entity entity = get(id);
		showUpdate(entity, model, request, response);
		model.addAttribute("data", entity);
		String showView = showView(newModel(), model, request, response);
		if (!StringUtils.isEmpty(showView)) {
			return display(showView);
		}
		return display("edit");
	}

	public void preEdit(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {

	}

	public String showCreate(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String _showCreate(Model model, HttpServletRequest request, HttpServletResponse response) {
		preEdit(newModel(), model, request, response);
		String creteaView = showCreate(newModel(), model, request, response);
		if (!model.containsAttribute("data")) {
			model.addAttribute("data", newModel());
		}
		if (!StringUtils.isEmpty(creteaView)) {
			return creteaView;
		}
		return display("edit");
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson create(Model model, @Valid @ModelAttribute("data") Entity entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	public String showUpdate(Entity entity, Model model, HttpServletRequest request, HttpServletResponse response) {
		return "";
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.GET)
	public String _showUpdate(@PathVariable("id") ID id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
		Entity entity = get(id);
		preEdit(entity, model, request, response);
		model.addAttribute("data", entity);
		String updateView = showUpdate(newModel(), model, request, response);
		if (!StringUtils.isEmpty(updateView)) {
			return updateView;
		}
		return display("edit");
	}

	@RequestMapping(value = "{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson update(Model model, @Valid @ModelAttribute("data") Entity entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
		return doSave(entity, request, response, result);
	}

	/**
	 * 保存数据之前
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 */
	public void preSave(Entity entity, HttpServletRequest request, HttpServletResponse response) {
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson doSave(Entity entity, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("保存成功");
		if (hasError(entity, result)) {
			// 错误提示
			String errorMsg = errorMsg(result);
			if (!StringUtils.isEmpty(errorMsg)) {
				ajaxJson.fail(errorMsg);
			} else {
				ajaxJson.fail("保存失败");
			}
			return ajaxJson;
		}
		try {
			preSave(entity, request, response);
			if (ObjectUtils.isNullOrEmpty(entity.getId())) {
				commonService.insert(entity);
			} else {
				commonService.insertOrUpdate(entity);
			}
			afterSave(entity, request, response);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
		}
		return ajaxJson;
	}

	/**
	 * 保存数据之后
	 * 
	 * @param entity
	 * @param request
	 * @param response
	 */
	public void afterSave(Entity entity, HttpServletRequest request, HttpServletResponse response) {
	}

	@RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson delete(@PathVariable("id") ID id) {
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

	@RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) ID[] ids) {
		AjaxJson ajaxJson = new AjaxJson();
		ajaxJson.success("删除成功");
		if (JeewebPropertiesUtil.getProperties().getBoolean("demoMode")) {
			ajaxJson.fail("演示模式，不允许删除！");
			return ajaxJson;
		}
		try {
			List<ID> idList = java.util.Arrays.asList(ids);
			commonService.deleteBatchIds(idList);
		} catch (Exception e) {
			e.printStackTrace();
			ajaxJson.fail("删除失败");
		}
		return ajaxJson;
	}

	@RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
		ValidJson validJson = new ValidJson();
		Boolean valid = Boolean.FALSE;
		try {
			EntityWrapper<Entity> entityWrapper = new EntityWrapper<Entity>(entityClass);
			valid = commonService.doValid(duplicateValid,entityWrapper);
			if (valid) {
				validJson.setStatus("y");
				validJson.setInfo("验证通过!");
			} else {
				validJson.setStatus("n");
				if (!StringUtils.isEmpty(duplicateValid.getErrorMsg())) {
					validJson.setInfo(duplicateValid.getErrorMsg());
				} else {
					validJson.setInfo("当前信息重复!");
				}
			}
		} catch (Exception e) {
			validJson.setStatus("n");
			validJson.setInfo("验证异常，请检查字段是否正确!");
		}
		return validJson;
	}

}
