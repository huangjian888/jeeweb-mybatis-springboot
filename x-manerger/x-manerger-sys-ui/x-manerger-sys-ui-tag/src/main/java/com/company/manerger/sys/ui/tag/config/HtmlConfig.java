package com.company.manerger.sys.ui.tag.config;

import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.ui.tag.html.builder.DefaultHtmlComponentBuilder;
import com.company.manerger.sys.ui.tag.html.manager.HtmlComponentManager;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description: HTML初始化
 */
@Configuration
public class HtmlConfig implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments var1) throws Exception {
        SpringContextHolder.getApplicationContext()
                .getBean(HtmlComponentManager.class).init();
    }
    /**
     * HTML 组建加载器
     * @return
     */
    @Bean
    public DefaultHtmlComponentBuilder defaultHtmlComponentBuilder(){
        DefaultHtmlComponentBuilder defaultHtmlComponentBuilder=new DefaultHtmlComponentBuilder();
        defaultHtmlComponentBuilder.setFileNames(new String[]{"classpath:/tagmapper/*-html-component.xml"});
        return defaultHtmlComponentBuilder;
    }

    @Bean
    public HtmlComponentManager htmlComponentManager( DefaultHtmlComponentBuilder defaultHtmlComponentBuilder){
        HtmlComponentManager htmlComponentManager=new HtmlComponentManager();
        htmlComponentManager.setDynamicStatementBuilder(defaultHtmlComponentBuilder);
        return htmlComponentManager;
    }
}
