package com.company.generator.manager.config;

import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.utils.ServletUtils;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@RestControllerAdvice
public class ExceptionConfig {

    /**
     * 捕捉shiro的异常
     *
     * @param ex
     * @return
     */
    @ExceptionHandler(ShiroException.class)
    public Object handle401(ShiroException ex) {
        if (ServletUtils.isAjax()) {
            return Response.error(401, ex.getMessage());
        }else{
            ModelAndView m = new ModelAndView();
            m.addObject("status", 401);
            m.setViewName("/error/401");
            return m;
        }
    }

    /**
     * 捕捉其他所有异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object globalException(HttpServletRequest request, Throwable ex) {
        if (ServletUtils.isAjax()) {
            return Response.error(getStatus(request).value(), "操作出现异常...");
        }else{
            ModelAndView m = new ModelAndView();
            m.addObject("status", getStatus(request).value());
            m.addObject("tips", ex.getMessage());
            m.setViewName("/error/404");
            return m;
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
