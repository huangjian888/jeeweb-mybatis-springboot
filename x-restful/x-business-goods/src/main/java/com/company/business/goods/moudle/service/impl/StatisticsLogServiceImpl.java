package com.company.business.goods.moudle.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.StatisticsLogEntity;
import com.company.business.goods.moudle.mapper.StatisticsLogMapper;
import com.company.business.goods.moudle.service.IStatisticsLogService;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service("statisticsLogService")
@Transactional
public class StatisticsLogServiceImpl extends ServiceImpl<StatisticsLogMapper, StatisticsLogEntity> implements IStatisticsLogService {
    @Override
    public boolean insetUpdate(JSONObject json) {
        Date date = new Date();
        String description = json.getString("description");

        int type = json.getIntValue("type");
        String productId = json.getString("productId");
        String view_product_time = json.getString("view_product_time");
        String view_product_stay_time = json.getString("view_product_stay_time");
        Date operation_time = json.getDate("operation_time");

        StatisticsLogEntity statisticsLogEntity = new StatisticsLogEntity();
        statisticsLogEntity.setDescription(description);
        statisticsLogEntity.setType(type);
        statisticsLogEntity.setLog_update_time(date);
        statisticsLogEntity.setUsername(PrincipalUtils.getUsername());
        statisticsLogEntity.setOperation_time(operation_time);
        statisticsLogEntity.setProductId(productId);
        statisticsLogEntity.setView_product_stay_time(view_product_stay_time);
        statisticsLogEntity.setView_product_time(view_product_time);
        //statisticsLogEntity.setVisitCount();--查询当前页面的总日志

        return  insertOrUpdate(statisticsLogEntity);
        /*try {
            RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getStatisticsLogKey(System.currentTimeMillis()), statisticsLogEntity, TomatoConstant.Common.LOG_TIME_REDIS);
            return true;
        } catch (Exception e) {
            return false;
        }*/

    }
}
