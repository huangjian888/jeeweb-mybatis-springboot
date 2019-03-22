package com.company.shop.sys.service.modules.sys.service;

import com.alibaba.fastjson.JSONObject;
import com.company.shop.sys.service.common.vo.WxAuthorizationVo;

import javax.servlet.ServletRequest;

public interface IWxAuthenticationService {
    WxAuthorizationVo authentication(ServletRequest request, String openId, String code);

    WxAuthorizationVo getUserInfo(ServletRequest request, String code);

    JSONObject decodeUserInfo(ServletRequest request, JSONObject json);

    String getAccessToken(ServletRequest request);
}
