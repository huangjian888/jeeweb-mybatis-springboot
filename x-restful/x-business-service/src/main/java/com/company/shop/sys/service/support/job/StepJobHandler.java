package com.company.shop.sys.service.support.job;

import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.FormIdVo;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.modules.sys.service.ITemplateService;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查询全天都未兑换步数的用户，对其进行消息推送，通知用户进行步数兑换操作,通过用户表中的today_gold判断
 */
@JobHandler(value = "stepJob")
@Component
public class StepJobHandler extends IJobHandler {

    @Autowired
    private IStoreUserService storeUserService;

    @Autowired
    private ITemplateService templateService;

    @Override
    public ReturnT<String> execute(String s) throws Exception {

        List<StoreUserEntity> list = storeUserService.getUserListGold();
        if (list.size() == BusinessConstant.Message.NUMBER_0) {
            return ReturnT.SUCCESS;
        }
        for (StoreUserEntity storeUserEntity : list) {

            FormIdVo formIdVo = (FormIdVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getFormIdKey(storeUserEntity.getUsername()));

            if (null == formIdVo) {
                continue;
            }

            templateService.sendNotifyTemplate(storeUserEntity.getUsername(), formIdVo, null, BusinessConstant.Message.NUMBER_1);
        }

        return ReturnT.SUCCESS;
    }
}
