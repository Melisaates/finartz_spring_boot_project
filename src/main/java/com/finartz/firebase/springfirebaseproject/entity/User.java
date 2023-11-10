package com.finartz.firebase.springfirebaseproject.entity;

public class User {
    private String userName;
    private String email;
    private String password;
    private String userInterests;
    private String phoneNumber;

    public User(String user_name, String email, String password, String userInterests, String phoneNumber) {
        this.userName = user_name;
        this.email = email;
        this.password = password;
        this.userInterests = userInterests;
        this.phoneNumber = phoneNumber;
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
