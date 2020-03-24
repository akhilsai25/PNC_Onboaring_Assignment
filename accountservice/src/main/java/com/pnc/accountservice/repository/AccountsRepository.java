package com.pnc.accountservice.repository;

import com.pnc.accountservice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountsRepository extends JpaRepository<Account,Long> {
    public List<Account> findBySsn(long ssn);
    public List<Account> findByUserid(long user_id);
}
