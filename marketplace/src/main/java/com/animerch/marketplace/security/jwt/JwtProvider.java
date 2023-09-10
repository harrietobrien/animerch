package com.animerch.marketplace.security.jwt;

import com.animerch.marketplace.security.UserPrinciple;
import org.springframework.security.core.Authentication;
import javax.servlet.http.HttpServletRequest;

public interface JwtProvider {
    String generateToken(UserPrinciple auth);

    Authentication getAuthentication(HttpServletRequest request);

    boolean isTokenValid(HttpServletRequest request);
}
