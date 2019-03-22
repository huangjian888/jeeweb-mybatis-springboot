package com.company.business.goods.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PropertyTodayVo extends BaseTomatoVo {
    BigDecimal total_property;
    BigDecimal today_property;
}
