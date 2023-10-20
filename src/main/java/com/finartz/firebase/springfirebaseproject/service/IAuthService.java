package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.UserRecordDTO;
import com.google.firebase.FirebaseException;

public interface IAuthService {
    UserRecordDTO createUser(UserRecordDTO userRecordDTO) throws FirebaseException;
}
