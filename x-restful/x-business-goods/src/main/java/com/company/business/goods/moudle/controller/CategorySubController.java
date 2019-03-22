package com.company.business.goods.moudle.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.CategorySubVo;
import com.company.business.goods.moudle.entity.CateGorySubEntity;
import com.company.business.goods.moudle.service.ICateGorySubService;
import com.company.business.goods.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 商品分类控制器
 */
@RestController
public class CategorySubController {

    @Autowired
    private ICateGorySubService cateGorySubService;//商品分类服务

    /**
     * 查询配置的主页类别
     *
     * @return
     */
    @PostMapping(value = "/category/sub")
    public Response getCateGory(HttpServletRequest request, @RequestBody JSONObject json) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");
        int optId = json.getIntValue("opt_id");

        Page pageEntity = new Page<CateGorySubEntity>(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page<CateGorySubEntity> pageList = cateGorySubService.getCateGorySubList(pageEntity, optId);

        List<CateGorySubEntity> list = pageList.getRecords();
        if (list.size()== TomatoConstant.Common.NUMBER_0) {
            return Response.error(ErrorCodeEnum.COUPON2012.code(), ErrorCodeEnum.COUPON2012.msg());
        }

        CategorySubVo categoryVo = new CategorySubVo();
        categoryVo.setList(list);
        categoryVo.setTotal(pageList.getTotal());
        return Response.ok().putObject(categoryVo);

    }

    /**
     * 配置类别接口
     *
     * @return
     */
    @PostMapping(value = "/category/tree")
    public Response putCateGory(@RequestBody JSONObject json) {

        return cateGorySubService.insertCateGorySub(json) ? Response.ok() : Response.error(ErrorCodeEnum.COUPON2013.code(), ErrorCodeEnum.COUPON2013.msg());

    }


}
