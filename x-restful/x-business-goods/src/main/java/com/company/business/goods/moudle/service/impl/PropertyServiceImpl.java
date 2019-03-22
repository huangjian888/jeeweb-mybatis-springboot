package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.common.constant.TomatoConstant;
import com.company.business.goods.common.vo.PropertyTodayVo;
import com.company.business.goods.common.vo.PropertyVo;
import com.company.business.goods.moudle.entity.PropertyEntity;
import com.company.business.goods.moudle.entity.PropertyLogEntity;
import com.company.business.goods.moudle.mapper.PropertyMapper;
import com.company.business.goods.moudle.service.IPropertyLogService;
import com.company.business.goods.moudle.service.IPropertyService;
import com.company.business.goods.utils.BigDecimalUtils;
import com.company.business.goods.utils.DateUtils;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service("propertyService")
@Transactional
public class PropertyServiceImpl extends ServiceImpl<PropertyMapper, PropertyEntity> implements IPropertyService {
    private static BigDecimal bigDecimal = new BigDecimal("0.00");

    @Autowired
    private IPropertyLogService propertyLogService;

    @Override
    public PropertyVo getProperty() {
        PropertyVo propertyVo = new PropertyVo();
        PropertyEntity propertyEntity = baseMapper.getProperty(PrincipalUtils.getUsername());
        if (null == propertyEntity) {
            propertyVo.setCommission_money_able(bigDecimal);
            propertyVo.setCommission_money_back(bigDecimal);
            propertyVo.setAll_commission(bigDecimal);
            return propertyVo;
        }

        BigDecimal commissionBack = propertyEntity.getCommission_money_back();
        BigDecimal commissionAble = propertyEntity.getCommission_money_able();

        propertyVo.setCommission_money_back(commissionBack);
        propertyVo.setCommission_money_able(commissionAble);

        propertyVo.setAll_commission(BigDecimalUtils.addBig(commissionBack, commissionAble));
        return propertyVo;
    }


    @Override
    public PropertyEntity getProperEntity(String username) {
        return baseMapper.getProperty(username);
    }


    @Override
    public boolean insertProperty(PropertyEntity propertyEntity) {
        return insertOrUpdate(propertyEntity);
    }

    /**
     * 更新用户的个人财产
     *
     * @param username
     * @param commissionAble
     * @param commissionBack
     * @return
     */
    @Override
    public boolean updateProperty(String username, BigDecimal commissionAble, BigDecimal commissionBack) {

        if (null == commissionAble) {
            return baseMapper.updatePropertyNoAble(username, commissionBack.doubleValue());
        } else {
            return baseMapper.updateProperty(username, commissionAble.doubleValue(), commissionBack.doubleValue());

        }
    }


    @Override
    public PropertyTodayVo getPropertyTodayVo() {
        //fixme 查询用户的资产表
        PropertyEntity propertyEntity = baseMapper.getProperty(PrincipalUtils.getUsername());

        PropertyTodayVo propertyTodayVo = new PropertyTodayVo();
        if (null == propertyEntity) {

            propertyTodayVo.setTotal_property(bigDecimal);
            propertyTodayVo.setToday_property(bigDecimal);
            return propertyTodayVo;
        }

        propertyTodayVo.setTotal_property(BigDecimalUtils.addBig(propertyEntity.getCommission_money_able(), propertyEntity.getCommission_money_back()));
        //今日收益--查找用户收益日志表中数据
        List<PropertyLogEntity> list = propertyLogService.getPropertyLogList(PrincipalUtils.getUsername());
        if (list.size() == TomatoConstant.Common.NUMBER_0) {
            propertyTodayVo.setToday_property(bigDecimal);
            return propertyTodayVo;
        }

        double today_property = 0;
        Date now = new Date();
        for (PropertyLogEntity propertyLogEntity : list) {

            if (DateUtils.isNotOneDay(propertyLogEntity.getCommission_date(), now) == TomatoConstant.Common.NUMBER_0) {
                if (propertyLogEntity.getType() == TomatoConstant.Common.NUMBER_1) {//当天退货的不加上

                    today_property += propertyLogEntity.getCommission_money().doubleValue();

                }
            }

        }


        BigDecimal today = BigDecimalUtils.mul(today_property == 0 ? bigDecimal.doubleValue() : today_property, TomatoConstant.Common.NUMBER_1);
        propertyTodayVo.setToday_property(today);

        return propertyTodayVo;
    }
}
