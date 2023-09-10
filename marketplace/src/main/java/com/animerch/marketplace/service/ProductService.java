package com.animerch.marketplace.service;

import com.animerch.marketplace.model.Product;
import com.animerch.marketplace.dao.ProductDAO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service("productService")
public class ProductService implements IProductService {
    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public Product saveProduct(@NotNull Product product) {
        product.setCreateTime(LocalDateTime.now());
        return productDAO.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        productDAO.deleteById(id);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }
}
