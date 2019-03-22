package com.company.business.goods.moudle.controller;

import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.moudle.service.IPropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyController {

    @Autowired
    private IPropertyService propertyService;

    @GetMapping("/property")
    public Response getProperty() {
        return Response.ok().putObject(propertyService.getProperty());
    }

    @GetMapping("/property/today")
    public Response getPropertyTodayVo() {
        return Response.ok().putObject(propertyService.getPropertyTodayVo());
    }

}
