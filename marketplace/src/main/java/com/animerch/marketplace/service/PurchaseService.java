package com.animerch.marketplace.service;

import com.animerch.marketplace.model.Purchase;
import com.animerch.marketplace.dao.PurchaseDAO;
import com.animerch.marketplace.dao.projection.PurchaseItem;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
@Service("purchaseService")
public class PurchaseService implements IPurchaseService {
    private final PurchaseDAO purchaseDAO;

    public PurchaseService(PurchaseDAO purchaseDAO) {
        this.purchaseDAO = purchaseDAO;
    }

    @Override
    public Purchase savePurchase(@NotNull Purchase purchase) {
        purchase.setPurchaseTime(LocalDateTime.now());
        return purchaseDAO.save(purchase);
    }

    @Override
    public List<PurchaseItem> findPurchaseItemsOfUser(Long userId) {
        return purchaseDAO.findAllPurchasesOfUser(userId);
    }
}
