package com.company.business.authorization.security.authorization;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.company.manerger.sys.common.utils.RestTemplateUtils;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.modules.sys.service.ITokenService;
import com.company.business.authorization.common.constant.TomatoConstant;
import com.company.business.authorization.security.user.ITomatoUserService;
import com.company.business.authorization.security.user.TomatoUserEntity;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import java.util.Date;

@Transactional
@Service
public class AuthenticationServiceImpl implements IAuthenticationService {
    private String ERROR_CODE_MESSAGE = "errcode";
    private String ERROR_MSG_MESSAGE = "errmsg";
    private String SESSION_KEY = "session_key";
    private String OPEN_ID_KEY = "openid";
    @Autowired
    private AuthenticationConfigProperties configProperties;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Resource
    private ITokenService tokenService;
    @Autowired
    private ITomatoUserService tomatoUserService;


    @Override
    public AuthorizationVo authentication(ServletRequest request, String code) {

        AuthorizationVo authorizationVo = this.requestWxAuthtication(request, code);

        //fixme 登录成功
        if (TextUtils.isEmpty(authorizationVo.getErrorMsg())) {
            Date date = new Date();
            String openId = authorizationVo.getOpenId();
            //fixme 注册用户到数据库
            insertUserInfo(date, openId);
            //fixme 实例化全局用户信息
            UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(openId, openId);

            Authentication authentication = authenticationManager.authenticate(upToken);//调用loadUserByUsername--ProviderManager实现类中
            SecurityContextHolder.getContext().setAuthentication(authentication);//实例化全局Authentication对象--登录成功后会实例化UserDetails实例
            UserDetails userDetails = userDetailsService.loadUserByUsername(openId);
            String token = tokenService.generateToken(userDetails);
            authorizationVo.setToken(token);
            //fixme 获取微信access_token start
            String url = new StringBuilder(configProperties.getWx_token_url()).append("&appid=").append(configProperties.getAppId())
                    .append("&secret=").append(configProperties.getAppSecret()).toString();

            String response = RestTemplateUtils.get(request, url, null);
            JSONObject json = JSON.parseObject(response);
            String access_token = json.getString("access_token");
            //fixme 获取微信access_token end

            tokenService.storeToken(token, access_token);//保存token到redis
        }
        return authorizationVo;
    }

    @Override
    public AuthorizationVo getUserInfo(ServletRequest request, String code) {

        return null;
    }

    @Override
    public JSONObject decodeUserInfo(ServletRequest request, JSONObject json) {

        return null;
    }


    private void insertUserInfo(Date date, String openId) {

        TomatoUserEntity tomatoUser = tomatoUserService.findUserByUsername(openId);
        if (null == tomatoUser) {

            tomatoUser = buildTomatoUser(openId, date);
            int success = tomatoUserService.updateTomatoUser(tomatoUser);//--success

        } else {

            tomatoUser.setLatelyLogin(date);//设置最近一次登录
            tomatoUserService.updateTomatoUser(tomatoUser);//更新当前的用户状态
        }

    }

    /**
     * 注册
     *
     * @param openId
     * @return
     */
    private TomatoUserEntity buildTomatoUser(String openId, Date date) {
        TomatoUserEntity tomatoUser = new TomatoUserEntity();
        tomatoUser.setUsername(openId);
        tomatoUser.setPassword(openId);//openId作为密码
        tomatoUser.setRegisterDate(date);//注册时间
        tomatoUser.setLatelyLogin(date);//最近登录时间--注册时间
        tomatoUser.setRookie(TomatoConstant.Common.NUMBER_1);//设置是新用户
        return tomatoUser;
    }

    /**
     * 微信鉴权请求
     *
     * @param request
     * @param code
     */
    private AuthorizationVo requestWxAuthtication(ServletRequest request, String code) {

        String url = new StringBuilder(configProperties.getWx_authorization_url()).append("?appid=")
                .append(configProperties.getAppId()).append("&secret=")
                .append(configProperties.getAppSecret()).append("&js_code=")
                .append(code).append("&grant_type=")
                .append(configProperties.getGrantType()).toString();

        AuthorizationVo authorizationVo = new AuthorizationVo();//创建返回对象
        try {
            String response = RestTemplateUtils.get(request, url, null);
            JSONObject json = JSON.parseObject(response);
            if (!TextUtils.isEmpty(json.getString(OPEN_ID_KEY))) {//成功后无返回码
                String openId = json.getString(OPEN_ID_KEY);
                String sessionKey = json.getString(SESSION_KEY);

                authorizationVo.setOpenId(openId);
                authorizationVo.setSessionKey(sessionKey);

            } else {//失败信息
                authorizationVo.setErrorCode(json.getIntValue(ERROR_CODE_MESSAGE));
                authorizationVo.setErrorMsg(json.getString(ERROR_MSG_MESSAGE));
                return authorizationVo;
            }


        } catch (Exception e) {
            e.printStackTrace();
            authorizationVo.setErrorCode(ErrorCodeEnum.AUTH1003.code());
            authorizationVo.setErrorMsg(ErrorCodeEnum.AUTH1003.msg());
            return authorizationVo;
        }


        return authorizationVo;
    }
}
