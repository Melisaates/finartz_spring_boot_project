package com.finartz.firebase.springfirebaseproject.controller;

import com.finartz.firebase.springfirebaseproject.entity.*;
import com.finartz.firebase.springfirebaseproject.service.IAuthService;
import com.finartz.firebase.springfirebaseproject.service.ILogIn;
import com.finartz.firebase.springfirebaseproject.service.IPushNotificationService;
import com.finartz.firebase.springfirebaseproject.service.PushNotificationService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class NotifiController {

    private IPushNotificationService pushNotificationService;


    public NotifiController(IPushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }


    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {

        System.out.println(":::::::::::::::::::" + request);
        pushNotificationService.sendPushNotificationToToken(request);

        System.out.println("print");
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }

}
