package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.LogInRequest;
import com.finartz.firebase.springfirebaseproject.entity.LogInResponse;
import org.springframework.stereotype.Service;


public interface ILogIn {
    public LogInResponse validateLoginRequest (LogInRequest logInRequest);


}
