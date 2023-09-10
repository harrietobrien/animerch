package com.animerch.marketplace.service;

import com.animerch.marketplace.model.User;
import com.animerch.marketplace.model.Role;
import com.animerch.marketplace.dao.UserDAO;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@Service("userService")
public class UserService implements IUserService {
    private final UserDAO userDAO;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDAO userDAO, PasswordEncoder passwordEncoder) {
        this.userDAO = userDAO;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User saveUser(@NotNull User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(Role.USER);
        user.setCreateTime(LocalDateTime.now());
        return userDAO.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    @Override
    @Transactional
    public void changeRole(Role newRole, String username) {
        userDAO.updateUserRole(username, newRole);
    }
}
