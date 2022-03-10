package com.tecchallenge.orderapi.application;

import com.tecchallenge.orderapi.domain.Order;
import com.tecchallenge.orderapi.application.port.out.OrderPort;
import com.tecchallenge.orderapi.core.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListAllOrdersUseCase extends UseCase<ListAllOrdersUseCase.Inputvalues, ListAllOrdersUseCase.Outputvalues> {

    private final OrderPort orderPort;

    @Override
    public Outputvalues execute(Inputvalues input) {
        List<Order> orders = orderPort.findAll();
       //tratar quando estiver vazio
        return Outputvalues.of(orders);
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues{
    }

    @Value
    public static class Outputvalues implements UseCase.OutputValues{
        List<Order> orders;
        public static Outputvalues of(List<Order> orders) {
            return new Outputvalues(orders);
        }
    }
}
