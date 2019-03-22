package com.company.business.authorization.security.authorization;

import com.company.business.authorization.common.BaseTomatoVo;
import lombok.Data;

@Data
public class AuthorizationVo extends BaseTomatoVo {
    String openId;
    String sessionKey;
    String token;
    int errorCode;
    String errorMsg;
}
