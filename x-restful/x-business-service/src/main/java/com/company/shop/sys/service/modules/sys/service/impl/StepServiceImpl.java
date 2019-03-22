package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.StepEntity;
import com.company.shop.sys.service.modules.sys.mapper.StepMapper;
import com.company.shop.sys.service.modules.sys.service.IStepService;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("stepService")
public class StepServiceImpl extends ServiceImpl<StepMapper, StepEntity> implements IStepService {

    @Override
    public boolean updateUserStep(StepEntity stepEntity) {

        return insertOrUpdate(stepEntity);
    }

    @Override
    public List<StepEntity> getUserStep() {

        return baseMapper.getUserStep(PrincipalUtils.getUsername());
    }

    @Override
    public StepEntity getStepEntity(String id) {
        return baseMapper.getStepEntity(id);
    }


    @Override
    public List<StepEntity> getStepBySymbol() {
        return null;
    }


}
