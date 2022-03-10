package com.tecchallenge.orderapi.adapter.in.web;

import com.tecchallenge.orderapi.application.DeleteOrderUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Tag(name="Order Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/orders")
public class DeleteOrderController {
    private final DeleteOrderUseCase deleteOrderUseCase;

    @Operation(summary = "Delete a specific order by your Id")
    @DeleteMapping(path = "{/id}")
    public void execute(@Valid @PathVariable Long id){
        deleteOrderUseCase.execute(
                new DeleteOrderUseCase.Inputvalues(id)
        );
    }
}
