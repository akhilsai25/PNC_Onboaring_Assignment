package com.pnc.accountservice.service;

import com.pnc.accountservice.domain.Account;
import com.pnc.accountservice.repository.AccountsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {

    @Autowired
    private AccountsRepository accountsRepository;

    public List<Account> getAccountsBySSN(long ssn){
        return accountsRepository.findBySsn(ssn);
    }

    public List<Account> getAccountsById(long id) {
        return accountsRepository.findByUserid(id);
    }


    public List<Account> findByUserId(long id) {
        return accountsRepository.findByUserid(id);
    }

    public List<Account> save(List<Account> account) {
       return accountsRepository.saveAll(account);
    }

    public List<Account> getAllAccounts() {
        return accountsRepository.findAll();
    }
}
