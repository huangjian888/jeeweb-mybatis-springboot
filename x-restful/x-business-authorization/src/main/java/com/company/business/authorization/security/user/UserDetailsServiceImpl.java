package com.company.business.authorization.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by hexin on 2018/11/27.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private ITomatoUserService tomatoUserService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TomatoUserEntity tomatoUser = tomatoUserService.findUserByUsername(username);

        if (tomatoUser == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        }
        return new JwtUserDetails(tomatoUser.getUsername(), tomatoUser.getPassword());

    }
}
