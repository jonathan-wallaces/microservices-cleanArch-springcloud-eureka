package com.tecchallenge.userapi.application.port.out;

import com.tecchallenge.userapi.domain.User;

import java.util.List;

public interface UserPort {
    void saveUser(User user);
    Boolean validateUser(Long cpf);

    User findUserById(Long id);
    User findUserByCpf(Long cpf);

    List<User> findAllUsers();
    void deleteUser(User user);
}
