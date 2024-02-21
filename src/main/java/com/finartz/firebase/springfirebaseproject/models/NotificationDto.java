package com.finartz.firebase.springfirebaseproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Builder
public class NotificationDto {
    private int notificationID;
    private String topic;
    private String title;
    private String text;

}
