package com.company.business.authorization.moudle.controller;

import com.company.manerger.sys.common.base.http.Response;
import com.company.business.authorization.security.authorization.AuthorizationVo;
import com.company.business.authorization.security.authorization.IAuthenticationService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthorizationController {

    @Autowired

    private IAuthenticationService authenticationService;

    @GetMapping(value = "/authentication/{code}")
    public Response authentication(HttpServletRequest request, @PathVariable("code") String code) {

        AuthorizationVo authorizationVo = authenticationService.authentication(request, code);
        if (!TextUtils.isEmpty(authorizationVo.getErrorMsg())) {//错误信息不为空--存在错误情况
            return Response.error(authorizationVo.getErrorCode(), authorizationVo.getErrorMsg());
        }


        return Response.ok().putObject(authorizationVo);
    }

}
