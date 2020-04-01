package com.pnc.aggregateservice.api;

import com.pnc.aggregateservice.domain.User;
import com.pnc.aggregateservice.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/userservice")
public class UserDetailsController {

    @Autowired
    UserDetailsService userDetailsService;

    @GetMapping("/getAll")
    public ResponseEntity<ApiStatus> getUsers(){
        return ResponseEntity.ok().body(userDetailsService.getUsers());
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<ApiStatus> getUsersById(@PathVariable  long userid){
        return ResponseEntity.ok().body(userDetailsService.getUserById(userid));
    }

    @PostMapping("/postUser")
    public ResponseEntity<ApiStatus> postUsersById(@RequestBody User user){
        userDetailsService.postUsersAndAccounts(user);
        return ResponseEntity.ok().build();
    }
}
