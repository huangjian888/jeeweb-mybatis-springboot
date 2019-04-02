package com.company.spring.cloud.gateway.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class XSpringCloudGatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(XSpringCloudGatewayServiceApplication.class, args);
    }

}
