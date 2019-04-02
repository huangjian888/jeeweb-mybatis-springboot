package com.company.spring.cloud.gateway.provide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@EnableDiscoveryClient
@SpringBootApplication
public class XSpringCloudGatewayProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(XSpringCloudGatewayProvideApplication.class, args);
    }

    @RestController
    public class NacosController {
        @RequestMapping(value = "/echo/test", method = RequestMethod.GET)
        public String test() {
            return "hello Nacos Discovery test" ;
        }
    }
}
