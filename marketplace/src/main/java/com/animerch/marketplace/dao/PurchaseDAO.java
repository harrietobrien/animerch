package com.animerch.marketplace.dao;

import com.animerch.marketplace.model.Purchase;
import com.animerch.marketplace.dao.projection.PurchaseItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PurchaseDAO extends JpaRepository<Purchase, Long> {

    // TODO: Implement @NamedNativeQuery annotation for SQL queries
    String select = "SELECT product.name AS name, purchase.price AS price, purchase.purchaseTime AS purchaseTime ";
    String from = "FROM Purchase purchase LEFT JOIN Product product ON product.id = purchase.productId ";
    String where = "WHERE purchase.userId = :userId";

    @Query(select + from + where)
    List<PurchaseItem> findAllPurchasesOfUser(@Param("userId") Long userId);
}
