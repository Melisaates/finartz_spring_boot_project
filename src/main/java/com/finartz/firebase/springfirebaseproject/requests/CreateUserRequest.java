package com.finartz.firebase.springfirebaseproject.requests;

import com.finartz.firebase.springfirebaseproject.service.*;
import lombok.Builder;
import lombok.Data;

import java.security.KeyPair;

import static com.finartz.firebase.springfirebaseproject.service.RSAEncryptorDecryptor.generateKeyPair;

@Data
@Builder
public class CreateUserRequest {
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;


}
