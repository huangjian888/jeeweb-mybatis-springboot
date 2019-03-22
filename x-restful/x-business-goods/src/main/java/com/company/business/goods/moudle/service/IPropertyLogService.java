package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.PropertyLogEntity;

import java.util.List;

public interface IPropertyLogService {
    boolean insertPropertyLog(PropertyLogEntity propertyLogEntity);

    List<PropertyLogEntity> getPropertyLogList(String username);

    PropertyLogEntity getPropertyLog(String username,String order);
}
