package com.pnc.onboarding.controller;


import com.pnc.onboarding.api.UsersController;
import com.pnc.onboarding.domain.User;
import com.pnc.onboarding.service.UsersService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class When_Retrieving_User_From_Controller {

    @Mock
    UsersService usersService;

    @InjectMocks
    UsersController usersController;

    @Test
    public void userId_Not_Exists()
    {
        User user=null;
        Optional<User> user_optional =Optional.empty();
        Mockito.when(usersService.getUserById(6)).thenReturn(user_optional);
        Assertions.assertThrows(ResponseStatusException.class,() -> usersController.getUsersById(6));
    }

}
