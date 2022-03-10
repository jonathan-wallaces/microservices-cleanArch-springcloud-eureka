package com.tecchallenge.orderapi.adapter.in.web;

import com.tecchallenge.orderapi.application.UpdateOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Tag(name="Order Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/orders")
public class UpdateOrderController {
    private final UpdateOrderUseCase updateOrderUseCase;

    @Operation(summary = "Update a specific order by your Id")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void execute(@Valid @RequestBody UpdateOrderRequest updateOrderRequest){
        updateOrderUseCase.execute(
                new UpdateOrderUseCase.Inputvalues(
                        updateOrderRequest.getOrderId(),
                        updateOrderRequest.getOrderId(),
                        updateOrderRequest.getItemDescription(),
                        updateOrderRequest.getItemQuantity(),
                        updateOrderRequest.getItemPrice()
                )
        );
    }


    @Value
    private static class UpdateOrderRequest{
        @NotNull
        private Long orderId;
        @NotNull
        private Long userId;
        @NotNull
        private String itemDescription;
        @NotNull
        private Long cpf;
        @NotNull
        private Long itemQuantity;
        @NotNull
        private BigDecimal itemPrice;
    }
}
