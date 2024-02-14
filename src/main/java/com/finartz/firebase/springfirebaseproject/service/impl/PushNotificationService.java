package com.finartz.firebase.springfirebaseproject.service.impl;

import com.finartz.firebase.springfirebaseproject.requests.PushNotificationRequest;
import com.finartz.firebase.springfirebaseproject.service.inf.IPushNotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class PushNotificationService implements IPushNotificationService {


    private Logger logger = (Logger) LoggerFactory.getLogger(PushNotificationService.class);


    private FCMService fcmService;

    public PushNotificationService(FCMService fcmService){
        this.fcmService=fcmService;
    }
    public void sendNotificationToToken(PushNotificationRequest request){
        try{
            System.out.println("********************");
            fcmService.sendMessageToToken(request);
        } catch(Exception e){
            logger.error(e.getMessage());
        }
    }

}