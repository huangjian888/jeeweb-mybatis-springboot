package com.company.business.goods.security.authorization;

import com.company.business.goods.common.vo.BaseTomatoVo;
import lombok.Data;

@Data
public class AuthorizationVo extends BaseTomatoVo {
    String openId;
    String sessionKey;
    String token;
    int errorCode;
    String errorMsg;
}
