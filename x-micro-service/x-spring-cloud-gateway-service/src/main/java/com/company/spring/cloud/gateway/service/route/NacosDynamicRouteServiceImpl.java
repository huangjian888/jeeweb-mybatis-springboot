package com.company.spring.cloud.gateway.service.route;

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.Executor;

@Component
public class NacosDynamicRouteServiceImpl {
    @Value("${nacos.serveraddr:127.0.0.1:8848}")
    private String nacosServerAddr;
    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;

    @PostConstruct
    public void init(){
        nacosDynamicRouteListener("Dynamic-Gateway-Service","DEFAULT_GROUP");
    }

    /**
     * 监听Nacos Server下发的动态路由配置
     * @param dataId
     * @param group
     * 从Nacos配置中心获取路由信息,返回JSON数据,具体JSON可以查看spring cloud gateway源码
     * {
     * 	"filters": [{
     *         "args":{
     *             "parts":"1"
     *         },
     *         "name":"StripPrefix"
     *     }],
     * 	"id": "dubbo-consumer",
     * 	"order": 0,
     * 	"predicates": [{
     * 		"args": {
     * 			"pattern": "/nacos/**"
     * 		},
     * 		"name": "Path"
     * 	}],
     * 	"uri": "lb://service-gateway-provider"
     * }
     */
    public void nacosDynamicRouteListener(String dataId, String group){
        try {
            ConfigService configService= NacosFactory.createConfigService(nacosServerAddr);
            String config = configService.getConfig(dataId, group, 5000);
            configService.addListener(dataId, group, new Listener()  {
                @Override
                public void receiveConfigInfo(String config) {
                    RouteDefinition definition= JSON.parseObject(config, RouteDefinition.class);
                    dynamicRouteService.update(definition);
                }
                @Override
                public Executor getExecutor() {
                    return null;
                }
            });
        } catch (NacosException e) {
            //todo 提醒:异常自行处理此处省略
        }
    }
}
