package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.LogEntity;
import com.company.shop.sys.service.modules.sys.mapper.LogMapper;
import com.company.shop.sys.service.modules.sys.service.ILogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service("logService")
public class LogServiceImpl extends ServiceImpl<LogMapper, LogEntity> implements ILogService {


    public int insertLog(LogEntity logEntity) {


        return insertOrUpdate(logEntity) ? 1 : 0;
    }
}
