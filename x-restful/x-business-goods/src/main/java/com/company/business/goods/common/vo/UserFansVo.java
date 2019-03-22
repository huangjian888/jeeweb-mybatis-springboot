package com.company.business.goods.common.vo;

import com.company.business.goods.security.user.TomatoUserEntity;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserFansVo extends BaseTomatoVo {
    TomatoUserEntity userInfo;
    Integer exitDay;
    BigDecimal money;
    Integer status;//1未下单

}
