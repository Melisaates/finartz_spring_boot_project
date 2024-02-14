package com.finartz.firebase.springfirebaseproject.responses;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.finartz.firebase.springfirebaseproject.models.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private int userId;
    private String userName;
    private String phoneNumber;
    private String email;
    private String userInterests;



    public UserResponse(UserDto userDTO){
        this.userId = userDTO.getUserId();
        this.userName = userDTO.getName();
        this.phoneNumber = userDTO.getPhoneNumber();
        this.email = userDTO.getEmail();
        this.userInterests = userDTO.getUserInterests();
        
    }

  
}
