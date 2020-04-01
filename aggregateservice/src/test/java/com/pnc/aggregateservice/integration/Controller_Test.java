package com.pnc.aggregateservice.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pnc.aggregateservice.AggregateserviceApplication;
import com.pnc.aggregateservice.api.ApiStatus;
import com.pnc.aggregateservice.domain.Account;
import com.pnc.aggregateservice.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest(classes = AggregateserviceApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Controller_Test {


        @LocalServerPort
        private int port;
        @Autowired
        private TestRestTemplate testRestTemplate;
        private ObjectMapper objectMapper = new ObjectMapper();

        @Test
        public void testGetAll(){
            ResponseEntity<ApiStatus> jSendDtoResponseEntity =
                    testRestTemplate.getForEntity("http://localhost:"+port+"/getDetails", ApiStatus.class);
              Assertions.assertTrue(jSendDtoResponseEntity.getStatusCode()== HttpStatus.OK);
        }

        @Test
        public void testSaveUserAndAccounts(){

            User user = new User();
            user.setSsn(25253);
            user.setFirst_name("akhilesh");
            user.setLast_name("saiesh");
            user.setPhone(25252425);
            user.setAddress("address12");

            List<Account> accounts = new ArrayList<>();
            Account account1 = new Account();
            account1.setAccount_type("credit");
            account1.setCard_issued(true);
            account1.setCard_no(3535);
            account1.setAccount_no(2424242);
            accounts.add(account1);

            user.setAccountList(accounts);
            ResponseEntity<ApiStatus> jSendDtoResponseEntity =
                    testRestTemplate.postForEntity("http://localhost:"+port+"/getDetails",user,ApiStatus.class);

            Assertions.assertTrue(jSendDtoResponseEntity.getStatusCode()==HttpStatus.OK);
        }
    }