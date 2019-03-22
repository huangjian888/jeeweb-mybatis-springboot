package com.company.manerger.sys.service.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.fastjson.FastjsonUnXssFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.HttpMessageConverter;

/**
 * @description: WEB 初始化相关配置
 */

@ControllerAdvice
@Configuration
public class WebConfig implements WebMvcConfigurer {
    //oss 环境默认为生成环境
    @Value("${oss.env:production}")
    private String env;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();//4
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        FastjsonUnXssFilter jsonUnFilter = new FastjsonUnXssFilter();
        fastJsonConfig.setSerializeFilters(jsonUnFilter);
        //处理中文乱码问题
        List<MediaType> fastMediaTypes = new ArrayList<MediaType>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(fastMediaTypes);
        converter.setFastJsonConfig(fastJsonConfig);

        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> fastJsonHttpMessageConverter_supportedMediaTypes = new ArrayList<>();
        fastJsonHttpMessageConverter_supportedMediaTypes.add(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastJsonHttpMessageConverter_supportedMediaTypes);

        converters.add(converter);
        converters.add(fastJsonHttpMessageConverter);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }

    /**
     * 该方法只是 本地环境测试用，用于本地图片显示(oss.env = debug时候生效)
     * 测试环境，可以将代码加在判断条件中
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if(env.equalsIgnoreCase("debug")){
            registry.addResourceHandler("/data/www/images/**").addResourceLocations("file:F:/Federation2.0/spring-boot-shop/tmp_upload/");
        }
    }
}