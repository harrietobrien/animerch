package com.animerch.marketplace.controller;

import com.animerch.marketplace.dao.projection.PurchaseItem;
import com.animerch.marketplace.service.IPurchaseService;
import com.animerch.marketplace.security.UserPrinciple;
import com.animerch.marketplace.model.Purchase;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/purchase")
public class PurchaseController {
    @Autowired
    private IPurchaseService IPurchaseService;

    @PostMapping
    public ResponseEntity<?> savePurchase(@RequestBody Purchase purchase) {
        Purchase savedPurchase = IPurchaseService.savePurchase(purchase);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> getAllPurchasesOfUser(@NotNull @AuthenticationPrincipal
                                                       UserPrinciple userPrinciple) {
        Long userId = userPrinciple.getId();
        List<PurchaseItem> userItems = IPurchaseService.findPurchaseItemsOfUser(userId);
        return ResponseEntity.ok(userItems);
    }
}
