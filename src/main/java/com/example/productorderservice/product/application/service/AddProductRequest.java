package com.example.productorderservice.product.application.service;

import com.example.productorderservice.product.domain.DiscountPolicy;
import org.springframework.util.Assert;

// 클래스를 record 타입으로 변경.
public record AddProductRequest(String name, int price, DiscountPolicy discountPolicy) {
    public AddProductRequest {
        Assert.hasText(name, "상품명은 필수입니다."); // validation 체크
        Assert.isTrue(price > 0, "상품 가격은 0보타 커야 합니다.");
        Assert.notNull(discountPolicy, "할인 정책은 필수 입니다.");
    }
}
