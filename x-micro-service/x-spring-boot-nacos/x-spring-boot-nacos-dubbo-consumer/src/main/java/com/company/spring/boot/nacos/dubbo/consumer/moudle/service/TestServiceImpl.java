package com.company.spring.boot.nacos.dubbo.consumer.moudle.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.company.spring.boot.nacos.dubbo.facade.service.ITest;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ITest {

    @Override
    @SentinelResource(value = "test",blockHandler = "blockHandlerException",fallback = "fallbackException")
    public String test() {
        return "正常数据";
    }

    public String blockHandlerException(BlockException exception){
        return "BlockException...";
    }

    public String fallbackException(){
        return "fallbackException...";
    }
}
