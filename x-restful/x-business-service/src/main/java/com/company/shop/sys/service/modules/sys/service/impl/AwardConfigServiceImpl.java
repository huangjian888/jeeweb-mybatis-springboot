package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.StepConfigVo;
import com.company.shop.sys.service.modules.sys.entity.AwardConfigEntity;
import com.company.shop.sys.service.modules.sys.mapper.AwardConfigMapper;
import com.company.shop.sys.service.modules.sys.service.IAwardConfigService;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Transactional
@Service("awardConfigService")
public class AwardConfigServiceImpl extends ServiceImpl<AwardConfigMapper, AwardConfigEntity> implements IAwardConfigService {

    @Override
    public List<AwardConfigEntity> getAwardList() {
        StepConfigVo stepConfigVo = (StepConfigVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getStepConfigKey());

        if (null == stepConfigVo) {
            List<AwardConfigEntity> limitList = baseMapper.getAwardList();
            if (limitList.size() > BusinessConstant.Home.ZERO) {
                stepConfigVo = new StepConfigVo();
                stepConfigVo.setList(limitList);
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getStepConfigKey(), stepConfigVo, BusinessConstant.Redis.EXPIRE_TIME_REDIS_1800);//半小时
                return limitList;
            }
            return null;
        }

        return stepConfigVo.getList();

    }

    @Override
    public AwardConfigEntity getAwardConfigEntity(int order) {

        return baseMapper.getAwardConfigEntity(order);
    }

    /**
     * 更新传order编号，新增不传
     *
     * @param json
     * @return
     */
    @Override
    public boolean updateAwardConfig(JSONObject json) {

        Integer award = json.getIntValue("step");
        String gold = json.getString("gold");
        Integer order = json.getIntValue("order");

        String remarks = json.getString("description");

        if (null == award || TextUtils.isEmpty(gold)) {
            return false;
        }
        if (null == order) {
            AwardConfigEntity awardConfigEntity = new AwardConfigEntity();
            awardConfigEntity.setAward(award);
            awardConfigEntity.setGold(new BigDecimal(gold));
            awardConfigEntity.setRemarks(remarks);
            awardConfigEntity.setCreate_by(BusinessConstant.Common.company_ADMIN);
            awardConfigEntity.setCreate_date(new Date());
            return insertOrUpdate(awardConfigEntity);
        } else {
            AwardConfigEntity awardConfigEntity = getAwardConfigEntity(order);

            if (null == awardConfigEntity) {
                return false;
            }
            awardConfigEntity.setUpdate_by(BusinessConstant.Common.company_ADMIN);
            awardConfigEntity.setUpdate_date(new Date());
            awardConfigEntity.setAward(award);
            awardConfigEntity.setGold(new BigDecimal(gold));
            if (!TextUtils.isEmpty(remarks)) {
                awardConfigEntity.setRemarks(remarks);
            }

            return insertOrUpdate(awardConfigEntity);
        }


    }

}


