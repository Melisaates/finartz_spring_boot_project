package com.finartz.firebase.springfirebaseproject.requests;

public class LogInRequest {
    private String userName;
    private String password;



    public LogInRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;

    }

    public String getUserName() {
        return userName;
    }

    public void setEmail(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
