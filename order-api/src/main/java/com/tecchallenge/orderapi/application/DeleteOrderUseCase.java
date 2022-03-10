package com.tecchallenge.orderapi.application;

import com.tecchallenge.orderapi.application.port.out.OrderPort;
import com.tecchallenge.orderapi.domain.Order;
import com.tecchallenge.orderapi.core.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteOrderUseCase extends UseCase<DeleteOrderUseCase.Inputvalues, DeleteOrderUseCase.OutputValues> {

    private final OrderPort orderPort;
    @Override
    @Transactional
    public OutputValues execute(Inputvalues input) {
        Order order = orderPort.findById(input.getOrderId());
        orderPort.deleteOrder(order);
        return OutputValues.ofEmpty() ;
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
        private Long orderId;
    }

    @Value
    public static class OutputValues implements UseCase.OutputValues{

        public static DeleteOrderUseCase.OutputValues ofEmpty() {
            return new DeleteOrderUseCase.OutputValues();
        }
    }
}
