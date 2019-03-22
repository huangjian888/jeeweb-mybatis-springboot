package com.company.business.goods.common.vo;

import lombok.Data;


@Data
public class PacketVo extends BaseTomatoVo {
    double money;//可提现红包金额
    int day;//剩余的可提现天数
}
