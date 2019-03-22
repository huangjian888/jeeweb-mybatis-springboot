package com.company.business.goods.moudle.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.business.goods.moudle.entity.HardwareEntity;
import com.company.business.goods.moudle.mapper.HardwareMapper;
import com.company.business.goods.moudle.service.IHardWareService;
import com.company.business.goods.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("hardwareService")
@Transactional
public class HardwareServiceImpl extends ServiceImpl<HardwareMapper, HardwareEntity> implements IHardWareService {
    @Override
    public HardwareEntity getHardware() {
        return baseMapper.getHandware(PrincipalUtils.getUsername());
    }

    @Override
    public boolean insertHardware(HardwareEntity hardwareEntity) {
        return insertOrUpdate(hardwareEntity);
    }

}
