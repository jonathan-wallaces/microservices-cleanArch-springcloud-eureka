package com.tecchallenge.orderapi.application;

import com.tecchallenge.orderapi.domain.Order;
import com.tecchallenge.orderapi.application.port.out.OrderPort;
import com.tecchallenge.orderapi.core.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class UpdateOrderUseCase extends UseCase<UpdateOrderUseCase.Inputvalues, UpdateOrderUseCase.Outputvalues> {

    private OrderPort orderPort;

    @Override
    public Outputvalues execute(Inputvalues input) {
        Order order = orderPort.findById(input.getOrderId());
        order.updateOrder(
                input.getUserId(),
                input.getItemDescription(),
                input.getItemQuantity(),
                input.getItemPrice()
        );
        order.totalValue(input.getItemPrice(), input.getItemQuantity());
        order.updatedAt();
        orderPort.saveOrder(order);
        return Outputvalues.ofEmpty();
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
        private Long orderId;
        private Long userId;
        private String itemDescription;
        private Long itemQuantity;
        private BigDecimal itemPrice;
    }

    @Value
    public static class Outputvalues implements UseCase.OutputValues{

        public static Outputvalues ofEmpty() {
           return new UpdateOrderUseCase.Outputvalues();
        }
    }
}
