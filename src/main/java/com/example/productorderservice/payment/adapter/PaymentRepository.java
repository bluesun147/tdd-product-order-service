package com.example.productorderservice.payment.adapter;

import com.example.productorderservice.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentRepository extends JpaRepository<Payment, Long> {
//    private Map<Long, Payment> persistence = new HashMap<>();
//    private Long sequence = 0L;
//
//    public void save(final Payment payment) {
//        payment.assignId(++sequence);
//        persistence.put(payment.getId(), payment);
//    }
}
