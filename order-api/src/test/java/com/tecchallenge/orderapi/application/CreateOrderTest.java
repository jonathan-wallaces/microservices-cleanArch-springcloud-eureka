package com.tecchallenge.orderapi.application;

import com.tecchallenge.orderapi.application.port.out.OrderPort;
import com.tecchallenge.orderapi.core.OrderProxy;
import com.tecchallenge.orderapi.domain.Order;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Arrays;

@ExtendWith(SpringExtension.class)
public class CreateOrderTest {

    @MockBean
    private OrderPort orderPort;

    @MockBean
    private OrderProxy orderProxy;

    @Test
    @DisplayName("Sucessfully create a Order")
    void saveOrderTest(){


        Order order = createValidOrder();
        order.createdAt();

        orderPort.saveOrder(order);

        Mockito.verify(orderPort, Mockito.times(1)).saveOrder(order);

    }

    private Order createValidOrder() {
        return Order.builder()
                .id(1L)
                .itemDescription("Description")
                .itemPrice(BigDecimal.valueOf(5))
                .itemQuantity(2L)
                .userId(1L)
                .build();
    }
}
