package cn.jeeweb.sso.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by hexin on 2018/9/17.
 */
@Configuration
@ImportResource({"classpath*:/dubbo.xml"})
public class DubboConfig {
}
