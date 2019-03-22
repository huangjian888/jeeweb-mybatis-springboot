package com.company.generator.manager.config;

import com.company.generator.manager.interceptor.LoginInterceptor;
import com.company.generator.manager.interceptor.WebInterceptor;
import com.company.manerger.sys.common.base.interceptor.EncodingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description: 拦截器
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    /**
     * 编码拦截器
     * @return
     */
    //@Bean
    public HandlerInterceptor encodingInterceptor(){
        EncodingInterceptor encodingInterceptor=new EncodingInterceptor();
        return encodingInterceptor;
    }

    /**
     * 编码拦截器
     * @return
     */
    //@Bean
    public LoginInterceptor loginInterceptor(){
        LoginInterceptor loginInterceptor=new LoginInterceptor();
        loginInterceptor.setLoginUrl("/admin/login");
        return loginInterceptor;
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
        registry.addInterceptor(loginInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        //安全验证拦截器
        registry.addInterceptor(webInterceptor()).addPathPatterns("/**").excludePathPatterns("/upload/**","/static/**");
        super.addInterceptors(registry);
    }
}
