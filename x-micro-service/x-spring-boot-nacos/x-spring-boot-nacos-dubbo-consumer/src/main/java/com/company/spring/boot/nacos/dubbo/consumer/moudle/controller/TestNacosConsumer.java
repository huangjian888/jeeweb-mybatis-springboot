package com.company.spring.boot.nacos.dubbo.consumer.moudle.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.spring.boot.nacos.dubbo.facade.service.INacos;
import com.company.spring.boot.nacos.dubbo.facade.service.ITest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("consumer")
public class TestNacosConsumer {
    @Reference(group="test",check = false,mock = "com.company.spring.boot.nacos.dubbo.consumer.moudle.mock.INacosMock")
    private INacos nacos;
    @Autowired
    private ITest test;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public String getCounsumerTest(){
        return nacos.test();
    }

    @RequestMapping(value = "test1",method = RequestMethod.GET)
    @ResponseBody
    public String test(){
        return test.test();
    }

}
