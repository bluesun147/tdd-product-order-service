package com.example.productorderservice.order.adapter;

import com.example.productorderservice.order.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface OrderRepository extends JpaRepository<Order, Long> {
//    private final Map<Long, Order> persistence = new HashMap<>();
//    private Long sequence = 0L;
//
//    public void save(Order order) {
//        order.assignId(++sequence);
//        persistence.put(order.getId(), order);
//    }
}
