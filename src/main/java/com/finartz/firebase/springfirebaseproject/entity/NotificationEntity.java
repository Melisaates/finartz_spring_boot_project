package com.finartz.firebase.springfirebaseproject.entity;


import lombok.*;

@Data
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEntity {

    private String title;
    private String message;
    private String topic;
    private String token;

    private long senderId;

}
