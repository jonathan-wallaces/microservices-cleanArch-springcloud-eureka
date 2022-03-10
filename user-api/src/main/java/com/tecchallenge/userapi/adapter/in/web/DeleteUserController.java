package com.tecchallenge.userapi.adapter.in.web;

import com.tecchallenge.userapi.application.DeleteUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Tag(name="User Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/users")
public class DeleteUserController {
    private final DeleteUserUseCase deleteUserUseCase;

    @Operation(summary = "Delete a specific user by your Id")
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void execute(@Valid @PathVariable Long id){
        deleteUserUseCase.execute(
                new DeleteUserUseCase.Inputvalues(id)
        );
    }
}
