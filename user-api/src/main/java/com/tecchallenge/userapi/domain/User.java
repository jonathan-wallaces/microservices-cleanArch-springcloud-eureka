package com.tecchallenge.userapi.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@RequiredArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    private Long cpf;
    @NotNull
    private String email;
    @NotNull
    private Long phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(String name, Long cpf, String email, Long phoneNumber) {
        this.name=name;
        this.cpf=cpf;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }

    public void createdAt() {
        this.createdAt=LocalDateTime.now();
    }

    public void updatedAt(){
        this.updatedAt=LocalDateTime.now();
    }

    public void editUser(String name, Long cpf, String email, Long phoneNumber) {
        this.name=name;
        this.cpf=cpf;
        this.email=email;
        this.phoneNumber=phoneNumber;
    }
}
