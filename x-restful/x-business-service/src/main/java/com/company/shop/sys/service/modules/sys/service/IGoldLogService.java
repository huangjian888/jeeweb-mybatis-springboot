package com.company.shop.sys.service.modules.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;


public interface IGoldLogService {
    int insertLog(GoldLogEntity goldInfo);

    Page<GoldLogEntity> getGoldList(Page<GoldLogEntity> page);
}
