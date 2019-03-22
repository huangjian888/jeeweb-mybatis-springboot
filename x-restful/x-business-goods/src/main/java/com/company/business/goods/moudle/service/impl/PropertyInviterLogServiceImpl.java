package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.PropertyInviterLogEntity;
import com.company.business.goods.moudle.mapper.PropertyInviterLogMapper;
import com.company.business.goods.moudle.service.IPropertyInviterLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("propertyInviterLogService")
@Transactional
public class PropertyInviterLogServiceImpl extends ServiceImpl<PropertyInviterLogMapper, PropertyInviterLogEntity> implements IPropertyInviterLogService {


    @Override
    public boolean insertPropertyLog(PropertyInviterLogEntity propertyInviterLogEntity) {
        return insertOrUpdate(propertyInviterLogEntity);
    }

    @Override
    public PropertyInviterLogEntity getPropertyInviterLog(String order) {
        return baseMapper.getPropertyInviterLog(order);
    }


    @Override
    public List<PropertyInviterLogEntity> getPropertyInviterList(String inviter_user, String invited_user) {
        return baseMapper.getPropertyInviterList(inviter_user,invited_user);
    }
}
