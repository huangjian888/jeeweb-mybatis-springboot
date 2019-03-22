package com.company.business.authorization.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

/***
 * 用于设置redis_key
 */
public class RedisKeyUtils {
    //token缓存key
    private static String ACCESS_TOKEN_PREFIX = "company:business:authorization";



    /**
     * token前缀key
     *
     * @param token
     * @return
     */
    public static String getAccessTokenKey(String token) {
        Preconditions.checkArgument(StringUtils.isNotEmpty(token), "非法请求token参数不存在");
        return ACCESS_TOKEN_PREFIX + ":" + token;
    }


}
