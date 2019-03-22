package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.modules.sys.entity.InviteConfigEntity;
import com.company.shop.sys.service.modules.sys.mapper.InviteConfigMapper;
import com.company.shop.sys.service.modules.sys.service.IInviteConfigService;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("inviteConfigService")
public class InviteConfigServiceImpl extends ServiceImpl<InviteConfigMapper, InviteConfigEntity> implements IInviteConfigService {

    @Override
    public InviteConfigEntity getInviteEntity() {

        InviteConfigEntity inviteConfigEntity = (InviteConfigEntity) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getInviteConfigKey());
        if (null == inviteConfigEntity) {
            inviteConfigEntity = baseMapper.getShareEntity();
            if (null != inviteConfigEntity) {
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getInviteConfigKey(), inviteConfigEntity, BusinessConstant.Redis.EXPIRE_TIME_REDIS_1800);//半小时
                return inviteConfigEntity;
            }
        }

        return inviteConfigEntity;
    }

    @Override
    public boolean updateInviteConfig(JSONObject json) {

        Integer award = json.getIntValue("award");
        String description = json.getString("description");
        Integer category = json.getIntValue("category");
        Integer count = json.getIntValue("count");
        if (null == award) {
            return false;
        }
        InviteConfigEntity inviteConfigEntity = baseMapper.updateInviteConfig(BusinessConstant.Common.company_ADMIN);
        if (null == inviteConfigEntity) {
            inviteConfigEntity = new InviteConfigEntity();
            inviteConfigEntity.setCreate_by(BusinessConstant.Common.company_ADMIN);
            inviteConfigEntity.setCreate_date(new Date());
            inviteConfigEntity.setDescription(description);
            inviteConfigEntity.setPacketCount(count);
            inviteConfigEntity.setAward(award);
            return insertOrUpdate(inviteConfigEntity);
        } else {
            inviteConfigEntity.setUpdate_by(BusinessConstant.Common.company_ADMIN);
            inviteConfigEntity.setUpdate_date(new Date());
            inviteConfigEntity.setAward(award);
            if (null != count) {
                inviteConfigEntity.setPacketCount(count);
            }
            if (!TextUtils.isEmpty(description)) {
                inviteConfigEntity.setDescription(description);
            }
            if (null != category) {
                inviteConfigEntity.setCategory(category);
            }
            return insertOrUpdate(inviteConfigEntity);
        }
    }
}
