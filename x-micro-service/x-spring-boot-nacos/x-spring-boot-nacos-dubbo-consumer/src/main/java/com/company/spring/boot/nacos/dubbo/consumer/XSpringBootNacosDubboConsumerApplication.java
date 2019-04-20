package com.company.spring.boot.nacos.dubbo.consumer;


import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@NacosPropertySource(dataId = "example", autoRefreshed = true)
@SpringBootApplication
@EnableDiscoveryClient
public class XSpringBootNacosDubboConsumerApplication {

    public static void main(String[] args) {
        InitExecutor.doInit();
        SpringApplication.run(XSpringBootNacosDubboConsumerApplication.class, args);
    }

}
