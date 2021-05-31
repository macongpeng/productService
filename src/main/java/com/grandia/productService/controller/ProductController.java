package com.grandia.productService.controller;

import com.grandia.productService.domain.Product;
import com.grandia.productService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    private ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping(value = "/products",
            produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepository.findAll();
        return (new ResponseEntity<>(products, HttpStatus.OK));
    }

    @PostMapping("/products")
    public ResponseEntity<Void> save(@RequestBody Product product) {
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
