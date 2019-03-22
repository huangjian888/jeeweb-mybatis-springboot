package com.company.business.goods.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CommissionVo extends BaseTomatoVo {

    BigDecimal commission_money;//当前提现金额
    Integer counts;//当天提现次数
    Integer max;//当天最多提现金额
    Integer status;//当天是否可以提现

}
