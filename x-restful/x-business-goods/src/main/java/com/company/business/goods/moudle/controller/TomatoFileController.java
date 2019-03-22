package com.company.business.goods.moudle.controller;

import com.company.manerger.sys.common.base.http.Response;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 上传图片到cdn
 */
@RestController
@RequestMapping(value = "/tomato")
public class TomatoFileController {

    /**
     * 上传图片
     *
     * @return
     */
    @PostMapping(value = "/img/upload")
    public Response upload(HttpServletRequest request, HttpServletResponse response) {

        response.setContentType("text/plain");
        Response responseResult = new Response();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        return null;
    }

}
