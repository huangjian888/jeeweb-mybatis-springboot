package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.ActivityEntity;
import com.company.shop.sys.service.modules.sys.mapper.ActivityMapper;
import com.company.shop.sys.service.modules.sys.service.IActivityService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("activityServiceService")
public class ActivityServiceServiceImpl extends ServiceImpl<ActivityMapper, ActivityEntity> implements IActivityService {


    @Override
    public List<ActivityEntity> getActivity() {
        return baseMapper.getActivity();
    }
}
