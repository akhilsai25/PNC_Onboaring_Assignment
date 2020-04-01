package com.pnc.accountservice.controller;

import com.pnc.accountservice.api.AccountsController;
import com.pnc.accountservice.domain.Account;
import com.pnc.accountservice.service.AccountsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class Testing_User {

    @InjectMocks
    AccountsController accountsController;

    @Mock
    AccountsService accountsService;

    @Test
    public void when_fetching_accounts_for_user(){
        List<Account> accounts = new ArrayList();
        Mockito.when(accountsService.findByUserId(4)).thenReturn(accounts);
        Assertions.assertThrows(ResponseStatusException.class,() ->accountsController.getByUserId(4));
    }

    @Test
    public void when_fetching_all_accounts(){
        List<Account> accounts = new ArrayList();
        Mockito.when(accountsService.getAllAccounts()).thenReturn(accounts);
        Assertions.assertThrows(ResponseStatusException.class,() ->accountsController.getAllAccounts());
    }
}
