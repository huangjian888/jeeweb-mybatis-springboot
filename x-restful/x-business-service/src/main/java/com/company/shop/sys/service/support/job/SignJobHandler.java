package com.company.shop.sys.service.support.job;

import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.FormIdVo;
import com.company.shop.sys.service.modules.sys.entity.SignEntity;
import com.company.shop.sys.service.modules.sys.service.ISignService;
import com.company.shop.sys.service.modules.sys.service.ITemplateService;
import com.company.shop.sys.service.utils.DateUtils;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 预约签到的消息模板,查询已经预约的用户当前是否已经签到
 */
@JobHandler(value = "signJob")
@Component
@Data
public class SignJobHandler extends IJobHandler {
    @Autowired
    private ITemplateService templateService;

    @Autowired
    private ISignService signService;
    @Autowired
    private HttpServletRequest request;

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        try {

            List<SignEntity> list = signService.getBookingSign();
            if (list.size() == BusinessConstant.Message.NUMBER_0) {
                return ReturnT.SUCCESS;
            }

            for (SignEntity signEntity : list) {

                if (DateUtils.daysBetween(signEntity.getSignTime(), new Date()) > BusinessConstant.Message.NUMBER_1) {
                    FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(signEntity.getUserName()));

                    if (null == formIdVo) {
                        continue;
                    }

                    templateService.sendNotifyTemplate(signEntity.getUserName(), formIdVo, null, BusinessConstant.Message.NUMBER_0);

                }


            }
        } catch (Exception e) {

            return ReturnT.FAIL;
        }


        return ReturnT.SUCCESS;
    }


}
