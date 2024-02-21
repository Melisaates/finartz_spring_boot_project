package com.finartz.firebase.springfirebaseproject.responses;

import com.finartz.firebase.springfirebaseproject.models.AuthenticatedUserDto;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class LogInResponse {
    private int id;
    private String userName;
    private String email;
    private String userInterests;
    private String phoneNumber;
    //passwordı değiştir unutma şifreli tutulucak.
    private String password;
    private String token;

    private String message;

    public LogInResponse(AuthenticatedUserDto authResponseDTO) {
        this.id = authResponseDTO.getId();
        this.userName = authResponseDTO.getUserName();
        this.userInterests = authResponseDTO.getUserInterests();
        this.email = authResponseDTO.getEmail();
        this.phoneNumber = authResponseDTO.getPhoneNumber();
        this.token = authResponseDTO.getToken();
    }


    public LogInResponse(String token, String login_message) {
        this.token=token;

    }

    public LogInResponse() {

    }
}
