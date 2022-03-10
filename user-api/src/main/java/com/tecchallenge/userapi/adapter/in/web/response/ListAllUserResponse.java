package com.tecchallenge.userapi.adapter.in.web.response;

import com.tecchallenge.userapi.domain.User;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Value
public class ListAllUserResponse {
    private String name;
    private Long cpf;
    private String email;
    private Long phoneNumber;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static List<ListAllUserResponse> of (List<User> users){
        return users.stream()
                .map(ListAllUserResponse::of)
                .collect(Collectors.toList());
    }

    public static ListAllUserResponse of(User user){
        return new ListAllUserResponse(
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}
