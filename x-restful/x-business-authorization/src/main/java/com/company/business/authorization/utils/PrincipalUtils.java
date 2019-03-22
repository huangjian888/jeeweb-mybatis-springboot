package com.company.business.authorization.utils;


import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.exception.BusinessException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 获取header中的authorization
 */
public class PrincipalUtils {
    private static String tokenHead = "Bearer ";

    /**
     * 获取header
     *
     * @param request
     * @return
     */
    public static String getAuthHeader(HttpServletRequest request) {

        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isEmpty(authHeader)) {
            throw new BusinessException(ErrorCodeEnum.AUTH1002);//抛出header异常
        }
        return authHeader;
    }


    /**
     * 获取header中的token
     *
     * @param request
     * @return
     */
    public static String getHeaderToken(HttpServletRequest request) {

        String header = getAuthHeader(request);
        final String authToken = header.substring(tokenHead.length()); // The part after "Bearer "

        return authToken;
    }

    /**
     * 获取用户名--openid
     *
     * @return
     */
    public static String getUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();

        }

        if (principal instanceof Principal) {
            return ((Principal) principal).getName();

        }

        return String.valueOf(principal);
    }


}
