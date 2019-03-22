package com.company.generator.manager.config;

import com.company.generator.manager.common.definition.DefinitionBuilder;
import com.company.generator.manager.filter.LoginFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@ControllerAdvice
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.serializationInclusion(JsonInclude.Include.NON_NULL);
        ObjectMapper objectMapper = builder.build();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        objectMapper.registerModule(simpleModule);
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);// 忽略 transient 修饰的属性
        converters.add(new MappingJackson2HttpMessageConverter(objectMapper));
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
    /**
     * HTML 组建加载器
     * @return
     */
    @Bean
    public DefinitionBuilder definitionBuilder(){
        DefinitionBuilder definitionBuilder=new DefinitionBuilder();
        definitionBuilder.setFileNames(new String[]{"classpath*:/config/definition/*-definition.xml"});
        return definitionBuilder;
    }
    /**
     * 登陆拦截器
     * @return
     */
    //@Bean
    public LoginFilter LoginFilter() {
        return new LoginFilter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}