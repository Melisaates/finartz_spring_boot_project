package com.finartz.firebase.springfirebaseproject.requests;

public class LogInRequest {
    private String userName;
    private String password;

    private String email;



    public LogInRequest(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;

    }

    public String getEmail() {
        return email;
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
