package com.project.moonbuddy.product;
import com.project.moonbuddy.user.Role;
import com.project.moonbuddy.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
@Transactional
public class ProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @Test
    public void testFindAllProducts() {

        // Review 객체 생성 및 목록에 추가

        Product product1 = new Product(1L, "Product 1", "Category 1", "Brand 1", "2023-10-30", "Description 1", "Picture 1", 0.75, 0.9, 0.8, 0.9, 50.0,null);
        Product product2 = new Product(2L, "Product 2", "Category 2", "Brand 2", "2023-10-31", "Description 2", "Picture 2", 0.8, 0.85, 0.75, 0.8, 45.0,null);
        productRepository.save(product1);
        productRepository.save(product2);

        Iterable<Product> retrievedProducts = productRepository.findAll();

        int count = 0;
        for (Product product : retrievedProducts) {
            count++;
        }

        assertEquals(2, count);
    }

    @Transactional
    @Test
    public void testFindProductById() {
        // Create and save a sample product
        Product product = new Product(1L, "Product 1", "Category 1", "Brand 1", "2023-10-30", "Description 1", "Picture 1", 0.75, 0.9, 0.8, 0.9, 50.0,null);
        productRepository.save(product);

        Product retrievedProduct = productRepository.findByName("Product 1").orElse(null);

        assertEquals("Product 1", retrievedProduct.getName());
    }

    // Add more test methods for other repository operations

}
