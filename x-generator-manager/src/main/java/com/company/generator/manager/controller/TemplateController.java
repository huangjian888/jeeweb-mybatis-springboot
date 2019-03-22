package com.company.generator.manager.controller;

import com.company.generator.manager.entity.Template;
import com.company.generator.manager.service.ITemplateService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.company.manerger.sys.common.base.http.PageResponse;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.annotation.ViewPrefix;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.query.data.PropertyPreFilterable;
import com.company.manerger.sys.common.query.data.Queryable;
import com.company.manerger.sys.common.query.utils.QueryableConvertUtils;
import com.company.manerger.sys.common.utils.ObjectUtils;
import com.company.manerger.sys.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("${admin.url.prefix}/generator/template")
@ViewPrefix("modules/generator/template")
public class TemplateController extends BaseBeanController<Template> {

    @Autowired
    protected ITemplateService templateService;

    public Template get(String id) {
        if (!ObjectUtils.isNullOrEmpty(id)) {
            return templateService.selectById(id);
        } else {
            return newModel();
        }
    }

    @GetMapping
    public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
        String schemeid=request.getParameter("schemeid");
        request.setAttribute("schemeid",schemeid);
        return displayModelAndView("list");
    }

    @RequestMapping(value = "ajaxList", method = { RequestMethod.GET, RequestMethod.POST })
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<Template> entityWrapper = new EntityWrapper<Template>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        String schemeId=request.getParameter("schemeId");
        if (!StringUtils.isEmpty(schemeId)) {
            entityWrapper.eq("scheme_id", schemeId);
        }else{
            entityWrapper.eq("scheme_id", "scheme_id");
        }
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<Template> pagejson = new PageResponse<Template>(templateService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        if (!model.containsAttribute("data")) {
            model.addAttribute("data", newModel());
        }
        String schemeId = request.getParameter("schemeId");
        model.addAttribute("schemeId", schemeId);
        return displayModelAndView("edit");
    }

    @PostMapping(value = "add")
    public Response add(Model model, @Valid @ModelAttribute("data") Template template, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(template,result);
        templateService.insert(template);
        return Response.ok("添加成功");
    }

    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                         HttpServletResponse response) {
        Template template = get(id);
        model.addAttribute("data", template);
        String schemeId = request.getParameter("schemeId");
        model.addAttribute("schemeId", template.getSchemeId());
        return displayModelAndView("edit");
    }

    @PostMapping(value = "{id}/update")
    public Response update(Model model, @Valid @ModelAttribute("data") Template template, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(template,result);
        templateService.insertOrUpdate(template);
        return Response.ok("更新成功");
    }

    @PostMapping(value = "{id}/delete")
    public Response delete(@PathVariable("id") String id) {
        templateService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping(value = "batch/delete")
    public Response batchDelete(@RequestParam(value = "ids", required = false) String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        templateService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }

    /**
     * 行内编辑
     * @return
     */
    @PostMapping(value = "inline/edit")
    public Response inlineEdit(Template template) { ;
        try {
            templateService.inlineEdit(template);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("删除失败");
        }
        return  Response.ok("删除成功");
    }

    /**
     * 模版测试
     * @return
     */
    @PostMapping(value = "test")
    public Response test(Template template) { ;
        try {
            templateService.test(template);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error("生成失败："+e.getMessage());
        }
        return  Response.ok("生成成功");
    }
}
