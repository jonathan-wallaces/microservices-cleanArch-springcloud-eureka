package com.tecchallenge.userapi.adapter.out.persistence;

import com.tecchallenge.userapi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByCpf(Long cpf);

    User findByCpf(Long cpf);
}
