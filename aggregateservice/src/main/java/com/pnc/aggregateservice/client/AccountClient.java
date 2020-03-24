package com.pnc.aggregateservice.client;

import com.pnc.aggregateservice.api.ApiStatus;
import com.pnc.aggregateservice.api.ApiStatusAccounts;
import com.pnc.aggregateservice.domain.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name="accounts-client",url = "${accounts.service.host}")
public interface AccountClient {

    @GetMapping(value = "/accounts")
    ResponseEntity<ApiStatusAccounts> getAccounts();

    @GetMapping(value = "/accounts/{userid}")
    ResponseEntity<ApiStatusAccounts> getAccountsByUserId(@PathVariable long userid);

    @PostMapping
    ResponseEntity<HttpStatus> saveAccountsById(@RequestBody List<Account> account);

    @PostMapping
    ResponseEntity<HttpStatus> savetAccounts(@RequestBody List<Account> accounts);
}
