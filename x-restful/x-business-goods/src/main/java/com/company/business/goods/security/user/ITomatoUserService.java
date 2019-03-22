package com.company.business.goods.security.user;

public interface ITomatoUserService {
    TomatoUserEntity findUserByUsername(String username);

    boolean updateTomatoUser(TomatoUserEntity tomatoUserEntity);

    String login(String username, String password);

    String register(TomatoUserEntity user);

    boolean updateUserInfo(TomatoUserEntity tomatoUserEntity);
}
