package com.finartz.firebase.springfirebaseproject.requests;

import lombok.*;

@Data
@Builder
public class CreateUserRequest {
    private String email;
    private String userName;
    private String password;

    private String phoneNumber;

    public CreateUserRequest(String email, String userName, String password, String phoneNumber) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
