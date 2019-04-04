package com.company.spring.boot.nacos.dubbo.consumer.moudle.mock;

import com.company.spring.boot.nacos.dubbo.facade.service.INacos;

public class INacosMock implements INacos {
    @Override
    public String test() {
        return "RpcException";
    }
}
