package com.company.shop.sys.service.modules.sys.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.common.vo.ProductPageVo;
import com.company.shop.sys.service.modules.sys.entity.ProductEntity;
import com.company.shop.sys.service.modules.sys.service.IProductService;
import com.company.shop.sys.service.utils.PageUtils;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 商品控制器
 */
@RequestMapping(value = "/product")
@RestController
public class TomatoProductController {

    @Autowired
    private IProductService productService;

    /**
     * 获取商品详情
     *
     * @param
     * @return
     */

    @PostMapping(value = "/detail")
    public Response getProductDetails(@RequestBody JSONObject json) {
        String productId = json.getString("productId");
        if (TextUtils.isEmpty(productId)) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }
        ProductEntity productEntity = productService.getProductDetails(productId);
        //判断获取的是否为null

        if (null == productEntity) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }

       /* ProductEntity productEntity = productVo.getEntity();
        if (productEntity.getStatus() != MallEnum.ProductStatusEnum.ON_SALE.getCode()) {//fixme 已下架、已删除

            return Response.error(ErrorCodeEnum.PRODUCT3002.code(), ErrorCodeEnum.PRODUCT3002.msg());
        }*/
        return Response.ok().putObject(productEntity);

    }


    /**
     * 根据类别搜索类别下的商品、搜索商品
     *
     * @return
     */
    @PostMapping(value = "/name")
    public Response getProductByName(HttpServletRequest request, @RequestBody JSONObject json) {

        String name = json.getString("name");
        if (TextUtils.isEmpty(name)) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<ProductEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<ProductEntity> pageList = productService.getProductByName(pageEntity, name);
        List<ProductEntity> list = pageList.getRecords();

        if (list.size()==BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.PRODUCT3004.code(), ErrorCodeEnum.PRODUCT3004.msg());
        }
        ProductPageVo productVo = new ProductPageVo();
        productVo.setList(list);
        productVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(productVo);
    }

    /**
     * 根据类别搜索类别下的商品
     *
     * @return
     */
    @PostMapping(value = "/category")
    public Response getProductByCategory(HttpServletRequest request, @RequestBody JSONObject json) {
        String pid = json.getString("pid");

        if (TextUtils.isEmpty(pid)) {
            return Response.error(ErrorCodeEnum.PRODUCT3001.code(), ErrorCodeEnum.PRODUCT3001.msg());
        }
        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page<ProductEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<ProductEntity> pageList = productService.getProductByCategory(pageEntity, pid);
        List<ProductEntity> list = pageList.getRecords();

        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.PRODUCT3004.code(), ErrorCodeEnum.PRODUCT3004.msg());
        }

        ProductPageVo productVo = new ProductPageVo();
        productVo.setList(list);
        productVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(productVo);

    }


    /**
     * 获取推荐商品
     *
     * @return
     */
    @GetMapping(value = "/recommend")
    public Response getRecommend() {

        List<ProductEntity> list = productService.getRecommend();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.PRODUCT3005.code(), ErrorCodeEnum.PRODUCT3005.msg());
        }
        return Response.ok().putList(GlobalConstant.RESPONSE, list);
    }

}
