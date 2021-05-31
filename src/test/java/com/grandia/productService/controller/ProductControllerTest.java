package com.grandia.productService.controller;

import com.grandia.productService.repository.ProductRepository;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ProductControllerTest {
    @Test
    public void getProducts() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductController productController = new ProductController(productRepository);


    }
}
