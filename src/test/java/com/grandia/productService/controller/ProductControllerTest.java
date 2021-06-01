package com.grandia.productService.controller;

import com.grandia.productService.domain.Product;
import com.grandia.productService.repository.ProductRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

public class ProductControllerTest {
    @Test
    public void getProductsTest() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductController productController = new ProductController(productRepository);

        ResponseEntity<List<Product>> responseEntity = productController.getProducts();
        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
        assertNotNull(responseEntity.getBody());

        Mockito.verify(productRepository, atLeastOnce()).findAll();
    }

    @Test
    public void saveTest() {
        ProductRepository productRepository = mock(ProductRepository.class);
        ProductController productController = new ProductController(productRepository);

        Product product = Product.builder().build();
        ResponseEntity<Void> responseEntity = productController.save(product);

        assertNotNull(responseEntity);
        assertEquals(200, responseEntity.getStatusCodeValue());
    }
}
