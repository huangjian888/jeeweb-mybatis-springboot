package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@ComponentScan({
        "com.company.shop.sys.service", "com.company.manerger.sys.common.idgenerator", "com.company.manerger.sys.common.limit.redis.aspectj"
})
@SpringBootApplication
public class ShopSysServiceApplication extends SpringBootServletInitializer {
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ShopSysServiceApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(ShopSysServiceApplication.class, args);
    }
}
