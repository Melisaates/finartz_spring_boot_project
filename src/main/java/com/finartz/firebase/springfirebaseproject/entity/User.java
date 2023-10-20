package com.finartz.firebase.springfirebaseproject.entity;

public class User {
    private String user_name;
    private String email;

    private String password;
    private String user_interests;
    private String phoneNumber;

    public User(String user_name, String email, String password, String user_interests, String phoneNumber) {
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.user_interests = user_interests;
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUser_interests() {
        return user_interests;
    }

    public void setUser_interests(String user_interests) {
        this.user_interests = user_interests;
    }
}
