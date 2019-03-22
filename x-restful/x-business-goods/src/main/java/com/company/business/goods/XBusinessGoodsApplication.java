package com.company.business.goods;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication(exclude = {DruidDataSourceAutoConfigure.class})//fixme 切数据源必须添加
public class XBusinessGoodsApplication extends SpringBootServletInitializer {
    //fixme 推荐时区问题：从容器中获取的时区少8个小时，必须添加此行代码
    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(XBusinessGoodsApplication.class);
    }

    public static void main(String[] args) {

        SpringApplication.run(XBusinessGoodsApplication.class, args);

    }

    @Bean
    public CorsFilter corsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true); // 允许cookies跨域
        config.addAllowedOrigin("*");// 允许向该服务器提交请求的URI，*表示全部允许。。这里尽量限制来源域，比如http://xxxx:8080 ,以降低安全风险。。
        config.addAllowedHeader("*");// 允许访问的头信息,*表示全部
        config.setMaxAge(18000L);// 预检请求的缓存时间（秒），即在这个时间段里，对于相同的跨域请求不会再预检了
        config.addAllowedMethod("*");// 允许提交请求的方法，*表示全部允许，也可以单独设置GET、PUT等
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");// 允许Get的请求方法
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("OPTIONS");
        //在头中添加Authorization完成jwt认证
        //config.addExposedHeader("Authorization");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

