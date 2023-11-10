package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.CreateUserRequest;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import org.springframework.stereotype.Service;


@Service
public class AuthService implements IAuthService{

    private FirebaseAuth auth;

    private void fireBaseConnector(){
        auth=FirebaseAuth.getInstance();
    }

    @Override
    public CreateUserRequest createUser(CreateUserRequest createUserRequest) throws Exception {
        fireBaseConnector();
        UserRecord.CreateRequest createRequest=new UserRecord.CreateRequest();
        createRequest.setEmail(createUserRequest.getEmail());
        createRequest.setPassword(createUserRequest.getPassword());
        createRequest.setDisplayName(createUserRequest.getUserName());
        createRequest.setPhoneNumber(createUserRequest.getPhoneNumber());
        return buildUserRecord(auth.createUser(createRequest));
    }

    private CreateUserRequest buildUserRecord(UserRecord userRecord) {
        return CreateUserRequest.builder()
                .email(userRecord.getEmail())
                .userName(userRecord.getDisplayName())
                .phoneNumber(userRecord.getPhoneNumber())
                .build();

    }
}
