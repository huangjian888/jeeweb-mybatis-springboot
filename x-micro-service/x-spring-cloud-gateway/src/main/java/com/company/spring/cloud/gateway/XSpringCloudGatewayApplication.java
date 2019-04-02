package com.company.spring.cloud.gateway;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteDefinition;

@SpringBootApplication
@EnableDiscoveryClient
public class XSpringCloudGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(XSpringCloudGatewayApplication.class, args);
    }

}
