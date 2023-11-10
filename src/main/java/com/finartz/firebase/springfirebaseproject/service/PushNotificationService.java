package com.finartz.firebase.springfirebaseproject.service;
import com.finartz.firebase.springfirebaseproject.entity.PushNotificationRequest;
import org.slf4j.*;
import org.springframework.stereotype.Service;

@Service
public class PushNotificationService implements IPushNotificationService{

    private Logger logger = (Logger) LoggerFactory.getLogger(PushNotificationService.class);

    private FCMService fcmService;

    public PushNotificationService(FCMService fcmService){
        this.fcmService=fcmService;
    }
    public void sendPushNotificationToToken(PushNotificationRequest request){
        try{
            System.out.println("********************");
            fcmService.sendMessageToToken(request);
        } catch(Exception e){
            logger.error(e.getMessage());
        }
    }

}