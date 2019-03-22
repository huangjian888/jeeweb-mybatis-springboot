package com.company.business.goods.security.user;

import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.security.utils.JwtTokenUtil;
import com.company.business.goods.utils.Log;
import com.company.business.goods.utils.RedisCacheUtils;
import com.company.business.goods.utils.RedisKeyUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements ITokenService {


    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void storeToken(String tokenKey, String value) {//存储token
        Log.i("store redis,tokenKey:" + tokenKey + ",value:" + value);
        try {
            RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getAccessTokenKey(tokenKey), value, TomatoConstant.Common.EXPIRE_TIME_REDIS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getInfoByToken(String tokenKey) {
        try {
            return (String) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getAccessTokenKey(tokenKey));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        return jwtTokenUtil.generateToken(userDetails);
    }
}
