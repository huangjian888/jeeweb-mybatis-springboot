package cn.jeeweb;

import com.alibaba.csp.sentinel.init.InitExecutor;
import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@DubboComponentScan
@SpringBootApplication(scanBasePackages={"cn.jeeweb"})
public class JeewebSysServiceApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(JeewebSysServiceApplication.class);
	}

	public static void main(String[] args) {
		InitExecutor.doInit();
		SpringApplication.run(JeewebSysServiceApplication.class, args);
	}
}
