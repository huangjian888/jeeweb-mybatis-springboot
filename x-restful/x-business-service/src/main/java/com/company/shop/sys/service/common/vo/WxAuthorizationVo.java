package com.company.shop.sys.service.common.vo;


import lombok.Data;

@Data
public class WxAuthorizationVo extends BaseVo {
    String openId;
    String sessionKey;
    String token;
    /**
     * 系统内部id
     */
    String userId;
    int errorCode;
    String errorMsg;
}
