package com.company.manerger.sys.service.modules.sys.service.impl;

//import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.company.manerger.sys.common.mybatis.service.impl.CommonServiceImpl;
import com.company.manerger.sys.common.mybatis.wrapper.EntityWrapper;
import com.company.manerger.sys.common.utils.StringUtils;
import com.company.manerger.sys.service.modules.sys.entity.StoreUser;
import com.company.manerger.sys.service.modules.sys.mapper.StoreUserMapper;
import com.company.manerger.sys.service.modules.sys.service.IStoreUserService;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;


/**
*
* @version V1.0
* @package com.company.shop.sys.service.modules.sys.service.impl
* @title: 用户表服务实现
* @description: 用户表服务实现
* @author: huangjian
* @date: 2018-11-23 15:48:46
*/
//@Transactional
@Service
@DS("slave")
public class StoreUserServiceImpl extends CommonServiceImpl<StoreUserMapper, StoreUser> implements IStoreUserService {

    @Override
    public StoreUser findByUsername(String username) {
        if (StringUtils.isEmpty(username)) {
            return null;
        }
        return selectOne(new EntityWrapper<StoreUser>(StoreUser.class).eq("username", username));
    }

}