package com.finartz.firebase.springfirebaseproject.service.inf;

import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.requests.LogInRequest;
import com.finartz.firebase.springfirebaseproject.responses.CreateUserResponse;
import com.finartz.firebase.springfirebaseproject.responses.LogInResponse;

public interface IAuthService {
    CreateUserResponse createUser(CreateUserRequest createUserRequest) throws Exception;

    LogInResponse authenticateUser(LogInRequest logInRequest) throws Exception;
}
