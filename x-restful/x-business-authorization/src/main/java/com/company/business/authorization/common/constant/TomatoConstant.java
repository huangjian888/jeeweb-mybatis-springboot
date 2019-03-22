package com.company.business.authorization.common.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TomatoConstant {

    /**
     * 服务端与微信授权内部异常
     */
    public interface Authorization {
        int WX_USER_INFO_1 = 1;
        String ERROR_WX_AUTHTICATION_EXCEPTION_MESSAGE = "获取微信授权异常";
    }

    public interface Common {
        String RESPONSE = "response";
        int NUMBER_0 = 0;
        int NUMBER_1 = 1;

    }

}
