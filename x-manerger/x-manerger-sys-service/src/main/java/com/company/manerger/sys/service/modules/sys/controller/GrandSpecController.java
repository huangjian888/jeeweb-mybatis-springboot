package com.company.manerger.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
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
import com.company.manerger.sys.service.modules.sys.entity.*;
import com.company.manerger.sys.service.modules.sys.service.IGrandClassifyService;
import com.company.manerger.sys.service.modules.sys.service.IGrandSpecService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 *
 * @version V1.0
 * @package com.company.manerger.sys.service.modules.sys.controller
 * @title: 商品规格
 * @description: 商品列表控制器
 * @date: 2018-11-29 15:45:52
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/grandSpec")
@ViewPrefix("modules/sys/grandSpec")
@RequiresPathPermission("sys:grandSpec")
@Log(title="商品规格")
public class GrandSpecController extends BaseBeanController<GrandSpec> {

    @Autowired
    private IGrandClassifyService grandClassifyService;

    @Autowired
    private IGrandSpecService grandSpecService;

    @GetMapping
    public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
        String grandClassifyId = request.getParameter("grandClassifyId");
        GrandClassify grandClassify = grandClassifyService.selectById(grandClassifyId);
        model.addAttribute("grandClassify", grandClassify);
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
        EntityWrapper<GrandSpec> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        //判断获取的商品列表id
        String grandClassifyId = request.getParameter("grandClassifyId");
        if (!StringUtils.isEmpty(grandClassifyId)) {
            entityWrapper.eq("grand_classify_id", grandClassifyId);
        }else{
            entityWrapper.eq("grand_classify_id", "undefined");
        }
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<GrandSpec> pagejson = new PageResponse<>(grandSpecService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    @GetMapping(value = "add")
    public ModelAndView add(Model model, HttpServletRequest request, HttpServletResponse response) {
        String grandClassifyId = request.getParameter("grandClassifyId");
        model.addAttribute("grandClassifyId", grandClassifyId);
        model.addAttribute("data", new GrandSpec());
        return displayModelAndView ("edit");
    }

    @PostMapping("add")
    @Log(logType = LogType.INSERT)
    @RequiresMethodPermissions("add")
    public Response add(GrandSpec entity, BindingResult result,
                        HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        grandSpecService.insert(entity);

        return Response.ok("添加成功");
    }

    @GetMapping(value = "{id}/update")
    public ModelAndView update(@PathVariable("id") String id, Model model, HttpServletRequest request,
                               HttpServletResponse response) {
        GrandSpec entity = grandSpecService.selectById(id);
        model.addAttribute("data", entity);
        return displayModelAndView ("edit");
    }

    @PostMapping("{id}/update")
    @Log(logType = LogType.UPDATE)
    @RequiresMethodPermissions("update")
    public Response update(GrandSpec entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        // 验证错误
        this.checkError(entity,result);
        grandSpecService.insertOrUpdate(entity);
        return Response.ok("更新成功");
    }

    @PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response delete(@PathVariable("id") String id) {
        grandSpecService.deleteById(id);
        return Response.ok("删除成功");
    }

    @PostMapping("batch/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
    public Response batchDelete(@RequestParam("ids") String[] ids) {
        List<String> idList = java.util.Arrays.asList(ids);
        grandSpecService.deleteBatchIds(idList);
        return Response.ok("删除成功");
    }
}
