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

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
public class EditOrderTest {

    @MockBean
    private OrderPort orderPort;

    @MockBean
    private OrderProxy orderProxy;

    @Test
    @DisplayName("Sucessfully edit a Order")
    void editOrderTest(){
        Order order = createValidOrder();
        Mockito.when(orderPort.findById(1L)).thenReturn(order);
        order.updateOrder(
                1L,
                "Updated Description",
                3L,
                BigDecimal.valueOf(10)
        );
        order.updatedAt();
        orderPort.saveOrder(order);

        Mockito.verify(orderPort, Mockito.times(1)).saveOrder(order);
        assertThat(order.getItemQuantity()).isEqualTo(3L);
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
