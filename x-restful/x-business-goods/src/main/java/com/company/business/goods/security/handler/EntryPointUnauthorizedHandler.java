package com.company.business.goods.security.handler;

/**
 * Created by hexin on 2018/11/28.
 */

import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.utils.Log;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 身份验证失败的返回值--账号密码验证失败处理器
 * 401返回值
 */
@Component
public class EntryPointUnauthorizedHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        Log.i("EntryPointUnauthorizedHandler Access-Control-Allow-Origin 401");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setStatus(401);
        //

        httpServletResponse.setContentType("application/json;charset=utf-8");
        httpServletResponse.setStatus(ErrorCodeEnum.AUTH401.code());
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = httpServletResponse.getWriter();
        out.write(om.writeValueAsString(Response.error(ErrorCodeEnum.AUTH401.code(),ErrorCodeEnum.AUTH401.msg())));
        out.flush();
        out.close();


    }
}
