package com.company.manerger.sys.service.config;

import com.company.manerger.sys.common.base.disruptor.TaskHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description: 公用任务配置
 */
@Configuration
public class TaskConfig {

    @Bean
    public TaskHelper taskHelper(){
        TaskHelper taskHelper=  new TaskHelper();
        taskHelper.setHandlerCount(1);
        taskHelper.setBufferSize(1024);
        return taskHelper;
    }

}
