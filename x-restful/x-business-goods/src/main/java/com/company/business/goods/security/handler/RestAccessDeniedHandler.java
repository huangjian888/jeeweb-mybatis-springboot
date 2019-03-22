package com.company.business.goods.security.handler;

/**
 * Created by hexin on 2018/11/28.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 权限不足的返回值
 * 403返回值
 */
@Component
public class RestAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setStatus(403);
        //返回前端对应错误
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(ErrorCodeEnum.AUTH403.code());
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = response.getWriter();

        out.write(om.writeValueAsString(Response.error(ErrorCodeEnum.AUTH403.code(), ErrorCodeEnum.AUTH403.msg())));
        out.flush();
        out.close();
    }
}
