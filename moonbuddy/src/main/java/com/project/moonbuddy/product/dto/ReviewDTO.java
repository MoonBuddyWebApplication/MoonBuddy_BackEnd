package com.project.moonbuddy.product.dto;

import com.project.moonbuddy.product.Product;
import com.project.moonbuddy.product.Review;
import com.project.moonbuddy.user.User;
import lombok.*;

public class ReviewDTO {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class Request {
        private Long userId;
        private Long productId;
        private String reviewcommnet;

        public Review toEntity(User user, Product product) {
            Review review = Review.builder()
                    .user(user)
                    .product(product)
                    .reviewContetent(reviewcommnet)
                    .build();
            return review;

        }

    }

    @RequiredArgsConstructor
    @Getter
    public static class Response {
        private Long replyId;
        private String reviewcomment;
        private String createDate;
        private String nickname;
        private Long userId;
        private Long productId;

        public Response(Review review){
            this.replyId=review.getId();
            this.productId=review.getProduct().getId();
            this.nickname=review.getUser().getName();
            this.userId=review.getUser().getId();
            this.reviewcomment=review.getReviewContetent();
            this.createDate=review.getCreatedDate().toString();
        }


    }
}




