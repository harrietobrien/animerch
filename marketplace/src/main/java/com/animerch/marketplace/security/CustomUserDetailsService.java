package com.animerch.marketplace.security;

import com.animerch.marketplace.model.User;
import com.animerch.marketplace.service.IUserService;
import com.animerch.marketplace.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Set;

@Service("customUDS")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private IUserService IUserService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = IUserService.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
        Set<GrantedAuthority> authorities = Set.of(SecurityUtils.convertToAuthority(user.getRole().name()));
        return UserPrinciple.builder()
                .user(user)
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .authorities(authorities)
                .build();
    }
}
