package com.company.shop.sys.service.modules.sys.service.impl;

import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.modules.sys.service.ITokenService;
import com.company.shop.sys.service.utils.JwtTokenUtil;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/***
 * 封装所有token操作
 */
@Transactional
@Service
public class TokenServiceImpl implements ITokenService {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void storeToken(String tokenKey, String value) {//存储token

        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getAccessTokenKey(tokenKey), value, BusinessConstant.Common.EXPIRE_TIME_REDIS);
    }

    @Override
    public String getInfoByToken(String tokenKey) {

        return (String) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getAccessTokenKey(tokenKey));
    }

    @Override
    public String refreshToken(String oldToken, String refresh) {
        return null;
    }

    @Override
    public void updateToken(String newToken, String oldToken) {

    }

    /**
     * openId
     *
     * @param username
     * @return
     */
    @Override
    public String generateToken(String username) {
        return jwtTokenUtil.generateToken(username);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwtTokenUtil.generateToken(userDetails);
    }


}
