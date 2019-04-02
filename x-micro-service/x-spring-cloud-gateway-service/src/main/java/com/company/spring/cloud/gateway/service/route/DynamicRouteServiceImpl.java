package com.company.spring.cloud.gateway.service.route;

import com.alibaba.fastjson.JSON;
import com.company.spring.cloud.gateway.service.model.GatewayFilterDefinition;
import com.company.spring.cloud.gateway.service.model.GatewayPredicateDefinition;
import com.company.spring.cloud.gateway.service.model.GatewayRouteDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.filter.FilterDefinition;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class DynamicRouteServiceImpl implements ApplicationEventPublisherAware {
    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;
    private ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
    /**
     * 增加路由
     * @param routeDefinition
     * @return
     */
    public String add(RouteDefinition routeDefinition) {
        routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
        return "success";
    }
    /**
     * 更新路由
     * @param routeDefinition
     * @return
     */
    public String update(RouteDefinition routeDefinition) {
        try {
            this.routeDefinitionWriter.delete(Mono.just(routeDefinition.getId()));
        } catch (Exception e) {
            return "update fail,not find route  routeId: "+routeDefinition.getId();
        }
        try {
            routeDefinitionWriter.save(Mono.just(routeDefinition)).subscribe();
            this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this));
            return "success";
        } catch (Exception e) {
            return "update route  fail";
        }
    }
    /**
     * 删除路由
     * @param id
     * @return
     */
    public String delete(String id) {
        try {
            this.routeDefinitionWriter.delete(Mono.just(id));
            return "delete success";
        } catch (Exception e) {
            e.printStackTrace();
            return "delete fail";
        }
    }
}
