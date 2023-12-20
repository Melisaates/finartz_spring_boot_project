package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;

public interface IAuthService {
    CreateUserRequest createUser(CreateUserRequest createUserRequest) throws Exception;
}
