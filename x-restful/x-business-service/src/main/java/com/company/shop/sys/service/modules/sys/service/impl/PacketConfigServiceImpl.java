package com.company.shop.sys.service.modules.sys.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.modules.sys.entity.PacketConfigEntity;
import com.company.shop.sys.service.modules.sys.mapper.PacketConfigMapper;
import com.company.shop.sys.service.modules.sys.service.IPacketConfigService;
import com.company.shop.sys.service.utils.RedisCacheUtils;
import com.company.shop.sys.service.utils.RedisKeyUtils;
import org.apache.http.util.TextUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("packetConfigService")
public class PacketConfigServiceImpl extends ServiceImpl<PacketConfigMapper, PacketConfigEntity> implements IPacketConfigService {


    @Override
    public PacketConfigEntity getPacketConfiguration() {

        PacketConfigEntity packetConfigEntity = (PacketConfigEntity) RedisCacheUtils.getRedisCacheManager().get(RedisKeyUtils.getPacketConfigKey());
        if (null == packetConfigEntity) {
            packetConfigEntity = baseMapper.getPackConfig();
            if (null != packetConfigEntity) {
                RedisCacheUtils.getRedisCacheManager().set(RedisKeyUtils.getPacketConfigKey(), packetConfigEntity, BusinessConstant.Redis.EXPIRE_TIME_REDIS_1800);//半小时
                return packetConfigEntity;
            }
        }
        return packetConfigEntity;
    }

    @Override
    public boolean updatePacketConfig(JSONObject json) {
        Integer award = json.getIntValue("award");
        String description = json.getString("description");
        Integer category = json.getIntValue("category");
        if (null == award) {
            return false;
        }
        PacketConfigEntity packetConfigEntity = baseMapper.getPackConfigUser(BusinessConstant.Common.company_ADMIN);
        if (null == packetConfigEntity) {
            packetConfigEntity = new PacketConfigEntity();
            packetConfigEntity.setCreate_by(BusinessConstant.Common.company_ADMIN);
            packetConfigEntity.setCreate_date(new Date());
            packetConfigEntity.setDescription(description);
            packetConfigEntity.setAward(award);
            return insertOrUpdate(packetConfigEntity);
        } else {
            packetConfigEntity.setUpdate_by(BusinessConstant.Common.company_ADMIN);
            packetConfigEntity.setUpdate_date(new Date());
            packetConfigEntity.setAward(award);

            if (!TextUtils.isEmpty(description)) {
                packetConfigEntity.setDescription(description);
            }
            if (null != category) {
                packetConfigEntity.setCategory(category);
            }
            return insertOrUpdate(packetConfigEntity);
        }

    }
}