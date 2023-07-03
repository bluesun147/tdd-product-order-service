package com.example.productorderservice.product;

import com.example.productorderservice.ApiTest;
import com.example.productorderservice.product.adapter.ProductRepository;
import com.example.productorderservice.product.application.service.AddProductRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.example.productorderservice.product.ProductSteps.상품조회요청;
import static org.assertj.core.api.Assertions.assertThat;

// @SpringBootTest
// ApiTest에 @SpringBootTest 있기 때문에 중복 오류
class ProductApiTest extends ApiTest {

    @Autowired
    ProductRepository productRepository;
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

    @Test
    void 상품수정() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final long productId = 1L;

        final ExtractableResponse<Response> response = 상품수정요청(productId);

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(productRepository.findById(1L).get().getName()).isEqualTo("상품 수정");
    }

    private static ExtractableResponse<Response> 상품수정요청(final long productId) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(ProductSteps.상품수정요청_생성())
                .when()
                .patch("products/{productId}", productId).
                then()
                .log().all().extract();

        return response;
    }
}