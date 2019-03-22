package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.modules.sys.entity.ProcedureConfigEntity;
import com.company.shop.sys.service.modules.sys.mapper.ProcedureConfigMapper;
import com.company.shop.sys.service.modules.sys.service.IProcedureConfigService;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("procedureConfigService")
public class ProcedureConfigServiceImpl extends ServiceImpl<ProcedureConfigMapper, ProcedureConfigEntity> implements IProcedureConfigService {


    @Override
    public ProcedureConfigEntity getProcedureEntity() {

        ProcedureConfigEntity procedureConfigEntity = (ProcedureConfigEntity) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getProcedureConfigKey());
        if (null == procedureConfigEntity) {
            procedureConfigEntity = baseMapper.getProcedureEntity();
            if (null != procedureConfigEntity) {
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getProcedureConfigKey(), procedureConfigEntity, BusinessConstant.Redis.EXPIRE_TIME_REDIS_1800);//半小时
                return procedureConfigEntity;
            }
        }
        return procedureConfigEntity;

    }

    @Override
    public boolean updateProcedureConfig(JSONObject json) {
        Integer award = json.getIntValue("award");
        String description = json.getString("description");
        Integer category = json.getIntValue("category");
        if (null == award) {
            return false;
        }
        ProcedureConfigEntity procedureConfigEntity = baseMapper.getProcedure(BusinessConstant.Common.company_ADMIN);

        if (null == procedureConfigEntity) {
            procedureConfigEntity = new ProcedureConfigEntity();
            procedureConfigEntity.setAward(award);
            procedureConfigEntity.setCreate_by(BusinessConstant.Common.company_ADMIN);
            procedureConfigEntity.setCreate_date(new Date());
            procedureConfigEntity.setDescription(description);
            return insertOrUpdate(procedureConfigEntity);

        } else {
            procedureConfigEntity.setUpdate_date(new Date());
            procedureConfigEntity.setUpdate_by(BusinessConstant.Common.company_ADMIN);
            procedureConfigEntity.setAward(award);
            if (!TextUtils.isEmpty(description)) {
                procedureConfigEntity.setDescription(description);
            }
            if (null != category) {
                procedureConfigEntity.setCategory(category);
            }
            return insertOrUpdate(procedureConfigEntity);
        }
    }

}