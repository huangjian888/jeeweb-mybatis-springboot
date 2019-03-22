package com.company.shop.sys.service.config;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 添加拦截器获取header中的token并获取到对应的openId，并实例化到共享变量
 */
@ControllerAdvice
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
