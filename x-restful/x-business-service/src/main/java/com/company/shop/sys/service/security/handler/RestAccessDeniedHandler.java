package com.company.shop.sys.service.security.handler;

/**
 * Created by hexin on 2018/11/28.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.GlobalConstant;
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
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setStatus(403);
        //
        httpServletResponse.setContentType(GlobalConstant.Response.RESPONSE_JSON);
        httpServletResponse.setStatus(ErrorCodeEnum.AUTH403.code());
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = httpServletResponse.getWriter();
        out.write(om.writeValueAsString(Response.error(ErrorCodeEnum.AUTH403.code(), ErrorCodeEnum.AUTH403.msg())));
        out.flush();
        out.close();
    }
}
