package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.requests.LogInRequest;
import com.finartz.firebase.springfirebaseproject.responses.LogInResponse;


public interface ILogIn {
    public LogInResponse validateLoginRequest (LogInRequest logInRequest);


}
