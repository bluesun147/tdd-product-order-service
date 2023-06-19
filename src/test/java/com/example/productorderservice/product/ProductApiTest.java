package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static com.example.productorderservice.product.ProductSteps.상품조회요청;
import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// ApiTest에 @SpringBootTest 있기 때문에 중복 오류
class ProductApiTest extends ApiTest {
    private final ProductSteps productSteps = new ProductSteps();

    @Test
    void 상품등록() {
        final AddProductRequest request = productSteps.상품등록요청_생성();

        // api 요청 보내기
        final ExtractableResponse<Response> response = productSteps.상품등록요청(request);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    @Test
    void 상품조회() {
        // 먼저 상품 등록
        productSteps.상품등록요청(productSteps.상품등록요청_생성());
        Long productId = 1L;

        final ExtractableResponse<Response> response = 상품조회요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().getString("name")).isEqualTo("상품명");
    }
}