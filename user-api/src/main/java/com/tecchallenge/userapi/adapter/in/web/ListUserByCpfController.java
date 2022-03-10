package com.tecchallenge.userapi.adapter.in.web;

import com.tecchallenge.userapi.adapter.in.web.response.ListAllUserResponse;
import com.tecchallenge.userapi.application.ListUserByCpfUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Tag(name="User Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/users")
public class ListUserByCpfController {
    private final ListUserByCpfUseCase listUserByCpfUseCase;

    @Operation(summary = "List a specific user by your cpf")
    @GetMapping(path = "/list-by-cpf")
    public ResponseEntity<ListAllUserResponse> execute(@Valid @RequestBody UserCpf userCpf){
        ListUserByCpfUseCase.OutputValues outputValues = listUserByCpfUseCase.execute(
                new ListUserByCpfUseCase.InputValues(userCpf.getCpf())
        );
        ListAllUserResponse response = ListAllUserResponse.of(outputValues.getUser());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Value
    public static class UserCpf{
        @NotNull
        private Long cpf;
    }
}
