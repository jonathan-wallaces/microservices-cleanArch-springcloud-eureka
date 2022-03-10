package com.tecchallenge.orderapi.adapter.in.web.response;

import com.tecchallenge.orderapi.domain.Order;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ReporterOrderResponse {

    private Long id;
    private String itemDescription;
    private Long itemQuantity;
    private BigDecimal itemPrice;
    private BigDecimal totalValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;



    public static List<ReporterOrderResponse> of (List<Order> orders){
        return orders.stream()
                .map(ReporterOrderResponse::of)
                .collect(Collectors.toList());
    }

    public static ReporterOrderResponse of(Order order) {
        return new ReporterOrderResponse(
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
