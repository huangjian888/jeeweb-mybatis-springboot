package com.company.business.goods.moudle.service;

import com.company.business.goods.common.vo.PropertyTodayVo;
import com.company.business.goods.common.vo.PropertyVo;
import com.company.business.goods.moudle.entity.PropertyEntity;

import java.math.BigDecimal;

/**
 * 用户资产服务接口
 */
public interface IPropertyService {

    PropertyVo getProperty();

    PropertyEntity getProperEntity(String username);

    boolean insertProperty(PropertyEntity propertyEntity);

    boolean updateProperty(String username,BigDecimal commissionAble, BigDecimal commissionBack);

    PropertyTodayVo getPropertyTodayVo();
}
