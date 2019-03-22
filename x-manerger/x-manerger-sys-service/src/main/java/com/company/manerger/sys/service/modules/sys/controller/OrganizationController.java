package com.company.manerger.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.base.mvc.entity.tree.BootstrapTreeHelper;
import com.company.manerger.sys.common.base.mvc.entity.tree.BootstrapTreeNode;
import com.company.manerger.sys.common.base.mvc.entity.tree.TreeSortUtil;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.annotation.PageableDefaults;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.QueryPropertyPreFilter;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.common.utils.ObjectUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.aspectj.annotation.Log;
import com.company.manerger.sys.service.aspectj.enums.LogType;
import com.company.manerger.sys.service.modules.sys.entity.Organization;
import com.company.manerger.sys.service.modules.sys.service.IOrganizationService;
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
import java.util.List;


@RestController
@RequestMapping("${company.admin.url.prefix}/sys/organization")
@ViewPrefix("modules/sys/organization")
@RequiresPathPermission("sys:organization")
@Log(title = "部门管理")
public class OrganizationController extends BaseBeanController<Organization> {

    @Autowired
    private IOrganizationService organizationService;


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
        EntityWrapper<Organization> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Organization> pagejson = new PageResponse<>(organizationService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("data", new Organization());
        return displayModelAndView ("edit");
    }

    @PostMapping("add")
    @Log(logType = LogType.INSERT)
    @RequiresMethodPermissions("add")
    public Response add(Organization entity, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        organizationService.insert(entity);
        return Response.ok("添加成功");
    }

    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        Organization entity = organizationService.selectById(id);
        model.addAttribute("data", entity);
        return displayModelAndView ("edit");
    }

    @PostMapping("{id}/update")
    @Log(logType = LogType.UPDATE)
    @RequiresMethodPermissions("update")
    public Response update(Organization entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        organizationService.insertOrUpdate(entity);
        return Response.ok("更新成功");
    }

    @PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response delete(@PathVariable("id") String id) {
        organizationService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping("batch/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        organizationService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "treeData")
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void treeData(Queryable queryable,
                         @RequestParam(value = "nodeid", required = false, defaultValue = "") String nodeid,
                         @RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
                         HttpServletRequest request, HttpServletResponse response) throws IOException {
        EntityWrapper<Organization> entityWrapper = new EntityWrapper<Organization>(entityClass);
        entityWrapper.setTableAlias("t.");
        List<Organization> treeNodeList = null;
        if (!async) { // 非异步 查自己和子子孙孙
            treeNodeList = organizationService.selectTreeList(queryable, entityWrapper);
            TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
        } else { // 异步模式只查自己
            // queryable.addCondition("parentId", nodeid);
            if (ObjectUtils.isNullOrEmpty(nodeid)) {
                // 判断的应该是多个OR条件
                entityWrapper.isNull("parentId");
            } else {
                entityWrapper.eq("parentId", nodeid);
            }
            treeNodeList = organizationService.selectTreeList(queryable, entityWrapper);
            TreeSortUtil.create().sync(treeNodeList);
        }
        PropertyPreFilterable propertyPreFilterable = new QueryPropertyPreFilter();
        propertyPreFilterable.addQueryProperty("id", "name", "expanded", "hasChildren", "leaf", "loaded", "level",
                "parentId");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Organization> pagejson = new PageResponse<Organization>(treeNodeList);
        String content = JSON.toJSONString(pagejson);
        StringUtils.printJson(response, content);
    }

    /**
     * 根据页码和每页记录数，以及查询条件动态加载数据
     *
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "ajaxTreeList")
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void ajaxTreeList(Queryable queryable,
                              @RequestParam(value = "nodeid", required = false, defaultValue = "") String nodeid,
                              @RequestParam(value = "async", required = false, defaultValue = "false") boolean async,
                              HttpServletRequest request, HttpServletResponse response, PropertyPreFilterable propertyPreFilterable)
            throws IOException {
        EntityWrapper<Organization> entityWrapper = new EntityWrapper<Organization>(entityClass);
        entityWrapper.setTableAlias("t");

        List<Organization> treeNodeList = null;
        if (!async) { // 非异步 查自己和子子孙孙
            treeNodeList = organizationService.selectTreeList(queryable, entityWrapper);
            TreeSortUtil.create().sort(treeNodeList).async(treeNodeList);
        } else { // 异步模式只查自己
            // queryable.addCondition("parentId", nodeid);
            if (ObjectUtils.isNullOrEmpty(nodeid)) {
                // 判断的应该是多个OR条件
                entityWrapper.isNull("parentId");
            } else {
                entityWrapper.eq("parentId", nodeid);
            }
            treeNodeList = organizationService.selectTreeList(queryable, entityWrapper);
            TreeSortUtil.create().sync(treeNodeList);
        }
        propertyPreFilterable.addQueryProperty("id", "expanded", "hasChildren", "leaf", "loaded", "level", "parentId");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Organization> pagejson = new PageResponse<Organization>(treeNodeList);
        String content = JSON.toJSONString(pagejson);
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
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("list")
    public void bootstrapTreeData(Queryable queryable,
                                   @RequestParam(value = "nodeid", required = false, defaultValue = "") String nodeid, HttpServletRequest request,
                                   HttpServletResponse response, PropertyPreFilterable propertyPreFilterable) throws IOException {
        EntityWrapper<Organization> entityWrapper = new EntityWrapper<Organization>(entityClass);
        entityWrapper.setTableAlias("t.");
        List<Organization> treeNodeList = organizationService.selectTreeList(queryable, entityWrapper);
        List<BootstrapTreeNode> bootstrapTreeNodes = BootstrapTreeHelper.create().sort(treeNodeList);
        propertyPreFilterable.addQueryProperty("text", "href", "tags", "nodes");
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        String content = JSON.toJSONString(bootstrapTreeNodes, filter);
        StringUtils.printJson(response, content);
    }

}