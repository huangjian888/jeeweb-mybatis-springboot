package cn.jeeweb.core.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Rest
 * Created by hexin on 2018/9/11.
 */
@Configuration
@ConditionalOnProperty(name = "jeeweb.common-core.restConfig",havingValue = "true")
public class RestConfig {
    @Autowired
    private FastJsonHttpMessageConverter fastJsonHttpMessageConverter;

    @Bean(name = "restTemplateBuilder")
    public RestTemplateBuilder restTemplateBuilder(){
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.messageConverters(fastJsonHttpMessageConverter);
        return restTemplateBuilder;
    }

    @Bean
    public RestTemplate restTemplate( @Qualifier("restTemplateBuilder")RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder.build();
    }
}
