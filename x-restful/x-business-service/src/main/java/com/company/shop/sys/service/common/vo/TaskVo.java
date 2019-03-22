package com.company.shop.sys.service.common.vo;

import com.company.shop.sys.service.modules.sys.entity.PacketConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.ProcedureConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.InviteConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import lombok.Data;

/**
 * 首页返回给前端做显示的任务数据
 */
@Data
public class TaskVo extends BaseVo {

    //红包配置
    PacketConfigEntity redPacket;
    //签到配置
    SignConfigEntity sign;
    //小程序
    ProcedureConfigEntity procedure;
    //分享
    InviteConfigEntity share;
}
