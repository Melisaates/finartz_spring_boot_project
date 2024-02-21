package com.finartz.firebase.springfirebaseproject.service.inf;

import com.finartz.firebase.springfirebaseproject.requests.LogInRequest;
import com.finartz.firebase.springfirebaseproject.responses.LogInResponse;


public interface ILogIn {
    LogInResponse validateLoginRequest (LogInRequest logInRequest) throws Exception;


}
