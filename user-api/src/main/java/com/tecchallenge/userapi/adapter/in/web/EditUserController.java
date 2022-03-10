package com.tecchallenge.userapi.adapter.in.web;

import com.tecchallenge.userapi.application.EditUserUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Tag(name="User Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/users")
public class EditUserController {
    private final EditUserUseCase editUserUseCase;

    @Operation(summary = "Update a specific user by your Id")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void execute(@Valid @RequestBody EditUserRequest editUserRequest){
        editUserUseCase.execute(
                new EditUserUseCase.Inputvalues(
                        editUserRequest.getId(),
                        editUserRequest.getName(),
                        editUserRequest.getCpf(),
                        editUserRequest.getEmail(),
                        editUserRequest.getPhoneNumber()
                )
        );
    }


    @Value
    private static class EditUserRequest{
        @NotNull
        private Long id;
        @NotNull
        private String name;
        @NotNull
        private Long cpf;
        @NotNull
        private String email;
        @NotNull
        private Long phoneNumber;
    }
}
