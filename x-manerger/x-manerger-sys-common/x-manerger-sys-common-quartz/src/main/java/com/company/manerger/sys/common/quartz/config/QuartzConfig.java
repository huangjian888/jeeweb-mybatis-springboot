package com.company.manerger.sys.common.quartz.config;

import com.company.manerger.sys.common.quartz.QuartzManager;
import com.company.manerger.sys.common.quartz.callback.QuartzInitCallback;
import com.company.manerger.sys.common.utils.SpringContextHolder;
import com.company.manerger.sys.common.utils.StringUtils;
import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

/**
 * @description: 定时任务配置
 */
@Configuration
@AutoConfigureAfter({ DataSourceAutoConfiguration.class })
public class QuartzConfig implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // 任务初始化
        String openCluster=env.getProperty("quartz.open-cluster");
        if (StringUtils.isEmpty(openCluster)|| !Boolean.valueOf(openCluster)) {
            Map<String, QuartzInitCallback> quartzInitCallbackBeans = SpringContextHolder.getApplicationContext().getBeansOfType(QuartzInitCallback.class);
            for (QuartzInitCallback quartzInitCallback : quartzInitCallbackBeans.values()) {
                try {
                    quartzInitCallback.initSchedule();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Autowired
    private Environment env;

    @Bean
    public QuartzManager quartzManager(){
        QuartzManager  quartzManager = new QuartzManager();
        return quartzManager;
    }

    @Bean
    @ConditionalOnProperty(name = "quartz.open-cluster", havingValue = "true")
    @DependsOn({"springContextHolder","dataSource"})
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource) throws IOException {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        String dataSourceBean=env.getProperty("quartz.data-source");
        if (StringUtils.isEmpty(dataSourceBean)||dataSourceBean.equals("default")) {
            schedulerFactoryBean.setDataSource(dataSource);
        }else{
           /* dataSource = SpringContextHolder.getBean(dataSourceBean);
            if (dataSource != null) {
                schedulerFactoryBean.setDataSource(dataSource);
            }*/
        }
        schedulerFactoryBean.setQuartzProperties(quartzProperties());
        schedulerFactoryBean.setSchedulerName("CompanyWebScheduler");
        // 启动时延期1秒开始任务
        schedulerFactoryBean.setStartupDelay(1);
        // Job接受applicationContext的成员变量名
        schedulerFactoryBean.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 可选，QuartzScheduler
        // 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        schedulerFactoryBean.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        schedulerFactoryBean.setAutoStartup(true);
        // schedulerFactoryBean.setJobFactory(tioadJobFactory);
        return schedulerFactoryBean;
    }

    @Bean
    @ConditionalOnProperty(name = "quartz.open-cluster", havingValue = "true")
    public Properties quartzProperties() throws IOException {
        String configLocation=env.getProperty("quartz.config-location");
        if (StringUtils.isEmpty(configLocation)){
            configLocation = "/quartz/quartz.properties";
        }
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource(configLocation));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    /*
     * quartz初始化监听器
     */
    @Bean
    @ConditionalOnProperty(name = "quartz.open-cluster", havingValue = "true")
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /*
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    //@Bean
    //@ConditionalOnProperty(name = "quartz.open-cluster", havingValue = "true")
    public Scheduler scheduler(SchedulerFactoryBean schedulerFactoryBean) throws IOException {
        return schedulerFactoryBean.getScheduler();
    }

}