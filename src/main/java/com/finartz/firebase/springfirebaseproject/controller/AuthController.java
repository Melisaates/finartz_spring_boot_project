package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.entity.*;
import com.finartz.firebase.springfirebaseproject.service.*;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import com.finartz.firebase.springfirebaseproject.service.ILogIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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


    @PostMapping("/user")
    public CreateUserRequest createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {
        return authService.createUser(createUserRequest);
    }

/*
    @GetMapping("/users/{id}")
    public List listUsers()
*/





}
