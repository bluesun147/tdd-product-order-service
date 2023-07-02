package com.example.productorderservice.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

interface PaymentRepository extends JpaRepository<Payment, Long> {
//    private Map<Long, Payment> persistence = new HashMap<>();
//    private Long sequence = 0L;
//
//    public void save(final Payment payment) {
//        payment.assignId(++sequence);
//        persistence.put(payment.getId(), payment);
//    }
}
