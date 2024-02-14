package com.finartz.firebase.springfirebaseproject.service.impl;
import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.finartz.firebase.springfirebaseproject.requests.PushNotificationRequest;
import com.google.firebase.messaging.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//FCM ile bildirim gönderme işlemlerini gerçekleştirmek için kullanılır.
@Service
public class FCMService {
    private Logger logger = LoggerFactory.getLogger(FCMService.class);


    public void UserRecordsendMessageToToken(PushNotificationRequest request)
            throws InterruptedException, ExecutionException {



        System.out.println("********"+request);
        Message message = getPreconfiguredMessageToToken(request);
        System.out.println(":::::::::45234::"+message);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(message);
        System.out.println("jsonoutput"+jsonOutput);
        String response = sendAndGetResponse(message);
        System.out.println("++++++++"+response);
        System.out.println("555555555555555555555555555555555");

        logger.info("***55555555555555555555555555555555555555555");
        logger.info("Sent message to token. Device token: " + request.getToken() + ", " + response+ " msg "+jsonOutput);
    }

    private String sendAndGetResponse(Message message) throws InterruptedException, ExecutionException {
        try {
            return FirebaseMessaging.getInstance().sendAsync(message).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // Hata işleme kodlarını burada ekleyin

            return "Hata: " + e.getMessage();

        }

    }


    private AndroidConfig getAndroidConfig(String topic) {
        return AndroidConfig.builder()
                .setTtl(Duration.ofMinutes(2).toMillis()).setCollapseKey(topic)
                .setPriority(AndroidConfig.Priority.HIGH)
                .setNotification(AndroidNotification.builder()
                        .setTag(topic).build()).build();
    }
    private ApnsConfig getApnsConfig(String topic) {
        return ApnsConfig.builder()
                .setAps(Aps.builder().setCategory(topic).setThreadId(topic).build()).build();
    }
    private Message getPreconfiguredMessageToToken(PushNotificationRequest request) {
        System.out.println("------------"+request.getToken());
        return getPreconfiguredMessageBuilder(request).setToken(request.getToken())
                .build();

    }
    private Message getPreconfiguredMessageWithoutData(PushNotificationRequest request) {
        return getPreconfiguredMessageBuilder(request).setTopic(request.getTopic())
                .build();
    }
    private Message getPreconfiguredMessageWithData(Map<String, String> data, PushNotificationRequest request) {
        return getPreconfiguredMessageBuilder(request).putAllData(data).setToken(request.getToken())
                .build();
    }
    private Message.Builder getPreconfiguredMessageBuilder(PushNotificationRequest request) {
        AndroidConfig androidConfig = getAndroidConfig(request.getTopic());
        ApnsConfig apnsConfig = getApnsConfig(request.getTopic());
        return Message.builder()
                .setApnsConfig(apnsConfig).setAndroidConfig(androidConfig).setNotification(
                        Notification.builder().setTitle(request.getTitle()).setBody(request.getMessage()).build()
                );
                       // new Notification(request.getTitle(), request.getMessage()));


    }

    public void sendMessageToToken(PushNotificationRequest request) {
    }
}


