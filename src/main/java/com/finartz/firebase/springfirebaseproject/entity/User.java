package com.finartz.firebase.springfirebaseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name="users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;

    @JsonIgnore

    @Column(name="user_interests")
    private String userInterests;

    @JsonIgnore
    @Column(name="phone_number")
    private String phoneNumber;



    public User(String userName, String email, String password, String userInterests, String phoneNumber) {
        super();
        this.userName = userName;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
