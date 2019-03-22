package com.company.shop.sys.service.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.manerger.sys.common.limit.redis.aspectj.annotation.Limit;
import com.company.manerger.sys.common.limit.redis.aspectj.enums.LimitType;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.vo.WxAuthorizationVo;
import com.company.shop.sys.service.modules.sys.service.IWxAuthenticationService;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


/**
 * 微信授权
 */
@RestController
public class TomatoWxAuthorizationController extends BaseBeanController {
    @Autowired
    private IWxAuthenticationService wxAuthenticationService;


    /**
     * 微信小程序返回的code进行验证
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @GetMapping(value = "/authentication/{code}")
    public Response authentication(HttpServletRequest request, @PathVariable("code") String code) {
        WxAuthorizationVo wxAuthorizationVo = wxAuthenticationService.authentication(request, "test", code);
        if (!TextUtils.isEmpty(wxAuthorizationVo.getErrorMsg())) {//错误信息不为空--存在错误情况
            return Response.error(wxAuthorizationVo.getErrorCode(), wxAuthorizationVo.getErrorMsg());
        }


        return Response.ok().putObject(wxAuthorizationVo);
    }

    /**
     * 通过邀请而进入小程序进行注册
     *
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/authentication")
    public Response authentication(HttpServletRequest request, @RequestBody JSONObject json) {
        String openId = json.getString("openId");//邀请者的openId
        String code = json.getString("code");//微信授权码

        WxAuthorizationVo wxAuthorizationVo = wxAuthenticationService.authentication(request, openId, code);
        if (!TextUtils.isEmpty(wxAuthorizationVo.getErrorMsg())) {//错误信息不为空--存在错误情况
            return Response.error(wxAuthorizationVo.getErrorCode(), wxAuthorizationVo.getErrorMsg());
        }


        return Response.ok().putObject(wxAuthorizationVo);

    }

    /**
     * 解密前端获取的getUserInfo信息--缓存中的sessionKey不能获取，需要传入code重新获取sessionKey
     *
     * @param json
     * @return
     */
    @Limit(key = "order", limitPeriod = 3600, limitCount = 3600, name = "order", prefix = "limit", limitType = LimitType.IP)
    @PostMapping(value = "/user")
    public Response decodeUser(HttpServletRequest request, @RequestBody JSONObject json) {
        JSONObject jsonObject = wxAuthenticationService.decodeUserInfo(request, json);
        if (null == jsonObject) {
            return Response.error(ErrorCodeEnum.COMMON9002.code(), ErrorCodeEnum.COMMON9002.msg());
        }
        return Response.ok().putObject(jsonObject);

    }

}
