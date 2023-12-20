package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.requests.LogInRequest;
import com.finartz.firebase.springfirebaseproject.responses.LogInResponse;
import com.finartz.firebase.springfirebaseproject.service.*;
import com.finartz.firebase.springfirebaseproject.service.ILogIn;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AuthController {

    private IAuthService authService;
    private ILogIn logIn;


    public AuthController( IAuthService authService, ILogIn logIn) {
        this.authService = authService;
        this.logIn = logIn;
    }


    @PostMapping("/logIn")
    public LogInResponse validateLoginRequest (@RequestBody LogInRequest logInRequest){
        return logIn.validateLoginRequest(logInRequest);
    }


    @PostMapping("/create")
    public CreateUserRequest createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {
        return authService.createUser(createUserRequest);
    }

}
