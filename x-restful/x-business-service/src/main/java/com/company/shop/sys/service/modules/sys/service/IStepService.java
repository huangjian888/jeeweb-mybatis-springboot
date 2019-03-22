package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.modules.sys.entity.StepEntity;

import java.util.List;

public interface IStepService {
    boolean updateUserStep(StepEntity stepEntity);

    List<StepEntity> getUserStep();

    StepEntity getStepEntity(String id);

    List<StepEntity> getStepBySymbol();
}
