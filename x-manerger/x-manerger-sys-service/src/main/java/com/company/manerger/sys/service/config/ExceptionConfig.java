package com.company.manerger.sys.service.config;


import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.utils.ServletUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hexin on 2018/12/11.
 * 全局异常处理类
 */
//@ControllerAdvice
@RestControllerAdvice
public class ExceptionConfig {

    /**
     * UnauthorizedException
     * @return
     */
    @ExceptionHandler({ShiroException.class,UnauthorizedException.class, UnauthenticatedException.class})
    public Object handle401() {
        if (ServletUtils.isAjax()) {
            return Response.error(401, "当前操作未授权,联系管理员分配权限!");
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("/error/401");
            return modelAndView;
        }
    }

    /**
     * 其他全局所有异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object globalException(HttpServletRequest request, Exception ex) {
        if (ServletUtils.isAjax()) {
            return Response.error(getStatus(request).value(), "当前操作出现异常,请将操作步骤反馈给管理员进行排查...");
        }else{
            int status = getStatus(request).value();
            if (status==400 || status==401 || status==403 || status==404 || status==500) {
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("/error/" + status);
                return modelAndView;
            }else{
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("/error/500");
                return modelAndView;
            }
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
