package com.company.shop.sys.service.modules.sys.mapper;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version V1.0
 * @package com.company.shop.sys.service.modules.sys.mapper
 * @title: 用户表数据库控制层接口
 * @description: 用户表数据库控制层接口
 * @author: huangjian
 * @date: 2018-11-23 15:48:46
 */
@Mapper
public interface StoreUserMapper extends BaseMapper<StoreUserEntity> {
    List<StoreUserEntity> selectStoreUserList(Pagination page, @Param("ew") Wrapper<StoreUserEntity> wrapper);

    StoreUserEntity selectAward(@Param("username") String username);

    //查询当前用户邀请的好友列表
    List<StoreUserEntity> getFriendList(Pagination page, @Param("username") String username);

    //查询当日没有进行步数兑换金币的用户数
    List<StoreUserEntity> getUserListGold();
}