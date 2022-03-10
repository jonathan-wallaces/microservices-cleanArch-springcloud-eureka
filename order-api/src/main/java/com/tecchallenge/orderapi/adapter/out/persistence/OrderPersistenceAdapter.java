package com.tecchallenge.orderapi.adapter.out.persistence;

import com.tecchallenge.orderapi.domain.Order;
import com.tecchallenge.orderapi.application.port.out.OrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class OrderPersistenceAdapter implements OrderPort {
    private final OrderRepository orderRepository;

    @Override
    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    @Override
    public Order findById(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("Order doesn´t exists!!!"));
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteOrder(Order order) {
        orderRepository.delete(order);
    }

    @Override
    public List<Order> findByUserId(Long id) {
        return orderRepository.findByUserId(id);    }

}
