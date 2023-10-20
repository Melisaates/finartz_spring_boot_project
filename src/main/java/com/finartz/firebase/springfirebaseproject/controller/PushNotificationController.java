package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.entity.PushNotificationRequest;
import com.finartz.firebase.springfirebaseproject.entity.PushNotificationResponse;
import com.finartz.firebase.springfirebaseproject.service.*;
import org.springframework.http.HttpStatus;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushNotificationController {
	
	
    private PushNotificationService pushNotificationService;
    
    public PushNotificationController(PushNotificationService pushNotificationService) {
        this.pushNotificationService = pushNotificationService;
    }
    
    @PostMapping("/notification/token")
    public ResponseEntity sendTokenNotification(@RequestBody PushNotificationRequest request) {

        System.out.println(":::::::::::::::::::"+request);
        pushNotificationService.sendPushNotificationToToken(request);

        System.out.println("print");
        return new ResponseEntity<>(new PushNotificationResponse(HttpStatus.OK.value(), "Notification has been sent."), HttpStatus.OK);
    }
    
}
