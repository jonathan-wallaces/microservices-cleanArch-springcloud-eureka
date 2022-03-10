package com.tecchallenge.userapi.adapter.out.persistence;

import com.tecchallenge.userapi.application.port.out.UserPort;
import com.tecchallenge.userapi.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserPersistenceAdapter implements UserPort {
    private final UserRepository userRepository;
    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public Boolean validateUser(Long cpf) {
      return userRepository.existsByCpf(cpf);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User don´t exists!!!"));
    }

    @Override
    public User findUserByCpf(Long cpf) {
        return userRepository.findByCpf(cpf);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }


}
