package com.company.shop.sys.service.modules.sys.service;


import com.company.shop.sys.service.common.vo.SignVo;
import com.company.shop.sys.service.common.vo.TaskInfoVo;
import com.company.shop.sys.service.modules.sys.entity.SignConfigEntity;
import com.company.shop.sys.service.modules.sys.entity.SignEntity;

import java.util.List;

public interface ISignService {
    TaskInfoVo onSign();

    /**
     * 设置自动提醒
     *
     * @return
     */
    int setAlert( int category);

    /**
     * 获取档
     *
     * @return
     */
    SignVo getSign();

    /**
     * 查询用户当天签到信息
     *
     * @return
     */
    SignEntity getSignEntity();

    /**
     * 查询已预约签到的用户
     *
     * @return
     */
    List<SignEntity> getBookingSign();

    int updateTable(SignEntity signEntity);

    /**
     * 获取后台签到配置信息
     *
     * @return
     */
    List<SignConfigEntity> getSignConfigurationList();

}
