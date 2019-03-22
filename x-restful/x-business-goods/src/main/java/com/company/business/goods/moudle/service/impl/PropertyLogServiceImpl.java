package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.PropertyLogEntity;
import com.company.business.goods.moudle.mapper.PropertyLogMapper;
import com.company.business.goods.moudle.service.IPropertyLogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("propertyLogService")
@Transactional
public class PropertyLogServiceImpl extends ServiceImpl<PropertyLogMapper, PropertyLogEntity> implements IPropertyLogService {


    @Override
    public boolean insertPropertyLog(PropertyLogEntity propertyLogEntity) {
        return insertOrUpdate(propertyLogEntity);
    }


    @Override
    public List<PropertyLogEntity> getPropertyLogList(String username) {
        return baseMapper.getPropertyLogList(username);
    }

    /**
     * 根据订单号查询当前订单
     *
     * @param order
     * @return
     */
    @Override
    public PropertyLogEntity getPropertyLog(String username,String order) {
        return baseMapper.getPropertyLog(username,order);
    }


}
