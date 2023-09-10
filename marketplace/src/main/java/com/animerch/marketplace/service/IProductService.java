package com.animerch.marketplace.service;

import com.animerch.marketplace.model.Product;
import java.util.List;

public interface IProductService {
    Product saveProduct(Product product);

    void deleteProduct(Long id);

    List<Product> findAllProducts();
}
