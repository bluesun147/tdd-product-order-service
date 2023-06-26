package com.example.productorderservice.order;

import com.example.productorderservice.product.Product;
import org.springframework.util.Assert;

class Order {
    private final Product product;
    private final int quantity;
    private Long id;

    public Order(final Product product, final int quantity) {
        this.product = product;
        this.quantity = quantity;
        Assert.notNull(product, "상품은 필수입니다.");
    }

    public void assignId(final Long aLong) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
