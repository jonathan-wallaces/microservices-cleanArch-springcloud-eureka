package com.tecchallenge.orderapi.core;

import com.tecchallenge.orderapi.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-api")
public interface OrderProxy {

    @GetMapping("/users/{id}")
    User getUserById(@PathVariable Long id);
}
