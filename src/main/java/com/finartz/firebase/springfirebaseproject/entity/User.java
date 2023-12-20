package com.finartz.firebase.springfirebaseproject.entity;

import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;


@Builder
public class User {

    private UUID id;
    private String userName;
    private String email;
    private String password;
    private String userInterests;
    private String phoneNumber;



    public User(UUID id, String user_name, String email, String password, String userInterests, String phoneNumber) {
        this.userName = user_name;
        this.email = email;
        this.password = password;
        this.userInterests = userInterests;
        this.phoneNumber = phoneNumber;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(CreateUserRequest createUserRequest) {

        this.phoneNumber = createUserRequest.getPhoneNumber();
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(CreateUserRequest createUserRequest) throws Exception {

        this.password = createUserRequest.getPassword();
    }
    public String getUserName() {
        return userName;
    }


    public void setUserName(CreateUserRequest createUserRequest) {

        this.userName = createUserRequest.getUserName();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(CreateUserRequest createUserRequest) {

        this.email = createUserRequest.getUserName();
    }

    public String getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(String userInterests) {
        this.userInterests = userInterests;
    }


}
