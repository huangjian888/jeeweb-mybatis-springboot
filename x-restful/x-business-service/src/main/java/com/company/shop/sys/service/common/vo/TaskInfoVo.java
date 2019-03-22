package com.company.shop.sys.service.common.vo;

import lombok.Data;

@Data
public class TaskInfoVo extends BaseVo {

    //步数奖励
    int award;
    //是否成功
    boolean success;
    String description;

}
