package com.company.spring.cloud.gateway.service.controller;

import com.company.spring.cloud.gateway.service.model.GatewayPredicateDefinition;
import com.company.spring.cloud.gateway.service.model.GatewayRouteDefinition;
import com.company.spring.cloud.gateway.service.route.DynamicRouteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.handler.predicate.PredicateDefinition;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * 动态路由设置CRUD,需要进行鉴权操作才能访问以下接口
 */
/*
@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private DynamicRouteServiceImpl dynamicRouteService;


    @PostMapping("/add")
    public String add(@RequestBody GatewayRouteDefinition gatewayRouteDefinition) {
        try {
            RouteDefinition definition = assembleRouteDefinition(gatewayRouteDefinition);
            return this.dynamicRouteService.add(definition);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "succss";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        return this.dynamicRouteService.delete(id);
    }

    @PostMapping("/update")
    public String update(@RequestBody GatewayRouteDefinition gatewayRouteDefinition) {
        RouteDefinition definition = assembleRouteDefinition(gatewayRouteDefinition);
        return this.dynamicRouteService.update(definition);
    }

    private RouteDefinition assembleRouteDefinition(GatewayRouteDefinition gatewayRouteDefinition) {
        RouteDefinition definition = new RouteDefinition();
        List<PredicateDefinition> pdList=new ArrayList<>();
        definition.setId(gatewayRouteDefinition.getId());
        List<GatewayPredicateDefinition> gatewayPredicateDefinitionList=gatewayRouteDefinition.getPredicates();
        for (GatewayPredicateDefinition gpDefinition: gatewayPredicateDefinitionList) {
            PredicateDefinition predicate = new PredicateDefinition();
            predicate.setArgs(gpDefinition.getArgs());
            predicate.setName(gpDefinition.getName());
            pdList.add(predicate);
        }
        definition.setPredicates(pdList);
        URI uri = UriComponentsBuilder.fromHttpUrl(gatewayRouteDefinition.getUri()).build().toUri();
        definition.setUri(uri);
        return definition;
    }

}
*/
