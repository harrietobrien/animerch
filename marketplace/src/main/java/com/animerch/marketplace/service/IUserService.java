package com.animerch.marketplace.service;

import com.animerch.marketplace.model.User;
import com.animerch.marketplace.model.Role;
import java.util.Optional;

public interface IUserService {
    User saveUser(User user);

    Optional<User> findByUsername(String username);

    void changeRole(Role newRole, String username);
}
