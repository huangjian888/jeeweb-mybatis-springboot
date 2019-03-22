package com.company.business.authorization.security.user;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TomatoUserServiceImpl extends ServiceImpl<TomatoUserMapper, TomatoUserEntity> implements ITomatoUserService {
    @Override
    public TomatoUserEntity findUserByUsername(String username) {

        return baseMapper.getUserByUserName(username);
    }

    @Override
    public int updateTomatoUser(TomatoUserEntity tomatoUserEntity) {
        return insertOrUpdate(tomatoUserEntity) ? 1 : 0;
    }

}
