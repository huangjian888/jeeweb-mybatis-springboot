package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.limit.redis.aspectj.annotation.Limit;
import com.company.shop.sys.service.common.bean.ResponseError;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.modules.sys.entity.StoreUser;
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
import org.springframework.security.core.AuthenticationException;
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
 * @package com.company.shop.sys.service.modules.sys.controller
 * @title: 用户表控制器
 * @description: 用户表控制器
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */

@RestController
@RequestMapping("storeuser")
public class StoreUserController extends BaseBeanController<StoreUser> {

    @Autowired
    private IStoreUserService storeUserService;


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
    private void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        EntityWrapper<StoreUser> entityWrapper = new EntityWrapper<>(entityClass);
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, entityClass);
        SerializeFilter filter = propertyPreFilterable.constructFilter(entityClass);
        PageResponse<StoreUser> pagejson = new PageResponse<>(storeUserService.list(queryable,entityWrapper));
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response,content);
    }

    @PostMapping("create")
    public Response create(StoreUser entity, BindingResult result,
                           HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("{id}/update")
    public Response update(StoreUser entity, BindingResult result,
                                 HttpServletRequest request, HttpServletResponse response) {
        return doSave(entity, request, response, result);
    }

    @PostMapping("/save")
    public Response doSave(StoreUser entity, HttpServletRequest request, HttpServletResponse response,
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
                storeUserService.insert(entity);
            } else {
                storeUserService.insertOrUpdate(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.error(ResponseError.NORMAL_ERROR,"保存失败!<br />原因:" + e.getMessage());
        }
        return Response.ok("保存成功");
    }


	@PostMapping("{id}/delete")
	public Response delete(@PathVariable("id") String id) {
	    storeUserService.deleteById(id);
		return Response.ok("删除成功");
	}

	@PostMapping("batch/delete")
	public Response batchDelete(@RequestParam("ids") String ids) {
		List<String> idList = java.util.Arrays.asList(ids);
		storeUserService.deleteBatchIds(idList);
		return Response.ok("删除成功");
	}

    @PostMapping(value = "/login")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonParam){
        String username = jsonParam.getString("username");
        String password = jsonParam.getString("password");
        return storeUserService.login(username,password);
    }

    @GetMapping(value = "/refreshToken")
    public String refreshToken(@RequestHeader String authorization){
        return storeUserService.refreshToken(authorization);
    }

    @PostMapping(value = "/register")
    @ResponseBody
    public String register(@RequestBody(required = false) JSONObject jsonParam) throws AuthenticationException {
        String username = jsonParam.getString("username");
        String password = jsonParam.getString("password");
        StoreUser storeUser = new StoreUser();
        storeUser.setUsername(username);
        storeUser.setPassword(password);
        return storeUserService.register(storeUser);
    }

    @Limit(limitPeriod = 600,limitCount = 1)
    @PostMapping("/test")
    @ResponseBody
    public int testLimiter(@RequestBody(required = false) JSONObject jsonParam) {
        System.out.println("---------------------------");
        return 1;
    }
}