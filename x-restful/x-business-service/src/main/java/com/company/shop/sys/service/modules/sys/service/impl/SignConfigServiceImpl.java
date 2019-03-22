package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.SignConfigVo;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import com.company.shop.sys.service.modules.sys.mapper.SignConfigMapper;
import com.company.shop.sys.service.modules.sys.service.ISignConfigService;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("signConfigService")
public class SignConfigServiceImpl extends ServiceImpl<SignConfigMapper, SignConfigEntity> implements ISignConfigService {
    @Override
    public SignConfigEntity getStep(int day) {
        return baseMapper.getStep(day);
    }

    @Override
    public List<SignConfigEntity> getSignConfig() {

        SignConfigVo stepConfigVo = (SignConfigVo) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getSignConfigKey());

        if (null == stepConfigVo) {
            List<SignConfigEntity> list = baseMapper.getSignConfiguration();//fixme 存redis
            if (list.size() > BusinessConstant.Home.ZERO) {
                stepConfigVo = new SignConfigVo();
                stepConfigVo.setList(list);
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getSignConfigKey(), stepConfigVo, BusinessConstant.Redis.EXPIRE_TIME_REDIS_1800);//半小时
                return list;
            }
            return null;
        }

        return stepConfigVo.getList();
    }


    @Override
    public boolean updateSignConfig(JSONObject json) {

        Integer award = json.getIntValue("award");
        String description = json.getString("description");
        Integer category = json.getIntValue("category");
        Integer day = json.getIntValue("day");

        if (null == award || null == day) {
            return false;

        }

        SignConfigEntity signConfigEntity = this.getStep(day);
        if (null == signConfigEntity) {
            signConfigEntity = new SignConfigEntity();
            signConfigEntity.setCreate_by(BusinessConstant.Common.company_ADMIN);
            signConfigEntity.setCreate_date(new Date());
            signConfigEntity.setCountDay(day);
            signConfigEntity.setDescription(description);
            signConfigEntity.setStep(award);
            return insertOrUpdate(signConfigEntity);
        } else {
            signConfigEntity.setUpdate_by(BusinessConstant.Common.company_ADMIN);
            signConfigEntity.setUpdate_date(new Date());
            if (null != category) {
                signConfigEntity.setCategory(category);
            }
            if (null != day) {
                signConfigEntity.setCountDay(day);
            }
            if (null != award) {
                signConfigEntity.setStep(award);
            }
            if (!TextUtils.isEmpty(description)) {
                signConfigEntity.setDescription(description);
            }
            return insertOrUpdate(signConfigEntity);
        }
    }


}
