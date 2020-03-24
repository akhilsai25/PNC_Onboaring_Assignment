package com.pnc.onboarding.service;

import com.pnc.onboarding.domain.User;
import com.pnc.onboarding.repository.UsersRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class When_Retrieving_User_From_Service {


    @InjectMocks
    UsersService usersService;

    @Mock
    UsersRepository usersRepository;

    @Test
    public void user_id_is_Required(){
        //UsersService usersService = new UsersService();
        User user1=new User("akhil","sai");
        User user2=new User("a","s");
        List<User> users =new ArrayList<>();
        users.add(user1);
        users.add(user2);
        Mockito.when(usersRepository.findAll()).thenReturn(users);
        Assertions.assertEquals(2,usersService.getUsers().size());
    }

}
