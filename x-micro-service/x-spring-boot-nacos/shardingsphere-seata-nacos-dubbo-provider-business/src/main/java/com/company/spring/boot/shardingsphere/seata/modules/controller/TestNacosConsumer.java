package com.company.spring.boot.shardingsphere.seata.modules.controller;

import com.company.spring.boot.shardingsphere.seata.modules.service.IBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("consumer")
public class TestNacosConsumer {

    @Autowired
    IBusinessService businessService;

    @RequestMapping(value = "test",method = RequestMethod.GET)
    @ResponseBody
    public void getCounsumerTest(){
        businessService.purchase();
    }


}
