package com.company.manerger.sys.common.lock.zookeeper.config;

import com.company.manerger.sys.common.lock.LockExecutor;
import com.company.manerger.sys.common.lock.zookeeper.condition.ZookeeperLockCondition;
import com.company.manerger.sys.common.lock.zookeeper.curator.handler.CuratorHandler;
import com.company.manerger.sys.common.lock.zookeeper.curator.handler.CuratorHandlerImpl;
import com.company.manerger.sys.common.lock.zookeeper.impl.ZookeeperLockExecutorImpl;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZookeeperLockConfig {
    @Bean
    @Conditional(ZookeeperLockCondition.class)
    public CuratorHandler curatorHandler(){
        return new CuratorHandlerImpl();
    }

    @Bean(name = "zookeeperLockExecutor")
    @Conditional(ZookeeperLockCondition.class)
    public LockExecutor<InterProcessMutex> zookeeperLockExecutor(){
        return new ZookeeperLockExecutorImpl();
    }
}
