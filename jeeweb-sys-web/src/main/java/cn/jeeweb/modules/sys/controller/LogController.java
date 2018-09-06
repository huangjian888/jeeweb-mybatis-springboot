package cn.jeeweb.modules.sys.controller;

import cn.jeeweb.core.common.controller.BaseCRUDController;
import cn.jeeweb.core.model.PageJson;
import cn.jeeweb.core.query.data.PageImpl;
import cn.jeeweb.core.query.data.Pageable;
import cn.jeeweb.core.query.data.PropertyPreFilterable;
import cn.jeeweb.core.query.data.Queryable;
import cn.jeeweb.core.query.utils.QueryableConvertUtils;
import cn.jeeweb.core.query.wrapper.EntityWrapper;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresMethodPermissions;
import cn.jeeweb.core.security.shiro.authz.annotation.RequiresPathPermission;
import cn.jeeweb.core.utils.StringUtils;
import cn.jeeweb.modules.sys.entity.Log;
import cn.jeeweb.modules.sys.service.ILogService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


/**
 * 
 * All rights Reserved, Designed By www.jeeweb.cn
 * 
 * @title: 系统日志
 * @package cn.jeeweb.modules.sys.controller
 * @description: 系统日志
 * @author: auth_team
 * @date: 2017年5月29日 下午11:35:26
 * @version V1.0
 * @copyright: 2017 www.jeeweb.cn Inc. All rights reserved.
 *
 */
@Controller
@RequestMapping("${admin.url.prefix}/sys/log")
@RequiresPathPermission("sys:log")
public class LogController extends BaseCRUDController<Log,String> {
    @Resource
    private ILogService logService;

    @RequiresMethodPermissions("list")
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("LogController--------------list");
        return display("list");
    }

    @RequestMapping(value = "ajaxList", method = {RequestMethod.GET, RequestMethod.POST})
    public void ajaxList(Queryable queryable, PropertyPreFilterable propertyPreFilterable, HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("LogController--------------ajaxList");
        propertyPreFilterable.addQueryProperty("id");
        // 预处理
        QueryableConvertUtils.convertQueryValueToEntityValue(queryable, Log.class);
        SerializeFilter filter = propertyPreFilterable.constructFilter(Log.class);
        Pageable pageable = queryable.getPageable();
        com.baomidou.mybatisplus.plugins.Page<Log> page = new com.baomidou.mybatisplus.plugins.Page<Log>(pageable.getPageNumber(), pageable.getPageSize());
        PageJson<Log> pagejson = null;
        if(queryable.getValue("createDate") != null){
            ArrayList arrayList = (ArrayList) queryable.getValue("createDate");
            Object startTime = arrayList.get(0);
            Object endTime = arrayList.get(1);
            com.baomidou.mybatisplus.plugins.Page<Log> content = logService.selectLogPageByTime(page,(Date) startTime,(Date) endTime);
            pagejson = new PageJson<Log>( new PageImpl<Log>(content.getRecords(), queryable.getPageable(), content.getTotal()));
        }else{
            pagejson =  new PageJson<Log>(logService.list(queryable,new EntityWrapper<Log>(Log.class)));
        }
        String content = JSON.toJSONString(pagejson, filter);
        StringUtils.printJson(response, content);
    }


}
