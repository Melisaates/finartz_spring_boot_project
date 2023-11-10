package com.finartz.firebase.springfirebaseproject.entity;

import com.finartz.firebase.springfirebaseproject.service.*;
import lombok.Builder;

import java.security.KeyPair;

@Builder
public class CreateUserRequest {
    private String email;
    private String userName;
    private String password;
    private String phoneNumber;

    // RSAEncryptorDecryptor sınıfından bir nesne oluşturun
    RSAEncryptorDecryptor rsaEncryptorDecryptor = new RSAEncryptorDecryptor();
    public KeyPair keyPair;

    {
        try {
            keyPair = rsaEncryptorDecryptor.generateKeyPair();
            System.out.println("oluştu keypair : " + keyPair);


        } catch (Exception e) {
            System.out.println("keypair : " + keyPair);
            throw new RuntimeException("Key pair could not be generated.", e);
        }
        System.out.println("oluştu keypair : " + keyPair);

    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getPassword()  {
        System.out.println("keypair getpassword :" + this.keyPair);
        System.out.println("pass" + this.password);
        try {

            // Çözme
            System.out.println("keypair.getPri" + keyPair.getPrivate());
            String decryptedPassword = rsaEncryptorDecryptor.decrypt(this.password, keyPair.getPrivate());
            System.out.println("D*********ecrypted Password: " + decryptedPassword);
            return decryptedPassword;
        }catch (Exception e){
            System.out.println("keypair:::::::::"+keyPair);
            System.out.println("getpasworddddddddddhataaaa");
            e.printStackTrace();
            return null;
        }

    }

    public void setPassword(String password) {
        System.out.println("passworddddddddd"+password);
        try {

            // Şifreleme
            String encryptedPassword = rsaEncryptorDecryptor.encrypt(password, keyPair.getPublic());
            System.out.println("Encrypted Password: " + encryptedPassword);

            this.password=encryptedPassword;


        } catch (Exception e) {
            System.out.println("setpasworddddddddddhataaaa");
            e.printStackTrace();
        }


    }
}
