package com.company.manerger.sys.service.config;

import com.company.manerger.sys.common.base.interceptor.EncodingInterceptor;
import com.company.manerger.sys.common.security.shiro.interceptor.PermissionInterceptorAdapter;
import com.company.manerger.sys.service.interceptor.WebInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description: 拦截器
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    /**
     * 编码拦截器
     * @return
     */
    @Bean
    public HandlerInterceptor encodingInterceptor(){
        EncodingInterceptor encodingInterceptor=new EncodingInterceptor();
        return encodingInterceptor;
    }

    /**
     * 安全验证拦截器
     * @return
     */
    @Bean
    public PermissionInterceptorAdapter permissionInterceptorAdapter(){
        PermissionInterceptorAdapter permissionInterceptorAdapter=new PermissionInterceptorAdapter();
        return permissionInterceptorAdapter;
    }

    /**
     * 编码拦截器
     * @return
     */
    //@Bean
    public WebInterceptor webInterceptor(){
        WebInterceptor webInterceptor=new WebInterceptor();
        return webInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //编码拦截器
        registry.addInterceptor(encodingInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //安全验证拦截器
        registry.addInterceptor(permissionInterceptorAdapter()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //web拦截器
        registry.addInterceptor(webInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");

    }
}
