package com.company.shop.sys.service.common.vo;

import lombok.Data;

@Data
public class SignVo extends BaseVo {

    /**
     * 连续签到天数
     */
    int signCount;

    /**
     * 奖励步数
     */
    int step;
    /**
     * 当天是否已经签过到
     */
    boolean isSign;
}
