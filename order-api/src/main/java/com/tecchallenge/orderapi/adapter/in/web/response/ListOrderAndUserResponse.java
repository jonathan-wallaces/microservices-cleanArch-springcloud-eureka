package com.tecchallenge.orderapi.adapter.in.web.response;

import com.tecchallenge.orderapi.domain.Order;
import lombok.Value;
import com.tecchallenge.orderapi.domain.User;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ListOrderAndUserResponse {

    private final List<OrderResponse> orderResponses;
    private final UserResponse userResponse;

    public static ListOrderAndUserResponse of(List<Order> orders, User user){
        return new ListOrderAndUserResponse(
                OrderResponse.of(orders),
                UserResponse.of(user)
        );
    }


    @Value
    public static class OrderResponse {
        private Long id;
        private String itemDescription;
        private Long itemQuantity;
        private BigDecimal itemPrice;
        private BigDecimal totalValue;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        public static List<OrderResponse> of(List<Order> orders) {
            return orders.stream()
                    .map(OrderResponse::of)
                    .collect(Collectors.toList());
        }
        public static OrderResponse of(Order order) {
            return new OrderResponse(
                    order.getId(),
                    order.getItemDescription(),
                    order.getItemQuantity(),
                    order.getItemPrice(),
                    order.getTotalValue(),
                    order.getCreatedAt(),
                    order.getUpdatedAt()
            );
        }
    }

    @Value
    public static class UserResponse {
        private String name;
        private Long cpf;
        private String email;
        private Long phoneNumber;

        public static UserResponse of(User user) {
            return new UserResponse(
                    user.getName(),
                    user.getCpf(),
                    user.getEmail(),
                    user.getPhoneNumber()
            );
        }
    }

}

