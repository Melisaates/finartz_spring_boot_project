package com.finartz.firebase.springfirebaseproject.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@Builder
public class NotificationDTO {
    private UUID notificationID;
    private String topic;
    private String title;
    private String text;

}
