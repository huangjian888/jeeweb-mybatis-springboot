package cn.jeeweb.sso.config;

import cn.jeeweb.core.config.WebConfig;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

/**
 * Created by hexin on 2018/9/13.
 */
public class SsoSysWebConfig extends WebConfig {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);

    }
}
