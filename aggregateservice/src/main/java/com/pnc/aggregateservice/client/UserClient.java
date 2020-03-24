package com.pnc.aggregateservice.client;

import com.pnc.aggregateservice.api.ApiStatus;
import com.pnc.aggregateservice.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="users-client",url = "${user.service.host}")
public interface UserClient {

    @GetMapping(value = "/users")
    ResponseEntity<ApiStatus> getUsers();

    @GetMapping(value = "/users/getById/{id}")
    ResponseEntity<ApiStatus> getUserById(@PathVariable long id);

    @PostMapping
    ResponseEntity<ApiStatus> saveUser(@RequestBody User user);
}
