package com.company.business.authorization.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hexin on 2018/11/30.
 * 通过RestTemplate.post/get ForObject进行请求时候，RestTemplate源码中必须要设置messageConverters
 * 通过RestTemplate.exchange进行请求时候，参考RestTemplateUtils类
 */
@Configuration
public class RestConfig {
    @Bean(name = "fastJsonHttpMessageConverter")
    public FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> fastJsonHttpMessageConverter_supportedMediaTypes = new ArrayList<>();
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastJsonHttpMessageConverter_supportedMediaTypes);
        fastJsonHttpMessageConverter_supportedMediaTypes.add(MediaType.valueOf("application/json;charset=UTF-8"));
        return fastJsonHttpMessageConverter;
    }

    @Bean(name = "restTemplateBuilder")
    public RestTemplateBuilder restTemplateBuilder(@Qualifier("fastJsonHttpMessageConverter") FastJsonHttpMessageConverter fastJsonHttpMessageConverter) {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.messageConverters(fastJsonHttpMessageConverter);
        return restTemplateBuilder;
    }

    @Bean
    public RestTemplate restTemplate(@Qualifier("restTemplateBuilder") RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }
}
