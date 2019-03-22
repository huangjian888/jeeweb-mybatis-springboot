package com.company.business.goods.moudle.controller;


import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.base.http.Response;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.emum.ErrorCodeEnum;
import com.company.business.goods.common.vo.PacketUserBuyVo;
import com.company.business.goods.moudle.entity.PacketUserBuyEntity;
import com.company.business.goods.moudle.service.IPacketInviteLogService;
import com.company.business.goods.moudle.service.IPacketUserBuyService;
import com.company.business.goods.utils.PageUtils;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/packet")
public class PacketFriendController {
    @Autowired
    private IPacketInviteLogService packetInviteLogService;
    @Autowired
    private IPacketUserBuyService packetUserBuyService;//用户的购买表情况

    @GetMapping("/friend")
    public Response getFriendVo(HttpServletRequest request) {

        String page = request.getParameter("page");
        String pageSize = request.getParameter("pageSize");

        Page pageEntity = new Page(PageUtils.getPage(page), PageUtils.getPageSize(pageSize));

        Page pageList = packetInviteLogService.getFriendPacketVoList(pageEntity);

        List list = pageList.getRecords();
        if (list.size() == TomatoConstant.Common.NUMBER_0) {
            return Response.error(ErrorCodeEnum.COUPON2036.code(), ErrorCodeEnum.COUPON2036.msg());
        }

        return Response.ok().putList(TomatoConstant.Common.RESPONSE, list);
    }

    @GetMapping("/status")
    public Response getUserBuy() {
        PacketUserBuyEntity packetUserBuyEntity = packetUserBuyService.getPacketUserBuy(PrincipalUtils.getUsername());
        PacketUserBuyVo packetUserBuyVo = new PacketUserBuyVo();
        if (null == packetUserBuyEntity) {
            packetUserBuyVo.setStatus(TomatoConstant.Common.NUMBER_1);
        } else {
            packetUserBuyVo.setStatus(TomatoConstant.Common.NUMBER_0);
        }
        return Response.ok().putObject(packetUserBuyVo);
    }
}
