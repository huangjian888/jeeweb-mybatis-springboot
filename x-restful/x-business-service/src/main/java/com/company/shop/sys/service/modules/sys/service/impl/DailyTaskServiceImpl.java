package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.DailyTaskEntity;
import com.company.shop.sys.service.modules.sys.mapper.DailyTaskMapper;
import com.company.shop.sys.service.modules.sys.service.IDailyTaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("dailyTask")
public class DailyTaskServiceImpl extends ServiceImpl<DailyTaskMapper, DailyTaskEntity> implements IDailyTaskService {

    @Override
    public List<DailyTaskEntity> getUserTskList() {
        return baseMapper.getUserTskList();
    }
}
