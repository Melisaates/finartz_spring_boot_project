package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.CreateUserRequest;
import com.google.firebase.auth.FirebaseAuthException;

public interface IAuthService {
    CreateUserRequest createUser(CreateUserRequest createUserRequest) throws Exception;
}
