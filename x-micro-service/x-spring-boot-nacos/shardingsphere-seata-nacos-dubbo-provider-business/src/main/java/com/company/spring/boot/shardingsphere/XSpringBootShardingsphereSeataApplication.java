package com.company.spring.boot.shardingsphere;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@ComponentScan({
        "com.company.spring.boot.shardingsphere.seata",
})
@MapperScan({
        "com.baomidou.springboot.mapper*" ,"com.company.spring.boot.shardingsphere.seata.modules.mapper*"
})
//@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication(exclude = {
        DruidDataSourceAutoConfigure.class,
        DataSourceAutoConfiguration.class,
        MybatisPlusAutoConfiguration.class,
        RedisAutoConfiguration.class
})
@EnableDubbo(scanBasePackages = "com.company.spring.boot.shardingsphere.seata.modules.service")
@EnableDiscoveryClient
public class XSpringBootShardingsphereSeataApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(XSpringBootShardingsphereSeataApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XSpringBootShardingsphereSeataApplication.class);
    }
}
