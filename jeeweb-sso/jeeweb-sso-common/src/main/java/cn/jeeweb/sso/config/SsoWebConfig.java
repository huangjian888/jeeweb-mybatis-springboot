package cn.jeeweb.sso.config;

import cn.jeeweb.core.config.WebConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

/**
 * Created by hexin on 2018/9/14.
 */
@Configuration
public class SsoWebConfig extends WebConfig{

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        super.addCorsMappings(registry);
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowCredentials(true)
                .allowedMethods("GET", "POST", "DELETE", "PUT")
                .allowedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Headers", "Access-Control-Allow-Methods", "Access-Control-Max-Age")
                .exposedHeaders("Access-Control-Allow-Origin")
                .maxAge(3600);
    }

}
