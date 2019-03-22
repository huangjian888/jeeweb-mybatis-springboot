package com.company.business.goods.security.user;

import org.springframework.security.core.userdetails.UserDetails;

public interface ITokenService {
    void storeToken(String tokenKey, String value);

    String generateToken(UserDetails userDetails);

    String getInfoByToken(String tokenKey);
}
