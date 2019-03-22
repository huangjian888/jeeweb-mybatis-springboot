package com.company.business.goods.moudle.service;

import com.company.business.goods.moudle.entity.HardwareEntity;

public interface IHardWareService {


    HardwareEntity getHardware();

    boolean insertHardware(HardwareEntity hardwareEntity);
}
