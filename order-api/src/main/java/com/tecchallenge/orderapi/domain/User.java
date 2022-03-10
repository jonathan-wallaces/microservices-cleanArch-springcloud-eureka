package com.tecchallenge.orderapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

import java.time.LocalDateTime;
@RequiredArgsConstructor
@Getter
@Value
public class User {

    private Long id;
    private String name;
    private Long cpf;
    private String email;
    private Long phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
