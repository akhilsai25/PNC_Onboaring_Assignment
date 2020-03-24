package com.pnc.aggregateservice.api;

import com.pnc.aggregateservice.client.AccountClient;
import com.pnc.aggregateservice.domain.User;
import com.pnc.aggregateservice.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/getDetails")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping
    public ResponseEntity<ApiStatus> getUsers(){
        return ResponseEntity.ok().body(userDetailsService.getUsers());
    }

    @GetMapping("/{userid}")
    public ResponseEntity<ApiStatus> getUsersById(@PathVariable  long userid){
        return ResponseEntity.ok().body(userDetailsService.getUserById(userid));
    }

    @PostMapping
    public ResponseEntity<ApiStatus> postUsersById(@PathVariable User user){
        userDetailsService.postUsersAndAccounts(user);
        return ResponseEntity.ok().build();
    }
}
