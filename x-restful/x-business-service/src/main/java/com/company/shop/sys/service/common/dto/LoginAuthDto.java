package com.company.shop.sys.service.common.dto;

import lombok.Data;

/**
 * 此类用作存储全局的登录者信息
 */
@Data
public class LoginAuthDto {
    private static final long serialVersionUID = -1137852221455042256L;
    private Long userId;
    private String loginName;
    private String userName;
    private Long groupId;
    private String groupName;

    public LoginAuthDto() {
    }


    public LoginAuthDto(Long userId, String loginName, String userName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
    }

    public LoginAuthDto(Long userId, String loginName, String userName, Long groupId, String groupName) {
        this.userId = userId;
        this.loginName = loginName;
        this.userName = userName;
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
