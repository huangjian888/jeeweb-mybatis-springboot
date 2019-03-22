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
import com.company.manerger.sys.service.modules.sys.entity.OperationLog;
import com.company.manerger.sys.service.modules.sys.service.IOperationLogService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


/**
 * @description: 操作日志控制器
 */

@RestController
@RequestMapping("${company.admin.url.prefix}/sys/operation/log")
@ViewPrefix("modules/sys/log")
@RequiresPathPermission("sys:operation:log")
@Log(title = "操作日志")
public class OperationLogController extends BaseBeanController<OperationLog> {

    @Autowired
    private IOperationLogService operationLogService;


    @GetMapping
    @RequiresMethodPermissions("view")
	public ModelAndView list(Model model, HttpServletRequest request, HttpServletResponse response) {
		return displayModelAndView("operation_list");
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
        EntityWrapper<OperationLog> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<OperationLog> pagejson = new PageResponse<>(operationLogService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

	@PostMapping("{id}/delete")
    @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
	public Response delete(@PathVariable("id") String id) {
	    operationLogService.deleteById(id);
		return Response.ok("删除成功");
	}

    @GetMapping("{id}/detail")
    @Log(logType = LogType.SELECT)
    @RequiresMethodPermissions("detail")
    public ModelAndView detail(Model model,@PathVariable("id") String id) {
        OperationLog operationLog = operationLogService.selectById(id);
        model.addAttribute("operationLog", operationLog);
        return displayModelAndView("operation_detail");
    }

	@PostMapping("batch/delete")
   // @Log(logType = LogType.DELETE)
    @RequiresMethodPermissions("delete")
	public Response batchDelete(@RequestParam("ids") String[] ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		operationLogService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}
}