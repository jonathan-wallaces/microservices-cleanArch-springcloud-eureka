package com.tecchallenge.orderapi.adapter.out.persistence;

import com.tecchallenge.orderapi.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
