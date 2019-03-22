package com.company.business.goods.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InviteVo extends BaseTomatoVo {

    BigDecimal bigDecimal;
    String inviteUser;
    String username;
}
