package com.company.manerger.sys.service.config;

import com.company.manerger.sys.common.query.resolver.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @description:  参数解析类
 */
@Configuration
public class ResolverConfig  implements WebMvcConfigurer {

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new QueryMethodArgumentResolver());
        argumentResolvers.add(new PageableMethodArgumentResolver());
        argumentResolvers.add(new FormModelMethodArgumentResolver());
        argumentResolvers.add(new RequestJsonParamMethodArgumentResolver());
        argumentResolvers.add(new PropertyPreFilterMethodArgumentResolver());
    }

}


