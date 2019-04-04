package com.company.spring.boot.nacos.dubbo.consumer.moudle.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.company.spring.boot.nacos.dubbo.facade.service.INacos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("consumer")
public class TestNacosConsumer {
    @Reference(group="test",check = false)
    private INacos nacos;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public String getCounsumerTest(){
        return nacos.test();
    }

}
