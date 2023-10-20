package com.finartz.firebase.springfirebaseproject.entity;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.*;


public class PushNotificationRequest {
    private String title;
    private String message;
    private String topic;
    private String token;

    private long senderId;

    public PushNotificationRequest(){
        super();
    }


    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    public PushNotificationRequest(String title, String message, String topic, String token, long senderId) {
        super();
        this.title = title;
        this.message = message;
        this.topic = topic;
        this.token = token;
        this.senderId=senderId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
