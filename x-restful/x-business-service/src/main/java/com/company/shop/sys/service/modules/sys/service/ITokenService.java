package com.company.shop.sys.service.modules.sys.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface ITokenService {
    void storeToken(String tokenKey, String value);

    String refreshToken(String oldToken, String refresh);

    void updateToken(String newToken, String oldToken);

    String generateToken(String username);

    String generateToken(UserDetails userDetails);

    String getInfoByToken(String tokenKey);
}
