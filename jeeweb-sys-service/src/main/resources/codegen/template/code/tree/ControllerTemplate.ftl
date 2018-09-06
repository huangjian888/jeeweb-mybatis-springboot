package ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.controller;

import cn.jeeweb.core.common.entity.tree.BootstrapTreeHelper;
import cn.jeeweb.core.common.entity.tree.BootstrapTreeNode;
import cn.jeeweb.core.common.entity.tree.TreeSortUtil;
import cn.jeeweb.core.common.data.DuplicateValid;
import cn.jeeweb.core.model.AjaxJson;
import cn.jeeweb.core.model.PageJson;
import cn.jeeweb.core.model.ValidJson;
import cn.jeeweb.core.query.annotation.PageableDefaults;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.QueryPropertyPreFilter;
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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import cn.jeeweb.core.common.controller.BaseBeanController;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.entity.${entityName?cap_first};
import ${packageName}<#if moduleName?exists><#if moduleName!=''>.${moduleName}</#if></#if>.service.I${entityName?cap_first}Service;

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
public class ${entityName?cap_first}Controller extends BaseBeanController<${entityName?cap_first}> {

    @Autowired
    protected I${entityName?cap_first}Service ${entityName?uncap_first}Service;

    public ${entityName?cap_first} get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return ${entityName?uncap_first}Service.selectById(id);
        } else {
            return newModel();
        }
    }

    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        return display("list");
    }

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResponseBody
	@RequestMapping(value = "treeData")
	public void treeData(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") String nodeid,
			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			HttpServletRequest request, HttpServletResponse response) throws IOException {
		EntityWrapper<${entityName?cap_first}> entityWrapper = new EntityWrapper<${entityName?cap_first}>(entityClass);
		entityWrapper.setTableAlias("t.");
		List<${entityName?cap_first}> treeNodeList = null;
		if (!async) { // 非异步 查自己和子子孙孙
			treeNodeList = ${entityName?uncap_first}Service.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
		} else { // 异步模式只查自己
			// queryable.addCondition("parentId", nodeid);
			if (ObjectUtils.isNullOrEmpty(nodeid)) {
				// 判断的应该是多个OR条件
				entityWrapper.isNull("parentId");
			} else {
				entityWrapper.eq("parentId", nodeid);
			}
			treeNodeList = ${entityName?uncap_first}Service.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sync(treeNodeList);
		}
		PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
		propertyPreFilterable.addQueryProperty("id", "name", "expanded", "hasChildren", "leaf", "loaded", "level",
				"parentId");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<${entityName?cap_first}> pagejson = new PageJson<${entityName?cap_first}>(treeNodeList);
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "ajaxTreeList", method ={ RequestMethod.GET, RequestMethod.POST })
	private void ajaxTreeList(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") String nodeid,
			@RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
			HttpServletRequest request, HttpServletResponse response, PropertyPreFilterable propertyPreFilterable)
			throws IOException {
		EntityWrapper<${entityName?cap_first}> entityWrapper = new EntityWrapper<${entityName?cap_first}>(entityClass);
		entityWrapper.setTableAlias("t.");
		List<${entityName?cap_first}> treeNodeList = null;
		if (!async) { // 非异步 查自己和子子孙孙
			treeNodeList = ${entityName?uncap_first}Service.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
		} else { // 异步模式只查自己
			// queryable.addCondition("parentId", nodeid);
			if (ObjectUtils.isNullOrEmpty(nodeid)) {
				// 判断的应该是多个OR条件
				entityWrapper.isNull("parentId");
			} else {
				entityWrapper.eq("parentId", nodeid);
			}
			treeNodeList = ${entityName?uncap_first}Service.selectTreeList(queryable, entityWrapper);
			TreeSortUtil.create().sync(treeNodeList);
		}
		propertyPreFilterable.addQueryProperty("id", "expanded", "hasChildren", "leaf", "loaded", "level", "parentId");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		PageJson<${entityName?cap_first}> pagejson = new PageJson<${entityName?cap_first}>(treeNodeList);
		String content = JSON.toJSONString(pagejson, filter);
		StringUtils.printJson(response, content);
	}

	/**
	 * 根据页码和每页记录数，以及查询条件动态加载数据
	 * 
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "bootstrapTreeData")
	private void bootstrapTreeData(Queryable queryable,
			@RequestParam(value = "nodeid", required = false, defaultValue = "") String nodeid, HttpServletRequest request,
			HttpServletResponse response, PropertyPreFilterable propertyPreFilterable) throws IOException {
		EntityWrapper<${entityName?cap_first}> entityWrapper = new EntityWrapper<${entityName?cap_first}>(entityClass);
		entityWrapper.setTableAlias("t.");
		List<${entityName?cap_first}> treeNodeList = ${entityName?uncap_first}Service.selectTreeList(queryable, entityWrapper);
		List<BootstrapTreeNode> bootstrapTreeNodes = BootstrapTreeHelper.create().sort(treeNodeList);
		propertyPreFilterable.addQueryProperty("text", "href", "tags", "nodes");
		SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
		String content = JSON.toJSONString(bootstrapTreeNodes, filter);
		StringUtils.printJson(response, content);
	}

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String create(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", newModel());
        }
        return display("edit");
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson create(Model model, @Valid @ModelAttribute("data") ${entityName?cap_first} ${entityName?uncap_first}, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(${entityName?uncap_first}, request, response, result);
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.GET)
    public String update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                              HttpServletResponse response) {
        ${entityName?cap_first} ${entityName?uncap_first} = get(id);
        model.addAttribute("data", ${entityName?uncap_first});
        return display("edit");
    }

    @RequestMapping(value = "{id}/update", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson update(Model model, @Valid @ModelAttribute("data") ${entityName?cap_first} ${entityName?uncap_first}, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(${entityName?uncap_first}, request, response, result);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson doSave(${entityName?cap_first} ${entityName?uncap_first}, HttpServletRequest request, HttpServletResponse response,
                           BindingResult result) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("保存成功");
        if (hasError(${entityName?uncap_first}, result)) {
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
            if (StringUtils.isEmpty(${entityName?uncap_first}.getId())) {
                ${entityName?uncap_first}Service.insert(${entityName?uncap_first});
            } else {
                ${entityName?uncap_first}Service.insertOrUpdate(${entityName?uncap_first});
            }
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("保存失败!<br />原因:" + e.getMessage());
        }
        return ajaxJson;
    }

    @RequestMapping(value = "{id}/delete", method = RequestMethod.POST)
    @ResponseBody
    public AjaxJson delete(@PathVariable("id") String id) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("删除成功");
        try {
            ${entityName?uncap_first}Service.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "batch/delete", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public AjaxJson batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
        AjaxJson ajaxJson = new AjaxJson();
        ajaxJson.success("删除成功");
        try {
            List<String> idList = java.util.Arrays.asList(ids);
            ${entityName?uncap_first}Service.deleteBatchIds(idList);
        } catch (Exception e) {
            e.printStackTrace();
            ajaxJson.fail("删除失败");
        }
        return ajaxJson;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String view(Model model, @PathVariable("id") String id, HttpServletRequest request,
                       HttpServletResponse response) {
        ${entityName?cap_first} ${entityName?uncap_first} = get(id);
        model.addAttribute("data", ${entityName?uncap_first});
        return display("edit");
    }

    @RequestMapping(value = "validate", method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public ValidJson validate(DuplicateValid duplicateValid, HttpServletRequest request) {
        ValidJson validJson = new ValidJson();
        Boolean valid = Boolean.FALSE;
        try {
            EntityWrapper<${entityName?cap_first}> entityWrapper = new EntityWrapper<${entityName?cap_first}>(entityClass);
            valid = ${entityName?uncap_first}Service.doValid(duplicateValid,entityWrapper);
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
