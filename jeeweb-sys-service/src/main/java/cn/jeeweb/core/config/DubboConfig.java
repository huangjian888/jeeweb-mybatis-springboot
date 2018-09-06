package cn.jeeweb.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by hexin on 2018/8/29.
 */
@Configuration
@ImportResource({"classpath*:/dubbo.xml"})
public class DubboConfig {

}
