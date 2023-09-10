package com.animerch.marketplace.service;

import com.animerch.marketplace.model.User;
import com.animerch.marketplace.security.UserPrinciple;
import com.animerch.marketplace.security.jwt.JwtProvider;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service("authService")
public class AuthenticationService implements IAuthenticationService {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User signInAndReturnJWT(@NotNull User signInRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),
                        signInRequest.getPassword()));
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        String jwt = jwtProvider.generateToken(userPrinciple);
        User signInUser = userPrinciple.getUser();
        signInUser.setToken(jwt);
        return signInUser;
    }
}
