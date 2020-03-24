package com.pnc.aggregateservice.service;

import com.pnc.aggregateservice.api.ApiStatus;
import com.pnc.aggregateservice.api.ApiStatusAccounts;
import com.pnc.aggregateservice.client.AccountClient;
import com.pnc.aggregateservice.client.UserClient;
import com.pnc.aggregateservice.domain.Account;
import com.pnc.aggregateservice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UserDetailsService {

    @Autowired
    UserClient userClient;

    @Autowired
    AccountClient accountClient;

    public ApiStatus getUsers(){
        ApiStatus apiStatus = userClient.getUsers().getBody();
        if(apiStatus.getStatus().equals("false"))
        {

        }
        List<User> users = apiStatus.getData().get("users");
        ApiStatusAccounts apiStatus2 = accountClient.getAccounts().getBody();
        List<Account> accounts = apiStatus2.getData().get("accounts");
        HashMap<Long,List<Account>> accountsf=new HashMap<>();
        accounts.stream().forEach(p->{
            if(!accountsf.containsKey(p.getUserid())){
                List<Account> acc=new ArrayList<>();
                acc.add(p);
                accountsf.put(p.getUserid(),acc);
            }
            else
                accountsf.get(p.getUserid()).add(p);
        });
        users.stream().forEach(p->{
            p.setAccountList(accountsf.get(p.getId()));
        });


        return apiStatus;
    }

    public ApiStatus getUserById(long id){
        ApiStatus apiStatus = userClient.getUserById(id).getBody();
        List<User> users = apiStatus.getData().get("user");
        ApiStatusAccounts apiStatus2 = accountClient.getAccountsByUserId(id).getBody();
        List<Account> accounts = apiStatus2.getData().get("account");
        HashMap<Long,List<Account>> accountsf=new HashMap<>();
        accounts.stream().forEach(p->{
            if(!accountsf.containsKey(p.getUserid())){
                List<Account> acc=new ArrayList<>();
                acc.add(p);
                accountsf.put(p.getUserid(),acc);
            }
            else
                accountsf.get(p.getUserid()).add(p);
        });
        users.stream().forEach(p->{
            p.setAccountList(accountsf.get(p.getId()));
        });


        return apiStatus;
    }

    public void postUsersAndAccounts(User user) {

        List<Account> accounts = user.getAccountList();
        userClient.saveUser(user);
        accountClient.saveAccountsById(accounts);
    }
}
