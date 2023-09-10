package com.animerch.marketplace.controller;
import com.animerch.marketplace.model.Role;
import com.animerch.marketplace.service.IUserService;
import com.animerch.marketplace.security.UserPrinciple;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private IUserService IUserService;

    @PutMapping("change/{role}")
    public ResponseEntity<?> changeRole(@NotNull @AuthenticationPrincipal UserPrinciple userPrinciple,
                                        @PathVariable Role role) {
        IUserService.changeRole(role, userPrinciple.getUsername());
        return ResponseEntity.ok(true);
    }
}
