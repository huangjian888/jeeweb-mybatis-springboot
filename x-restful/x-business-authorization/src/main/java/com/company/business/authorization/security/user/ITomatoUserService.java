package com.company.business.authorization.security.user;

public interface ITomatoUserService {
    TomatoUserEntity findUserByUsername(String username);
    int updateTomatoUser(TomatoUserEntity tomatoUserEntity);
}
