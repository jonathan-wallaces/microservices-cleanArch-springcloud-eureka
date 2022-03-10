package com.tecchallenge.orderapi.application.port.out;

import com.tecchallenge.orderapi.domain.Order;

import java.util.List;

public interface OrderPort {
    void saveOrder(Order order);

    Order findById(Long orderId);

    List<Order> findAll();

    void deleteOrder(Order order);

    List<Order> findByUserId(Long id);
}
