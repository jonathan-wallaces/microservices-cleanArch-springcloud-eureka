package com.tecchallenge.orderapi.adapter.in.web;

import com.tecchallenge.orderapi.application.CreateOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Tag(name="Order Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/orders")
public class CreateOrderController {
    private final CreateOrderUseCase createOrderUseCase;

    @Operation(summary = "Create a order")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void execute(@RequestBody OrderRequest orderResquest){
        createOrderUseCase.execute(
              new CreateOrderUseCase.Inputvalues(
                      orderResquest.getUserId(),
                      orderResquest.getItemDescription(),
                      orderResquest.getItemQuantity(),
                      orderResquest.getItemPrice()
              ));
    }

    @Value
    public static class OrderRequest{
        private Long userId;
        private String itemDescription;
        private Long itemQuantity;
        private BigDecimal itemPrice;
    }
}
