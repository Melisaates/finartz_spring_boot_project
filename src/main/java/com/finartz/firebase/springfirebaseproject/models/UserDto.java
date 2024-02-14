package com.finartz.firebase.springfirebaseproject.models;

import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.service.impl.RSAEncryptorDecryptor;
import lombok.Builder;

import java.security.KeyPair;
import java.util.UUID;

import static com.finartz.firebase.springfirebaseproject.service.impl.RSAEncryptorDecryptor.generateKeyPair;

@Builder
public class UserDto {
    private int userId;
    private String userName;
    private String email;
    private String password;
    private String userInterests;
    private String phoneNumber;
    private KeyPair keyPair;

    public UserDto(int userId, String userName, String email, String password, String userInterests, String phoneNumber, KeyPair keyPair) {
        try {
            this.keyPair = generateKeyPair();
            System.out.println("oluştu keypair : " + this.keyPair);
        } catch (Exception var8) {
            System.out.println("keypair : " + this.keyPair);
            throw new RuntimeException("Key pair could not be generated.", var8);
        }
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.userInterests = userInterests;
        this.phoneNumber = phoneNumber;
        this.keyPair = keyPair;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getUserInterests() {
        return userInterests;
    }

    public void setUserInterests(String userInterests) {
        this.userInterests = userInterests;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDto userDTO = (UserDto) o;

        return userId == userDTO.userId;

    }


    public String getPassword()  {
        System.out.println("keypair getpassword :" + this.keyPair);
        System.out.println("pass" + password);
        try {
            // Çözme
            System.out.println("keypair.getPri" + keyPair.getPrivate());
            System.out.println("password::::::::::::::::"+password);
            String decryptedPassword = RSAEncryptorDecryptor.decrypt(password, keyPair.getPrivate());
            System.out.println("Decrypted Password: " + decryptedPassword);

            if (decryptedPassword != null && !decryptedPassword.isEmpty()) {
                return decryptedPassword;
            } else {
                System.out.println("Decrypted password is null or empty.");
                return null;
            }
        } catch (Exception e) {
            System.out.println("keypair:::::::::"+keyPair);
            System.out.println("getpassworddddddddddhataaaa");
            e.printStackTrace();
            return null;
        }
    }


    public void setPassword(CreateUserRequest createUserRequest) {
        System.out.println("passworddddddddd"+createUserRequest.getPassword());
        try {

            // Şifreleme
        String encryptedPassword = RSAEncryptorDecryptor.encrypt(createUserRequest.getPassword(), keyPair.getPublic());
            System.out.println("Encrypted Password: " + encryptedPassword);

            this.password=encryptedPassword;


        } catch (Exception e) {
            System.out.println("setpasworddddddddddhataaaa");
            e.printStackTrace();
        }

    }
}

