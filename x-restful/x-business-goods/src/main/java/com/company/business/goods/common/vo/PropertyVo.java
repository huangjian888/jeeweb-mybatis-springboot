package com.company.business.goods.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyVo extends BaseTomatoVo {
    BigDecimal commission_money_able;
    BigDecimal commission_money_back;
    BigDecimal all_commission;
}
