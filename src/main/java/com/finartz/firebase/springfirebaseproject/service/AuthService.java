package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.UserRecordDTO;
import com.google.firebase.FirebaseException;
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
    public UserRecordDTO createUser(UserRecordDTO userRecordDTO) throws FirebaseAuthException {
        fireBaseConnector();
        UserRecord.CreateRequest createRequest=new UserRecord.CreateRequest();
        createRequest.setEmail(userRecordDTO.getEmail());
        createRequest.setPassword("the_best_developer_MELİSA_ATEŞ");
        createRequest.setDisplayName(userRecordDTO.getUser_name());
        createRequest.setPhoneNumber(userRecordDTO.getPhoneNumber());
        return buildUserRecord(auth.createUser(createRequest));
    }

    private UserRecordDTO buildUserRecord(UserRecord userRecord) {
        return UserRecordDTO.builder()
                .email(userRecord.getEmail())
                .user_name(userRecord.getDisplayName())
                .phoneNumber(userRecord.getPhoneNumber())
                .build();

    }
}
