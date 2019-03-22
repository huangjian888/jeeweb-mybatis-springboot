package com.company.shop.sys.service.support.job;

import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.modules.sys.entity.OrderEntity;
import com.company.shop.sys.service.modules.sys.service.IOrderService;
import com.company.shop.sys.service.utils.DateUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 已收货：在快递发送超过14天后，自动标识为 已收货状态,每天0点执行
 */
@JobHandler(value = "orderJob")
@Component
public class OrderJobHandler extends IJobHandler {

    @Autowired
    private IOrderService orderService;


    @Override
    public ReturnT<String> execute(String s) throws Exception {
        //
        List<OrderEntity> orderList = orderService.getOrderList(BusinessConstant.Order.ORDER_1_SENDED);//获取已发货订单列表
        if (orderList.size() == BusinessConstant.Home.ZERO) {
            return ReturnT.SUCCESS;
        }
        for (OrderEntity orderEntity : orderList) {//已发货14天则会标记当前订单状态为已经收货
            if (DateUtils.daysBetween(orderEntity.getSendTime(), new Date()) >= BusinessConstant.Home.NUMBER_14) {
                orderEntity.setStatus(BusinessConstant.Order.ORDER_2_SUCCESSED);
                orderService.updateOrder(orderEntity);
            }

        }

        return ReturnT.SUCCESS;
    }
}
