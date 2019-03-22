package com.company.shop.sys.service.modules.sys.service;

import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.InviteAwardEntity;

import java.util.List;

public interface IInviteAwardService {
    boolean insertInviteAward(InviteAwardEntity inviteAwardEntity);

    List<InviteAwardEntity> getInviteAward();

    List<InviteAwardEntity> getInviteAward(String username);

    TaskInfoVo getAward(String id);

    int deleteInviteAward(String id);

}
