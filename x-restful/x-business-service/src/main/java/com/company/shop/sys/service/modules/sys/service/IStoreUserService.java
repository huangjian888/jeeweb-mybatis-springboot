package com.company.shop.sys.service.modules.sys.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.company.manerger.sys.common.mybatis.service.ICommonService;
import com.company.shop.sys.service.modules.sys.entity.GoldLogEntity;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;

import java.util.List;
/**
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.service
 * @title: 用户表服务接口
 * @description: 用户表服务接口
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */
public interface IStoreUserService extends ICommonService<StoreUserEntity> {
    /**
     * 根据用户名查找用户
     *
     * @param username
     * @return
     */
    StoreUserEntity findByUsername(String username);


    String login(String username, String password);

    String register(StoreUserEntity user);

    String refreshToken(String oldToken);


    int updateAward(int step);

    int updateGold(StoreUserEntity userEntity);

    int updateUserInfo(String nickName, String avatar);

    StoreUserEntity getUserInfo();

    StoreUserEntity getUserInfo(String username);

    Page<GoldLogEntity> getGoldList(Page<GoldLogEntity> page);


    Page<StoreUserEntity> getFriendList(Page<StoreUserEntity> page);

    List<StoreUserEntity> getUserListGold();
}