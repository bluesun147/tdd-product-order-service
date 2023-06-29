package com.example.productorderservice.order;

import com.example.productorderservice.product.DiscountPolicy;
import com.example.productorderservice.product.Product;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void getTotalPrice_none() {
        final Order order = new Order(new Product("상품명", 1000, DiscountPolicy.NONE), 2);
        final int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }

    @Test
    void getTotalPrice_fix() {
        final Order order = new Order(new Product("상품명", 2000, DiscountPolicy.FIX_1000_AMOUNT), 2);
        final int totalPrice = order.getTotalPrice();
        assertThat(totalPrice).isEqualTo(2000);
    }
}