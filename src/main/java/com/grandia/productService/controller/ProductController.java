package com.grandia.productService.controller;

import com.grandia.productService.domain.Product;
import com.grandia.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/products")
    public List getProducts() {
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }
}
