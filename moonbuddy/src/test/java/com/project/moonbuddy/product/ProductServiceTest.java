package com.project.moonbuddy.product;
import com.project.moonbuddy.product.Product;
import com.project.moonbuddy.product.ProductRepository;
import com.project.moonbuddy.product.ProductService;
import com.project.moonbuddy.product.dto.response.ProductResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @BeforeEach
    public void setUp() {
        productService = new ProductService(productRepository);
    }



    @Test
    public void testSelectAll() {
        // Arrange
        List<Product> productList = new ArrayList<>();
        // Create and add Product objects to the productList

        when(productRepository.findAll()).thenReturn(productList);

        // Act
        List<ProductResponse> productResponses = productService.selectAll();

        // Assert
        // Add assertions to verify the correctness of the returned productResponses
    }
}
