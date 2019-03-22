package com.company.business.goods.support.xxl;

import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.vo.FormIdVo;
import com.company.business.goods.moudle.service.ITemplateService;
import com.company.business.goods.moudle.service.ITomatoCouponUserService;
import com.company.business.goods.security.user.TomatoUserEntity;
import com.company.business.goods.utils.DateUtils;
import com.company.business.goods.utils.Log;
import com.company.business.goods.utils.RedisCacheUtils;
import com.company.business.goods.utils.RedisKeyUtils;
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
 * 消息推送job
 */
@JobHandler(value = "productPushJob")
@Component
@Data
public class MessageHandler extends IJobHandler {

    @Autowired
    private ITemplateService templateService;

    @Autowired
    private ITomatoCouponUserService tomatoCouponUserService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 获取formId发送对应的消息模板
     *
     * @param s
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String s) throws Exception {
        Date date = new Date();
        try {
            List<TomatoUserEntity> userList = tomatoCouponUserService.getAllUser();
            if (null == userList) {
                return ReturnT.SUCCESS;
            }
            for (TomatoUserEntity user : userList) {
                //fixme 1.根据当前获取的openID查询用户保存在redis中的formId

                FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(user.getUsername()));

                if (null == formIdVo) {
                    Log.e("formId invalid");
                    continue;
                }
                //fixme 2.formId不为空时应判断当前用户的最后一次时间

                Date exitDate = user.getExitTime();
                if (null == exitDate) {//处理可能的前端没有保存到退出时间

                    if (DateUtils.isPushTag(DateUtils.isNotOneDay(user.getLatelyLogin(), date))) {
                        templateService.sendNotifyTemplate(user.getUsername(), formIdVo, null, TomatoConstant.Common.NUMBER_0);
                    }

                } else if (DateUtils.isPushTag(DateUtils.isNotOneDay(exitDate, date))) {
                    templateService.sendNotifyTemplate(user.getUsername(), formIdVo, null, TomatoConstant.Common.NUMBER_0);

                }

            }
        } catch (Exception e) {
            return ReturnT.FAIL;
        }


        return ReturnT.SUCCESS;
    }
}
