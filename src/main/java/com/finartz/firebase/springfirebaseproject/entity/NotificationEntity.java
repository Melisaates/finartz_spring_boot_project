package com.finartz.firebase.springfirebaseproject.entity;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationEntity {

    private String title;
    private String message;
    private String topic;
    private String token;

    private long senderId;

}
