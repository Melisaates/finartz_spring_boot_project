package com.finartz.firebase.springfirebaseproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Collection;


@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name="users")
public class User implements UserDetails {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_name")
    private String userName;

    @Column(name="email")
    private String email;
    @Column(name="encryptedPassword")
    private String encryptedPassword;

    @JsonIgnore

    @Column(name="user_interests")
    private String userInterests;

    @JsonIgnore
    @Column(name="phone_number")
    private String phoneNumber;



    @JsonIgnore
    @Column(name="public_key")
    private PublicKey publicKey;

    @JsonIgnore
    @Column(name="private_key")
    private PrivateKey privateKey;


    public User(String userName, String email, String encryptedPassword, String userInterests, String phoneNumber, PublicKey publicKey, PrivateKey privateKey) {
        super();
        this.userName = userName;
        this.email = email;
        this.encryptedPassword = encryptedPassword;
        this.userInterests = userInterests;
        this.phoneNumber = phoneNumber;
        this.publicKey = publicKey;
        this.privateKey = privateKey;

    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(PrivateKey privateKey) {
        this.privateKey = privateKey;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
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


    public void setPassword(CreateUserRequest createUserRequest) throws Exception {

        this.encryptedPassword = createUserRequest.getPassword();
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


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
