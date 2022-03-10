package com.tecchallenge.userapi.adapter.in.web;

import com.tecchallenge.userapi.adapter.in.web.response.ListAllUserResponse;
import com.tecchallenge.userapi.application.ListAllUserUseCase;
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

@Tag(name="User Controller")
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping(path = "/users")
public class ListAllUserController {
    private final ListAllUserUseCase listAllUserUseCase;

    @Operation(summary = "List all users")
    @GetMapping(path = "/list-all")
    public ResponseEntity<List<ListAllUserResponse>> execute(){
        ListAllUserUseCase.OutputValues outputValues = listAllUserUseCase.execute(
                new ListAllUserUseCase.Inputvalues()
        );
        List<ListAllUserResponse> response = ListAllUserResponse.of(outputValues.getUsers());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
