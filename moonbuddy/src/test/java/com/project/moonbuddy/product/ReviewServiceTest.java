package com.project.moonbuddy.product;

import com.project.moonbuddy.product.Product;
import com.project.moonbuddy.product.ProductRepository;
import com.project.moonbuddy.product.ReviewRepository;
import com.project.moonbuddy.product.ReviewService;
import com.project.moonbuddy.product.dto.ReviewDTO;
import com.project.moonbuddy.user.User;
import com.project.moonbuddy.user.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @Mock
    private ProductRepository productRepository;

    private ReviewService reviewService;
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        reviewService = new ReviewService(reviewRepository, productRepository, userRepository);
    }

    @Test
    public void testPost() {
//        // Arrange
        Long productId = 1L;
        Long userId = 1L;
        String reviewContent = "Sample review content";

        Product product = new Product(1L, "Product 1", "Category 1", "Brand 1", "2023-10-30", "Description 1", "Picture 1", 0.75, 0.9, 0.8, 0.9, 50.0,null);
        User user = new User("mk","23","mk",null);

        when(productRepository.findById(productId)).thenReturn(Optional.of(product));
        when(userRepository.findById(userId)).thenReturn(Optional.of(user));  // findByEmail 메서드 사용

        ReviewDTO.Request request = new ReviewDTO.Request();
        request.setProductId(productId);
        request.setUserId(userId);  // 필드 이름 변경: setUserName
        request.setReviewcommnet(reviewContent);  // 필드 이름 변경: setReviewContent


        // Act
        String result = reviewService.post(request);

        // Assert
        assertEquals("SUCCESS", result);
        // Add more assertions if needed
    }
}
