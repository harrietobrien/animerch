package com.animerch.marketplace.controller;

import com.animerch.marketplace.model.Product;
import com.animerch.marketplace.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private IProductService IProductService;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        Product savedProduct = IProductService.saveProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long productId) {
        IProductService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = IProductService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
