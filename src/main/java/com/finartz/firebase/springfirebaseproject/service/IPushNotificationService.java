package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.requests.PushNotificationRequest;

public interface IPushNotificationService {
    public void sendNotificationToToken(PushNotificationRequest request);
}
