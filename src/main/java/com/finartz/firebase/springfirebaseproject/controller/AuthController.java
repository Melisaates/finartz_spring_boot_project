package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.requests.LogInRequest;
import com.finartz.firebase.springfirebaseproject.responses.CreateUserResponse;
import com.finartz.firebase.springfirebaseproject.responses.LogInResponse;
import com.finartz.firebase.springfirebaseproject.service.inf.IAuthService;
import com.finartz.firebase.springfirebaseproject.service.inf.ILogIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<LogInResponse>  authenticateUser (@RequestBody LogInRequest logInRequest){
        LogInResponse response = authService.authenticateUser(logInRequest);

        if (response.getToken() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }


    }


    @PostMapping("/create")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest createUserRequest) throws Exception {
        try {
            CreateUserResponse response = authService.createUser(createUserRequest);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }    }




}
