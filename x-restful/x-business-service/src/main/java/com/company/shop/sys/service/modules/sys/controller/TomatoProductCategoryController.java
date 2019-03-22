package com.company.shop.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.modules.sys.entity.ProductCateGoryEntity;
import com.company.shop.sys.service.modules.sys.service.IProductCateGoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品分类控制器
 */
@RestController
public class TomatoProductCategoryController {

    @Autowired
    private IProductCateGoryService mallGoodsCateGoryService;//商品分类服务

    /**
     * 查询配置的主页类别
     *
     * @return
     */
    @GetMapping(value = "/category")
    public Response getMallCateGory() {
        List<ProductCateGoryEntity> list = mallGoodsCateGoryService.getProductCateGory();

        return list.size() == BusinessConstant.Home.ZERO ? Response.error(ErrorCodeEnum.TASK1055.code(), ErrorCodeEnum.TASK1055.msg()) : Response.ok().putList(GlobalConstant.RESPONSE, list);
    }


}
