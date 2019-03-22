package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.security.authorization.AuthorizationVo;
import com.company.business.goods.security.authorization.IAuthenticationService;
import com.company.business.goods.utils.Log;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthorizationController {

    @Autowired

    private IAuthenticationService authenticationService;

    @GetMapping(value = "/authentication/{code}")
    public Response authentication(HttpServletRequest request, @PathVariable("code") String code) {
        AuthorizationVo authorizationVo = authenticationService.authentication(request, "", code);
        if (!TextUtils.isEmpty(authorizationVo.getErrorMsg())) {//错误信息不为空--存在错误情况
            return Response.error(authorizationVo.getErrorCode(), authorizationVo.getErrorMsg());
        }


        return Response.ok().putObject(authorizationVo);
    }


    @PostMapping(value = "/authentication")
    public Response authentication(HttpServletRequest request, @RequestBody JSONObject json) {
        String openId = json.getString("openId");//邀请者的openId
        String code = json.getString("code");//微信授权码

        AuthorizationVo wxAuthorizationVo = authenticationService.authentication(request, openId, code);
        if (!TextUtils.isEmpty(wxAuthorizationVo.getErrorMsg())) {//错误信息不为空--存在错误情况
            return Response.error(wxAuthorizationVo.getErrorCode(), wxAuthorizationVo.getErrorMsg());
        }


        return Response.ok().putObject(wxAuthorizationVo);

    }

    /**
     * 前端上传用户加密数据
     *
     * @param request
     * @param json
     * @return
     */
    @PostMapping(value = "/user/info")
    public Response decodeUser(HttpServletRequest request, @RequestBody JSONObject json) {
        Log.i("enter decodeUser");
        JSONObject jsonObject = authenticationService.decodeUserInfo(request, json);
        if (null == jsonObject) {
            return Response.error(ErrorCodeEnum.AUTH500.code(), ErrorCodeEnum.AUTH500.msg());
        }
        return Response.ok().putObject(jsonObject);
    }
}
