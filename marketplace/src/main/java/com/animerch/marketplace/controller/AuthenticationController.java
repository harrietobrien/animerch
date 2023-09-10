package com.animerch.marketplace.controller;

import com.animerch.marketplace.model.User;
import com.animerch.marketplace.service.IAuthenticationService;
import com.animerch.marketplace.service.IUserService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/authentication")
public class AuthenticationController {
    @Autowired
    private IAuthenticationService IAuthenticationService;
    @Autowired
    private IUserService IUserService;

    @PostMapping("sign-up")
    public ResponseEntity<?> signUp(@NotNull @RequestBody User user) {
        if (IUserService.findByUsername(user.getUsername()).isPresent()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(IUserService.saveUser(user), HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody User user) {
        return new ResponseEntity<>(IAuthenticationService.signInAndReturnJWT(user), HttpStatus.OK);
    }
}
