package com.finartz.firebase.springfirebaseproject.entity;

public class LogInResponse {
    private String token;

    private String message;

    public LogInResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
