package com.company.spring.boot.nacos.dubbo.provider.moudle.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.company.spring.boot.nacos.dubbo.facade.service.INacos;

@Service(group="test")
public class NacosImpl implements INacos {
    @Override
    public String test() {
        return "test success";
    }
}
