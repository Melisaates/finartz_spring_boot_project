package com.finartz.firebase.springfirebaseproject.service.inf;

import com.finartz.firebase.springfirebaseproject.requests.PushNotificationRequest;

public interface IPushNotificationService {
    public void sendNotificationToToken(PushNotificationRequest request);
}
