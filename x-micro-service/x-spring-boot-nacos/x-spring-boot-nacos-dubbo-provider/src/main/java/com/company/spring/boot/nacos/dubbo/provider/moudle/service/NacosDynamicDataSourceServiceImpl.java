package com.company.spring.boot.nacos.dubbo.provider.moudle.service;

import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;

@Component
public class NacosDynamicDataSourceServiceImpl {
    @Value("${nacos.serveraddr:127.0.0.1:8848}")
    private String nacosServerAddr;
    @Value("${spring.application.name}")
    private String appName;

    @PostConstruct
    public void init(){
        nacosDynamicDataSourceFlowRuleListener(appName + "-flow-rules","SENTINEL_GROUP");
    }

    public void nacosDynamicDataSourceFlowRuleListener(String dataId, String group){
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(nacosServerAddr,group,dataId,
                source->JSON.parseObject(source,new TypeReference<List<FlowRule>>(){})
        );
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }


    public static void main(String[] args) {
        FlowRule flowRule = new FlowRule();
        flowRule.setResource("com.company.spring.boot.nacos.dubbo.facade.service.INacos");
        flowRule.setCount(5);
        flowRule.setLimitApp("default");
        System.out.println(JSON.toJSONString(flowRule));
    }
}
