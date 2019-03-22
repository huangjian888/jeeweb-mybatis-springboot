package com.company.shop.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.modules.sys.entity.ActivityEntity;
import com.company.shop.sys.service.modules.sys.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 活动配置控制器
 */

@RestController
public class TomatoActivityController extends BaseBeanController<ActivityEntity> {
    @Autowired
    private IActivityService mallGoodsBannerService;//banner服务

    /**
     * 查询主页banner配置
     *
     * @return
     */

    @GetMapping(value = "/activity")
    public Response getMallBanner() {
        List<ActivityEntity> list = mallGoodsBannerService.getActivity();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.TASK1055.code(), ErrorCodeEnum.TASK1055.msg());
        }
        return Response.ok().putList(GlobalConstant.RESPONSE, list);
    }

}
