package cn.jeeweb.core.config;

import cn.jeeweb.core.common.handler.BaseMetaObjectHandler;
import cn.jeeweb.core.query.injector.AutoSqlInjector;
import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.spring.MybatisMapperRefresh;
import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by hexin on 2018/8/14.
 */
@Configuration
@ConditionalOnProperty(name = "jeeweb.common-core.myBatisConfig",havingValue = "true")
@ConditionalOnClass(value = {MapperScannerConfigurer.class, DataSourceTransactionManager.class})
@EnableTransactionManagement(proxyTargetClass = true)
@EnableScheduling
public class MyBatisConfig {
    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean(name = "sqlSessionFactory")
//    @ConditionalOnBean(DataSource.class)
    public MybatisSqlSessionFactoryBean sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sessionFactory.setMapperLocations(resolver.getResources("classpath:/mappings/**/*.xml"));
        sessionFactory.setTypeAliasesPackage("cn.jeeweb.modules.*.entity");

        Properties configurationProperties = new Properties();
        configurationProperties.put("dbType","mysql");
        sessionFactory.setConfigurationProperties(configurationProperties);

//        PaginationInterceptor page = new PaginationInterceptor();
//        page.setDialectType("mysql");
//        sessionFactory.setPlugins(new Interceptor[]{page});

//        MybatisConfiguration configuration = new MybatisConfiguration();
//        configuration.setLogImpl(Slf4jImpl.class);
//        configuration.setCallSettersOnNulls(true);
//        sessionFactory.setConfiguration(configuration);

        GlobalConfiguration config = new GlobalConfiguration();
        config.setIdType(2);
        config.setLogicDeleteValue("1");
        config.setLogicNotDeleteValue("0");
        config.setDbType("mysql");
        config.setDbColumnUnderline(true);
        config.setSqlInjector(new AutoSqlInjector());
        config.setMetaObjectHandler(new BaseMetaObjectHandler());
        sessionFactory.setGlobalConfig(config);

        sessionFactory.setConfigLocation(resolver.getResource("classpath:mybatis-config.xml"));
        return sessionFactory;
    }

    @Bean
    public MapperScannerConfigurer configurer() {
        MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        configurer.setBasePackage("cn.jeeweb.modules.**.mapper");
        return configurer;
    }

    @Bean
//    @ConditionalOnBean(DataSource.class)
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource")DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public MybatisMapperRefresh mybatisMapperRefresh(@Qualifier("sqlSessionFactory") MybatisSqlSessionFactoryBean sqlSessionFactory) throws Exception{
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        return new MybatisMapperRefresh(resolver.getResources("classpath:/mappings/**/*.xml"),sqlSessionFactory.getObject(),true);
    }

}
