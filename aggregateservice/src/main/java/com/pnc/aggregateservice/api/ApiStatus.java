package com.pnc.aggregateservice.api;


import com.pnc.aggregateservice.domain.User;

import java.util.HashMap;
import java.util.List;

public class ApiStatus {

    private String status;
    private HashMap<String, List<User>> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HashMap<String, List<User>> getData() {
        return data;
    }

    public void setData(HashMap<String, List<User>> data) {
        this.data = data;
    }
}
