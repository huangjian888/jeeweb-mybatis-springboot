package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({
		"com.company.generator.manager","com.company.manerger.sys.common.oss","com.company.manerger.sys.ui"
})
@SpringBootApplication
public class XGeneratorManagerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(XGeneratorManagerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(XGeneratorManagerApplication.class, args);
	}
}
