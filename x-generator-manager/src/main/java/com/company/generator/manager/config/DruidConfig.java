package com.company.generator.manager.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DruidConfig {

        /**
         * 注册一个StatViewServlet
         * @return
         */
        @Bean
        public ServletRegistrationBean druidStatViewServle(){
            ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/admin/sys/monitor/druid/*");
            return servletRegistrationBean;
        }

        /**
         * 注册一个：filterRegistrationBean
         * @return
         */
        @Bean
        public FilterRegistrationBean druidStatFilter(){

            FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());

            //添加过滤规则.
            filterRegistrationBean.addUrlPatterns("/*");

            //添加不需要忽略的格式信息.
            filterRegistrationBean.addInitParameter("exclusions","/static/*,*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
            return filterRegistrationBean;
        }

    }
