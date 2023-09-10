package com.animerch.marketplace.service;

import com.animerch.marketplace.model.Purchase;
import com.animerch.marketplace.dao.projection.PurchaseItem;
import java.util.List;

public interface IPurchaseService {
    Purchase savePurchase(Purchase purchase);
    List<PurchaseItem> findPurchaseItemsOfUser(Long userId);
}
