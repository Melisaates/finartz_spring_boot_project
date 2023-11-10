package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.PushNotificationRequest;

public interface IPushNotificationService {
    public void sendPushNotificationToToken(PushNotificationRequest request);
}
