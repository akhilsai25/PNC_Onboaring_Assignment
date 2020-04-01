package com.pnc.accountservice.api;

import com.pnc.accountservice.domain.Account;
import com.pnc.accountservice.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/accounts")
public class AccountsController {

    @Autowired
    private AccountsService accountsService;


    @GetMapping
    public ResponseEntity<ApiStatus> getAllAccounts() {
        List<Account> accounts =accountsService.getAllAccounts();
        if (accounts.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accounts not found" );
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String, Object> map = new HashMap();
        map.put("accounts", accounts);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }

    @GetMapping("/ssn/{ssn}")
    public ResponseEntity<List<Account>> getBySsn(@PathVariable long ssn) {
        return ResponseEntity.ok().body(accountsService.getAccountsBySSN(ssn));
    }

    @GetMapping("/{userid}")
    public ResponseEntity<ApiStatus> getByUserId(@PathVariable long userid) {
        List<Account> account = accountsService.findByUserId(userid);
        if (account.size() == 0)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Accounts not found for the given ID:" + userid);
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String, Object> map = new HashMap();
        map.put("account", account);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }

    @PostMapping
    private ResponseEntity<ApiStatus> saveAccounts(@RequestBody List<Account> account) {
        List<Account> savedAccounts = accountsService.save(account);
        ApiStatus apiStatus = new ApiStatus();
        apiStatus.setStatus("success");
        HashMap<String, Object> map = new HashMap();
        map.put("account", savedAccounts);
        apiStatus.setData(map);
        return ResponseEntity.ok().body(apiStatus);
    }
}