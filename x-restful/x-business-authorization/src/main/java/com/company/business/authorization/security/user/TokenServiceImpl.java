package com.company.business.authorization.security.user;

import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.business.authorization.security.utils.JwtTokenUtil;
import com.company.business.authorization.utils.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements ITokenService {

    private final int EXPIRE_TIME_REDIS = 7200;//2h


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void storeToken(String tokenKey, String value) {//存储token

        RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getAccessTokenKey(tokenKey), value, EXPIRE_TIME_REDIS);
    }

    @Override
    public String getInfoByToken(String tokenKey) {

        return (String) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getAccessTokenKey(tokenKey));
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwtTokenUtil.generateToken(userDetails);
    }
}
