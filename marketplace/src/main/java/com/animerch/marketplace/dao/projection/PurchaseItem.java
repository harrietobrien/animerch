package com.animerch.marketplace.dao.projection;

import java.time.LocalDateTime;

public interface PurchaseItem {
    String getName();
    Double getPrice();
    LocalDateTime getPurchaseTime();
}
