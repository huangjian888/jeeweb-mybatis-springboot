package com.company.business.goods.common.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FriendPacketVo extends BaseTomatoVo {
    String invited_user;
    String nick_name;
    String avatar;
    BigDecimal packet_money;

}
