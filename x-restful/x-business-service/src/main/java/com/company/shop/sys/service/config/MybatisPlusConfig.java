package com.company.shop.sys.service.config;

import com.baomidou.mybatisplus.incrementer.H2KeyGenerator;
import com.baomidou.mybatisplus.incrementer.IKeyGenerator;
import com.baomidou.mybatisplus.mapper.ISqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.company.manerger.sys.common.mybatis.injector.AutoSqlInjector;
//import com.company.shop.sys.service.common.handler.BaseMetaObjectHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: Mybatis-Plus配置
 */
@Configuration
@MapperScan("com.baomidou.springboot.mapper*")
public class MybatisPlusConfig {

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    /*@Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
*/
    /**
     * mybatis-plus分页插件<br>
     * 文档：http://mp.baomidou.com<br>
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLocalPage(true);// 开启 PageHelper 的支持
        return paginationInterceptor;
    }


//    @Bean
//    public MetaObjectHandler metaObjectHandler(){
//        return new BaseMetaObjectHandler();
//    }

    /**
     * 注入主键生成器
     */
    @Bean
    public IKeyGenerator keyGenerator() {
        return new H2KeyGenerator();
    }

    /**
     * 注入sql注入器
     */
    @Bean
    public ISqlInjector sqlInjector() {
        //return new LogicSqlInjector();
        return new AutoSqlInjector();
    }

}