package com.tecchallenge.orderapi.application;

import com.tecchallenge.orderapi.application.port.out.OrderPort;
import com.tecchallenge.orderapi.core.OrderProxy;
import com.tecchallenge.orderapi.core.UseCase;
import com.tecchallenge.orderapi.domain.Order;
import com.tecchallenge.orderapi.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListOrderByUserUseCase extends UseCase<ListOrderByUserUseCase.Inputvalues, ListOrderByUserUseCase.Outputvalues> {
    private final OrderPort orderPort;
    private final OrderProxy orderProxy;

    @Override
    public Outputvalues execute(Inputvalues input) {
        User user = orderProxy.getUserById(input.getId());
        List<Order> orders = orderPort.findByUserId(input.getId());


        return Outputvalues.of(user, orders);
    }

    @Value
    public static class Inputvalues implements UseCase.InputValues {
        private Long id;
    }

    @Value
    public static class Outputvalues implements UseCase.OutputValues {
        User user;
        List<Order> orders;

        public static Outputvalues of(User user, List<Order> orders) {
            return new Outputvalues(user, orders);
        }
    }
}