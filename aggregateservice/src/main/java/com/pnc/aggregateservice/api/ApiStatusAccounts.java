package com.pnc.aggregateservice.api;

import com.pnc.aggregateservice.domain.Account;
import com.pnc.aggregateservice.domain.User;

import java.util.HashMap;
import java.util.List;

public class ApiStatusAccounts {
    private String status;
    private HashMap<String, List<Account>> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, List<Account>> getData() {
        return data;
    }

    public void setData(HashMap<String, List<Account>> data) {
        this.data = data;
    }
}
