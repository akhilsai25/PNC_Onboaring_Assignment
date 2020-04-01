package com.pnc.onboarding.api;

import com.pnc.onboarding.domain.User;
import com.pnc.onboarding.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    private ResponseEntity<ApiStatus> getUsers(){

        List<User> users = usersService.getUsers();
       // if(users.size()==0)
            //logic for returning no users available
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String,Object> map = new HashMap();
        map.put("users",users);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }

    @GetMapping(value = "/getById/{id}")
    public ResponseEntity<ApiStatus> getUsersById(@PathVariable long id) throws ResponseStatusException{

        Optional<User> user = usersService.getUserById(id);
        if(!user.isPresent())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"record not found for the given ID:"+id);
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String,Object> map = new HashMap();
        List<User> userlist = new ArrayList<>();
        userlist.add(user.get());
        map.put("user",userlist);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }

    @PostMapping("/users")
    private ResponseEntity<ApiStatus> saveUsers(@RequestBody  List<User> users){

        List<User> savedUsers;
        savedUsers = usersService.saveUsers(users);
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String,Object> map = new HashMap();
        map.put("users",savedUsers);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }

    @PostMapping
    private ResponseEntity<ApiStatus> saveUsersById(@RequestBody User user){

        User savedUser;
        savedUser = usersService.saveUser(user);
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String,Object> map = new HashMap();
        map.put("user",savedUser);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }
}
