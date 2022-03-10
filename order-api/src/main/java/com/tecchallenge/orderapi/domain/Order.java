package com.tecchallenge.orderapi.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "tb_orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private String itemDescription;
    @NotNull
    private Long itemQuantity;
    @NotNull
    private BigDecimal itemPrice;
    private BigDecimal totalValue;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Order(Long userId, String itemDescription, Long itemQuantity, BigDecimal itemPrice) {
        this.userId = userId;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }

    public BigDecimal totalValue(BigDecimal itemPrice, Long itemQuantity) {
        return this.totalValue = itemPrice.multiply(BigDecimal.valueOf(itemQuantity));
    }

    public void createdAt() {
        this.createdAt = LocalDateTime.now();
    }

    public void updatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

    public void updateOrder(Long userId, String itemDescription, Long itemQuantity, BigDecimal itemPrice) {
        this.userId = userId;
        this.itemDescription = itemDescription;
        this.itemQuantity = itemQuantity;
        this.itemPrice = itemPrice;
    }
}
