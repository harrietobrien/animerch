package com.animerch.marketplace.dao;

import com.animerch.marketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDAO extends JpaRepository<Product, Long>  {
}
