package com.company.manerger.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresMethodPermissions;
import com.company.manerger.sys.common.security.shiro.authz.annotation.RequiresPathPermission;
import com.company.manerger.sys.service.aspectj.annotation.Log;
import com.company.manerger.sys.service.aspectj.enums.LogType;
import com.company.manerger.sys.service.modules.sys.entity.Grand;
import com.company.manerger.sys.service.modules.sys.service.IGrandClassifyService;
import com.company.manerger.sys.service.modules.sys.entity.GrandClassify;
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
import com.company.manerger.sys.service.modules.sys.service.IGrandService;
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
 * @title: 商品列表控制器
 * @description: 商品列表控制器
 * @date: 2018-11-29 15:45:52
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/grandSpec/grandClassify")
@ViewPrefix("modules/sys/grandSpec/grandClassify")
@RequiresPathPermission("sys:grandSpec")
@Log(title="商品列表")
public class GrandClassifyController extends BaseBeanController<GrandClassify> {

    @Autowired
    private IGrandClassifyService grandClassifyService;

    @Autowired
    private IGrandService grandService;

    @GetMapping
    @RequiresMethodPermissions("view")
    public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
        // 查询品牌名字 selectAll
        List<Grand> grandList = grandService.selectAll();
        String sourceFormatterValue=	StringUtils.toFormatterValue(grandList,"name","name");
        model.addAttribute("sourceFormatterValue",grandList);
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
    @RequiresMethodPermissions("grandSpec:list")
    public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                         HttpServletResponse response) throws IOException {
        EntityWrapper<GrandClassify> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<GrandClassify> pagejson = new PageResponse<>(grandClassifyService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("data", new GrandClassify());
        List<Grand> grandList = grandService.selectAll();
        model.addAttribute("sourceFormatterValue",grandList);
        return displayModelAndView ("edit");
    }

    @PostMapping("add")
    @Log(logType = LogType.INSERT)
    @RequiresMethodPermissions("grandSpec:create")
    public Response add(GrandClassify entity, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        grandClassifyService.insert(entity);
        return Response.ok("添加成功");
    }

    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        GrandClassify entity = grandClassifyService.selectById(id);
        model.addAttribute("data", entity);
        List<Grand> grandList = grandService.selectAll();
        model.addAttribute("sourceFormatterValue",grandList);
        return displayModelAndView ("edit");
    }

    @PostMapping("{id}/update")
    @Log(logType = LogType.UPDATE)
    @RequiresMethodPermissions("grandSpec:update")
    public Response update(GrandClassify entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        grandClassifyService.insertOrUpdate(entity);
        return Response.ok("更新成功");
    }


    @PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("grandSpec:delete")
    public Response delete(@PathVariable("id") String id) {
        grandClassifyService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping("batch/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        grandClassifyService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }

}