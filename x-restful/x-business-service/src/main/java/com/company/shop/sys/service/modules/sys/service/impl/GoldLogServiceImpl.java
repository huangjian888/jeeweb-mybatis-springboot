package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;
import com.company.shop.sys.service.modules.sys.mapper.GoldLogMapper;
import com.company.shop.sys.service.modules.sys.service.IGoldLogService;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service("goldLogService")
public class GoldLogServiceImpl extends ServiceImpl<GoldLogMapper, GoldLogEntity> implements IGoldLogService {
    @Override
    public int insertLog(GoldLogEntity goldInfo) {


        return insertOrUpdate(goldInfo) ? 1 : 0;
    }

    /**
     * 获取用户的金币兑换记录
     *
     * @return
     */
    @Override
    public Page<GoldLogEntity> getGoldList(Page<GoldLogEntity> page) {
        return page.setRecords(baseMapper.getGoldList(page, PrincipalUtils.getUsername()));
    }
}
