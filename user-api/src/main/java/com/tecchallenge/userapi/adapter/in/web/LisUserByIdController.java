package com.tecchallenge.userapi.adapter.in.web;

import com.tecchallenge.userapi.adapter.in.web.response.ListAllUserResponse;
import com.tecchallenge.userapi.application.ListUserByIdUseCase;
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

import javax.validation.Valid;

@Tag(name="User Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/users")
public class LisUserByIdController {
    private final ListUserByIdUseCase listUserByIdUseCase;

    @Operation(summary = "list a specific user by your Id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ListAllUserResponse> execute(@Valid @PathVariable Long id){
        ListUserByIdUseCase.OutputValues outputValues = listUserByIdUseCase.execute(
                new ListUserByIdUseCase.InputValues(id)
        );
        ListAllUserResponse response = ListAllUserResponse.of(outputValues.getUser());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
