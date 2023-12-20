package com.finartz.firebase.springfirebaseproject.controller;

import com.finartz.firebase.springfirebaseproject.requests.PushNotificationRequest;
import com.finartz.firebase.springfirebaseproject.responses.NotificationResponse;
import com.finartz.firebase.springfirebaseproject.service.IPushNotificationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class NotifiController {

    private IPushNotificationService notificationService;


    public NotifiController(IPushNotificationService notificationService) {
        this.notificationService = notificationService;
    }


    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {

        System.out.println(":::::::::::::::::::" + request);
        notificationService.sendNotificationToToken(request);

        System.out.println("print");
        return new ResponseEntity<>(new NotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

}
