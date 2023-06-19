package com.example.productorderservice.product;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
class ProductServiceTest {
    @Autowired
    private ProductService productService;
//    @Autowired
//    private ProductPort productPort;

//    @BeforeEach
//    void setUp() {
//        productPort = Mockito.mock(ProductPort.class);
//        productService = new ProductService(productPort);
//    }

    @Test
    void 상품수정() {
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final Long productId = 1L;
        final UpdateProductRequest request = new UpdateProductRequest("상품 수정", 2000, DiscountPolicy.NONE);
//        final Product product = new Product("상품명", 1000, DiscountPolicy.NONE);
//        Mockito.when(productPort.getProduct(productId)).thenReturn(product);

        productService.updateProduct(productId, request);

        final ResponseEntity<GetProductResponse> response = productService.getProduct(productId);

        final GetProductResponse productResponse = response.getBody();

        Assertions.assertThat(productResponse.name()).isEqualTo("상품 수정");
        Assertions.assertThat(productResponse.price()).isEqualTo(2000);
    }
}
