package com.company.spring.boot.nacos.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "example", autoRefreshed = true)
@EnableDubbo
public class XSpringBootNacosDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(XSpringBootNacosDubboProviderApplication.class, args);
    }

}
