package com.company;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan({
		"com.company.manerger.sys.service","com.company.manerger.sys.common.oss","com.company.manerger.sys.ui","com.company.manerger.sys.common.utils.trace"
})
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, DruidDataSourceAutoConfigure.class})
public class XManergerSysServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(XManergerSysServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(XManergerSysServiceApplication.class, args);
	}
}
