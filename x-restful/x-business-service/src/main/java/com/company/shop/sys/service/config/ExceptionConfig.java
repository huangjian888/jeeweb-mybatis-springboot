package com.company.shop.sys.service.config;


import com.company.manerger.sys.common.base.http.Response;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hexin on 2018/12/11.
 * 全局异常处理类
 */
@RestControllerAdvice
public class ExceptionConfig {

    /**
     * 其他全局所有异常
     *
     * @param request
     * @param ex
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Object globalException(HttpServletRequest request, Throwable ex) {
        return Response.error(getStatus(request).value(), "当前操作出现异常,请将操作步骤反馈给管理员进行排查...");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
