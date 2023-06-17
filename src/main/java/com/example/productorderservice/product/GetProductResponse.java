package com.example.productorderservice.product;

import org.springframework.util.Assert;

// inner class로 먼저 생성
record GetProductResponse(
        long id,
        String name,
        int price,
        DiscountPolicy discountPolicy
) {
    // 레코드 - 컴팩트 생성자
    // 매개변수를 받는 부분이 생략된 형태
    // this.valuse = values와 같이 개발자가 일일이 필드를 초기화하는 로직을 작성하지 않아도 마지막에 자동으로 필드를 초기화
    GetProductResponse {
        Assert.notNull(id, "상품 ID는 필수입니다");
        Assert.hasText(name, "상품명은 필수입니다");
        Assert.notNull(discountPolicy, "할인 정책은 필수입니다");
    }
}
