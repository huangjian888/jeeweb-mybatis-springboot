package com.company.manerger.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.service.aspectj.annotation.Log;
import com.company.manerger.sys.service.aspectj.enums.LogType;
import com.company.manerger.sys.service.modules.sys.entity.*;
import com.company.manerger.sys.service.modules.sys.service.IGrandService;
import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.annotation.PageableDefaults;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @version V1.0
 * @package com.company.manerger.sys.service.modules.sys.controller
 * @title: 品牌功能控制器
 * @description: 品牌实体控制器
 * @date: 2018-11-27 13:55:10
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/grand")
@ViewPrefix("modules/sys/grand")
@RequiresPathPermission("sys:grand")
@Log(title="品牌管理")
public class GrandController extends BaseBeanController<Grand> {

    @Autowired
    private IGrandService grandService;

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
        EntityWrapper<Grand> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Grand> pagejson = new PageResponse<>(grandService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }
    //添加功能返回页面
    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("data", new Grand());
        return displayModelAndView ("edit");
    }

    @PostMapping("add")
    @Log(logType = LogType.INSERT)
    @RequiresMethodPermissions("add")
    public Response add(Grand entity, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        grandService.insert(entity);
        return Response.ok("添加成功");
    }
    //更新功能返回页面
    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        Grand entity = grandService.selectById(id);
        model.addAttribute("data", entity);
        return displayModelAndView ("edit");
    }

    @PostMapping("{id}/update")
    @Log(logType = LogType.UPDATE)
    @RequiresMethodPermissions("update")
    public Response update(Grand entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        grandService.insertOrUpdate(entity);
        return Response.ok("更新成功");
    }
    //行内删除
    @PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response delete(@PathVariable("id") String id) {
        grandService.deleteById(id);
        return Response.ok("删除成功");
    }
    //标题删除
    @PostMapping("batch/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        grandService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }

}