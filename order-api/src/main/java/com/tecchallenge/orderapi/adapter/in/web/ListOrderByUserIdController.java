package com.tecchallenge.orderapi.adapter.in.web;

import com.tecchallenge.orderapi.adapter.in.web.response.ListOrderAndUserResponse;
import com.tecchallenge.orderapi.application.ListOrderByUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Order Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/orders")
public class ListOrderByUserIdController {
    private final ListOrderByUserUseCase listOrderByUserUseCase;

    @Operation(summary = "List a specific order by your user Id")
    @GetMapping(path = "/list-by-user/{id}")
    public ResponseEntity<ListOrderAndUserResponse>execute(@PathVariable Long id){
        ListOrderByUserUseCase.Outputvalues outputvalues = listOrderByUserUseCase.execute(
                new ListOrderByUserUseCase.Inputvalues(id)
        );

        ListOrderAndUserResponse response = ListOrderAndUserResponse
                .of(outputvalues.getOrders(), outputvalues.getUser());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
