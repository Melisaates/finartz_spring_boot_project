package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.repository.dao.NotificationDAO;
import com.finartz.firebase.springfirebaseproject.requests.PushNotificationRequest;
import com.google.firebase.messaging.FirebaseMessaging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;


@Service
public class PushPushNotificationService implements IPushNotificationService {


    private Logger logger = (Logger) LoggerFactory.getLogger(PushPushNotificationService.class);


    private FCMService fcmService;

    public PushPushNotificationService(FCMService fcmService){
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