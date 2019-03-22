package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.PropertyInviterLogEntity;

import java.util.List;

public interface IPropertyInviterLogService {
    boolean insertPropertyLog(PropertyInviterLogEntity propertyInviterLogEntity);

    PropertyInviterLogEntity getPropertyInviterLog(String order);

    List<PropertyInviterLogEntity> getPropertyInviterList(String inviter_user, String invited_user);
}
