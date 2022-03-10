package com.tecchallenge.userapi.adapter.in.web;

import com.tecchallenge.userapi.application.SaveUserUseCase;
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
public class SaveUserController {
    private final SaveUserUseCase saveUserUseCase;

    @Operation(summary = "Save a user")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void execute(@Valid @RequestBody SaveUserRequest saveUserRequest){
        saveUserUseCase.execute(
                new SaveUserUseCase.Inputvalues(
                        saveUserRequest.getName(),
                        saveUserRequest.getCpf(),
                        saveUserRequest.getEmail(),
                        saveUserRequest.getPhoneNumber()
                )
        );
    }

    @Value
    private static class SaveUserRequest{
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
