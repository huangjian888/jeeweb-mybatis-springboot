package com.company.business.goods.support.xxl;

import com.alibaba.fastjson.JSON;
import com.company.business.goods.moudle.service.IOrderService;
import com.company.business.goods.moudle.service.IPddService;
import com.company.business.goods.utils.Log;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.Data;
import org.apache.http.util.TextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 每天定时的去获取前一天的订单信息,具体执行时间需要设定
 */
@JobHandler(value = "orderJob")
@Component
@Data
public class OrderHandler extends IJobHandler {

    @Autowired
    private IPddService pddService;
    @Autowired
    private IOrderService orderService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        Log.i("enter xxl-job order job");

        try {
            String response = pddService.getOrder();
            if (!TextUtils.isEmpty(response)) {
                //fixme 更新数据库信息
                boolean flag = orderService.insertOrder(JSON.parseObject(response));
                if (!flag) {
                    Log.i("insert sql error");
                }
            }

        } catch (Exception e) {
            return ReturnT.FAIL;
        }

        return ReturnT.SUCCESS;
    }
}
