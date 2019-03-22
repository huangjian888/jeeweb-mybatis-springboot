package com.company.shop.sys.service.utils;

import com.company.shop.sys.service.common.annotation.NoNeedAccessAuthentication;
import org.springframework.web.method.HandlerMethod;

import java.lang.reflect.Method;

/**
 * 注解utils
 */
public class AnnotationUtils {

    /****
     * 当前请求对象有被声明NoNeedAccessAuthentication
     * @param handler
     * @return
     */
    private static boolean isHaveAccess(Object handler) {
        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Method method = handlerMethod.getMethod();

        NoNeedAccessAuthentication responseBody = org.springframework.core.annotation.AnnotationUtils.findAnnotation(method, NoNeedAccessAuthentication.class);
        return responseBody != null;
    }
}
