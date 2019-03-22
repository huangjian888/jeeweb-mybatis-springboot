package com.company.shop.sys.service.modules.sys.controller;

import com.company.manerger.sys.common.base.http.Response;
import com.company.manerger.sys.common.base.mvc.controller.BaseBeanController;
import com.company.shop.sys.service.common.bean.ErrorCodeEnum;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.constant.GlobalConstant;
import com.company.shop.sys.service.modules.sys.entity.InviteAwardEntity;
import com.company.shop.sys.service.modules.sys.service.IInviteAwardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/inviter")
public class TomatoInviteAwardController extends BaseBeanController<InviteAwardEntity> {

    @Autowired
    private IInviteAwardService iInviteAwardService;

    @GetMapping("/award")
    public Response getInviteAwardList() {

        List<InviteAwardEntity> list = iInviteAwardService.getInviteAward();
        if (list.size() == BusinessConstant.Home.ZERO) {
            return Response.error(ErrorCodeEnum.TASK1058.code(), ErrorCodeEnum.TASK1058.msg());
        }
        return Response.ok().putList(GlobalConstant.RESPONSE, list);
    }


}
