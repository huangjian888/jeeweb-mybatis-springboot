package cn.jeeweb.sso.config;

import cn.jeeweb.sso.interceptor.SsoClientInterceptor;
import cn.jeeweb.sso.service.remote.SsoRemoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by hexin on 2018/9/19.
 */
@Configuration
public class SsoClientWebConfig extends SsoWebConfig{
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @ConfigurationProperties(prefix = "sso")
    public SsoProperties ssoProperties(){
        return new SsoProperties();
    }

    @Bean
    public SsoRemoteService ssoRemoteService(){
        return new SsoRemoteService(restTemplate,ssoProperties());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(new SsoClientInterceptor(ssoRemoteService(),ssoProperties())).addPathPatterns("/**");
    }
}
