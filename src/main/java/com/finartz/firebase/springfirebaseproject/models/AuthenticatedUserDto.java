package com.finartz.firebase.springfirebaseproject.models;

import lombok.Builder;



@Builder
public class AuthenticatedUserDto {
    private int id;
    private String userName;
    private String email;
    private String userInterests;
    private String phoneNumber;
    //passwordı değiştir unutma şifreli tutulucak.
    private String jwt;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(String userInterests) {
        this.userInterests = userInterests;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getToken() {
        return jwt;
    }

    public void setToken(String jwt) {
        this.jwt = jwt;
    }
}
