package com.animerch.marketplace.service;
import com.animerch.marketplace.model.User;
public interface IAuthenticationService {
    User signInAndReturnJWT(User signInRequest);
}
