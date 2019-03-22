package com.company.shop.sys.service.modules.sys.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.company.shop.sys.service.common.constant.BusinessConstant;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.*;
import com.company.shop.sys.service.modules.sys.mapper.InviteAwardMapper;
import com.company.shop.sys.service.modules.sys.service.IInviteAwardService;
import com.company.shop.sys.service.modules.sys.service.IInviteConfigService;
import com.company.shop.sys.service.modules.sys.service.ILogService;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.utils.PrincipalUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("inviteAwardService")
public class InviteAwardServiceImpl extends ServiceImpl<InviteAwardMapper, InviteAwardEntity> implements IInviteAwardService {
    @Autowired
    private ILogService logService;
    @Autowired
    private IInviteConfigService inviteConfigService;
    @Autowired
    private IStoreUserService storeUserService;

    @Override
    public boolean insertInviteAward(InviteAwardEntity inviteAwardEntity) {
        return insertOrUpdate(inviteAwardEntity);
    }

    @Override
    public List<InviteAwardEntity> getInviteAward() {
        return baseMapper.getInviteAward(PrincipalUtils.getUsername());
    }

    @Override
    public List<InviteAwardEntity> getInviteAward(String username) {

        return baseMapper.getInviteAward(username);
    }


    /**
     * 点击领取好友邀请奖励
     *
     * @param id
     * @return
     */
    @Override
    public TaskInfoVo getAward(String id) {
        Date date = new Date();
        TaskInfoVo taskInfoVo = null;
        InviteAwardEntity inviteAwardEntity = baseMapper.getAward(id);

        if (null != inviteAwardEntity) {
            //已领取更新当前状态
            inviteAwardEntity.setStatus(BusinessConstant.Home.ONE);
            insertOrUpdate(inviteAwardEntity);
            //插入用户日志
            InviteConfigEntity inviteConfigEntity = inviteConfigService.getInviteEntity();
            updateLog(date, inviteConfigEntity);
            //更新用户表
            StoreUserEntity storeUserEntity = storeUserService.getUserInfo();
            storeUserEntity.setStep(storeUserEntity.getStep() + inviteAwardEntity.getAward());
            storeUserService.insertOrUpdate(storeUserEntity);
            //构造返回数据
            taskInfoVo = new TaskInfoVo();
            taskInfoVo.setAward(inviteAwardEntity.getAward());
            taskInfoVo.setSuccess(true);
        }

        return taskInfoVo;
    }

    @Override
    public int deleteInviteAward(String id) {
        return baseMapper.deleteInviteAward(id);
    }

    private void updateLog(Date date, InviteConfigEntity inviteConfigEntity) {

        LogEntity logEntity = new LogEntity();

        logEntity.setUserName(PrincipalUtils.getUsername());
        logEntity.setSignTime(date);//当前时间
        logEntity.setAward(inviteConfigEntity.getAward());//服务端配置的奖励
        logEntity.setCategory(inviteConfigEntity.getCategory());
        logEntity.setCategoryName(inviteConfigEntity.getDescription());

        logService.insertLog(logEntity);//向日志表中插入用户签到数据
    }

}
