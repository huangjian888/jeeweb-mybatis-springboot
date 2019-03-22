package com.company.manerger.sys.common.idgenerator.zookeeper.config;

import com.company.manerger.sys.common.idgenerator.zookeeper.ZookeeperIdGenerator;
import com.company.manerger.sys.common.idgenerator.zookeeper.condition.ZookeeperIdGeneratorCondition;
import com.company.manerger.sys.common.idgenerator.zookeeper.curator.handler.CuratorHandler;
import com.company.manerger.sys.common.idgenerator.zookeeper.curator.handler.CuratorHandlerImpl;
import com.company.manerger.sys.common.idgenerator.zookeeper.impl.ZookeeperIdGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperIdGeneratorConfig {
    @Bean
    @Conditional(ZookeeperIdGeneratorCondition.class)
    public ZookeeperIdGenerator zookeeperIdGenerator() {
        return new ZookeeperIdGeneratorImpl();
    }

    @Bean
    @Conditional(ZookeeperIdGeneratorCondition.class)
    public CuratorHandler curatorHandler(){
        return new CuratorHandlerImpl();
    }
}
