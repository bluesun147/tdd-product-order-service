package com.example.productorderservice.order;

import org.springframework.util.Assert;

record CreateOrderRequest(Long productId, int quantity) {
    CreateOrderRequest(final Long productId, final int quantity) {
        this.productId = productId;
        this.quantity = quantity;
        Assert.notNull(productId, "상품 id는 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 커야 합니다.");
    }
}
