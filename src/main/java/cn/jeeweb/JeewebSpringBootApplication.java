package cn.jeeweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@MapperScan("")
//@ComponentScan(basePackages = {
//		"cn.jeeweb.core.common.service.*",
//		"cn.jeeweb.core.common.dao.*",
//		"cn.jeeweb.modules.**.service",
//		"cn.jeeweb.modules.**.mapper"
//		}
//)
public class JeewebSpringBootApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JeewebSpringBootApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(JeewebSpringBootApplication.class, args);
	}
}
