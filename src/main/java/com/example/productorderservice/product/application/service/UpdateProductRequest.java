package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

//    private static class UpdateProductRequest {
//        private final String name;
//        private final int price;
//        private final DiscountPolicy policy;
//
//        public UpdateProductRequest(final String name, final int price, final DiscountPolicy policy) {
//            Assert.hasText(name, "상품명은 필수입니다.");
//            this.name = name;
//            this.price = price;
//            this.policy = policy;
//        }
//    }

// record - 위의 코드와 같은 내용
public record UpdateProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public UpdateProductRequest {
        Assert.hasText(name, "상품명은 필수입니다.");
    }
}
