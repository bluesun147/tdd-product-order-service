package com.example.productorderservice.product;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/*
상품 등록에선 서비스 -> 포트 -> 어댑터 -> 리포지토리 호출하는 풀로우 만들기 위해서 pojo 클래스 먼저 만들었는데
간단한 상품 조회는 처음부터 SpringBootTest 해도 무방
 */

@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;

    @Test
    void 상품조회() {
        // 상품등록
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final long productId = 1L;

        // 상품조회
        final GetProductResponse response = productService.getProduct(productId);

        // 상품 응답 검증
        // 보통 검증 먼저 만든다 -> 어떤 것을 검증하기 위해 어떠한 기능이 필요한 지
        assertThat(response).isNotNull();
    }
}
