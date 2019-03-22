package com.company.business.goods.security.authorization;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletRequest;

public interface IAuthenticationService {
    AuthorizationVo authentication(ServletRequest request, String inviteOpenId,String code);

    AuthorizationVo getUserInfo(ServletRequest request, String code);

    JSONObject decodeUserInfo(ServletRequest request, JSONObject json);

    String getAccessToken(ServletRequest request);
}
