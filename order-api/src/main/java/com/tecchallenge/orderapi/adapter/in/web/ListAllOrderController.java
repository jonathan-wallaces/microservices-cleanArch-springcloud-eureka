package com.tecchallenge.orderapi.adapter.in.web;

import com.tecchallenge.orderapi.adapter.in.web.response.ReporterOrderResponse;
import com.tecchallenge.orderapi.application.ListAllOrdersUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name="Order Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/orders")
public class ListAllOrderController {
    private final ListAllOrdersUseCase listAllOrdersUseCase;

    @Operation(summary = "List all orders in BD")
    @GetMapping
    public ResponseEntity<List<ReporterOrderResponse> >execute(){
        ListAllOrdersUseCase.Outputvalues outputvalues = listAllOrdersUseCase.execute(
                new ListAllOrdersUseCase.Inputvalues()
        );

        List<ReporterOrderResponse> response = ReporterOrderResponse.of(outputvalues.getOrders());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

