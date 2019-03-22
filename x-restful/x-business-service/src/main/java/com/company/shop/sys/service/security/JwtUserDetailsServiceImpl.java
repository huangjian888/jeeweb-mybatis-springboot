package com.company.shop.sys.service.security;

import com.company.shop.sys.service.modules.sys.entity.StoreUserEntity;
import com.company.shop.sys.service.modules.sys.service.IStoreUserService;
import com.company.shop.sys.service.security.userdetails.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by hexin on 2018/11/27.
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IStoreUserService storeUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        StoreUserEntity user = storeUserService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return new JwtUser(user.getUsername(), user.getPassword());

    }
}
