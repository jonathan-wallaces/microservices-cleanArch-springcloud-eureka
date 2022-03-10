package com.tecchallenge.orderapi.application;

import com.tecchallenge.orderapi.application.port.out.OrderPort;
import com.tecchallenge.orderapi.core.OrderProxy;
import com.tecchallenge.orderapi.domain.Order;
import com.tecchallenge.orderapi.core.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CreateOrderUseCase extends UseCase<CreateOrderUseCase.Inputvalues, CreateOrderUseCase.OutputValues> {
    private final OrderPort orderPort;
    private final OrderProxy orderProxy;

    @Override
    public OutputValues execute(Inputvalues input) {

        if(Arrays.asList(orderProxy.getUserById(input.getUserId())).isEmpty()){
            throw new RuntimeException("User don't exists.");
        }
        Order order = new Order(
                input.getUserId(),
                input.getItemDescription(),
                input.getItemQuantity(),
                input.getItemPrice()
        );
        order.totalValue(input.getItemPrice(), input.getItemQuantity());
        order.createdAt();

        orderPort.saveOrder(order);
        return OutputValues.ofEmpty();
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
        private Long userId;
        private String itemDescription;
        private Long itemQuantity;
        private BigDecimal itemPrice;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{

        public static OutputValues ofEmpty() {
            return new CreateOrderUseCase.OutputValues();
        }
    }
}
