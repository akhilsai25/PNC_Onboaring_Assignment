package com.pnc.onboarding.api;

import java.util.HashMap;

public class ApiError {


    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getData() {
        return message;
    }

    public void setData(String data) {
        this.message = message;
    }

}
