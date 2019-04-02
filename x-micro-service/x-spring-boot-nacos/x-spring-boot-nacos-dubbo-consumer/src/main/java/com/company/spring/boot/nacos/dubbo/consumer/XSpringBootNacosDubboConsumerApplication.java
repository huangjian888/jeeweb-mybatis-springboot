package com.company.spring.boot.nacos.dubbo.consumer;


import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@NacosPropertySource(dataId = "example", autoRefreshed = true)
@SpringBootApplication
@EnableDiscoveryClient
public class XSpringBootNacosDubboConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XSpringBootNacosDubboConsumerApplication.class, args);
    }

}
