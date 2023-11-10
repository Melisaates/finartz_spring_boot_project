package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.entity.LogInRequest;
import com.finartz.firebase.springfirebaseproject.entity.LogInResponse;
import com.finartz.firebase.springfirebaseproject.entity.User;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;

public class RSAEncryptorDecryptor {
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        System.out.println("pairrrrrrrrrrrrr:::::::"+ keyPairGenerator.generateKeyPair().getPrivate());
        System.out.println("pairrrrrrrrrrrrr:::::::"+ keyPairGenerator.generateKeyPair().getPublic());

        return keyPairGenerator.generateKeyPair();
    }

    public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(encryptedText);
        Cipher decryptCipher = Cipher.getInstance("RSA");
        decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(decryptCipher.doFinal(bytes));
    }

 /*   // LogInRequest şifreleme
    public static String encryptPassword(LogInRequest user, PublicKey publicKey) throws Exception {
        String encryptedPassword = encrypt(user.getPassword(), publicKey);
        user.setPassword(encryptedPassword);
        return encryptedPassword;
    }

    // LogInResponse çözme
    public static String decryptPassword(LogInResponse user, PrivateKey privateKey) throws Exception {
        String decryptedPassword = decrypt(user.getToken(), privateKey);
        user.setToken(decryptedPassword);
        return decryptedPassword;
    }
*/
}
