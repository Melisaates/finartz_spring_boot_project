package com.finartz.firebase.springfirebaseproject.responses;

import com.finartz.firebase.springfirebaseproject.models.AuthenticatedUserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class LogInResponse {
    private UUID id;
    private String userName;
    private String email;
    private String userInterests;
    private String phoneNumber;
    //passwordı değiştir unutma şifreli tutulucak.
    private String password;
    private String token;

    public LogInResponse(AuthenticatedUserDto authResponseDTO) {
        this.id = authResponseDTO.getId();
        this.userName = authResponseDTO.getUserName();
        this.userInterests = authResponseDTO.getUserInterests();
        this.email = authResponseDTO.getEmail();
        this.password = authResponseDTO.getPassword();
        this.phoneNumber = authResponseDTO.getPhoneNumber();
        this.token = authResponseDTO.getToken();
    }


    public LogInResponse(String token, String login_message) {
        this.token=token;

    }
}
