package com.finartz.firebase.springfirebaseproject.service.impl;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;


public class RSAEncryptorDecryptor {
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        System.out.println("pairrrrrrrrrrrrr:::::::"+ keyPair.getPrivate());
        System.out.println("pairrrrrrrrrrrrr:::::::"+ keyPair.getPublic());

        return keyPair;
    }

    public static String encrypt(String plaintext, PublicKey publicKey) throws Exception {
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        byte[] cipherText = encryptCipher.doFinal(plaintext.getBytes());
        return Base64.getEncoder().encodeToString(cipherText);
    }

    public static String decrypt(String encryptedText, PrivateKey privateKey) throws Exception {
        byte[] bytes = Base64.getDecoder().decode(encryptedText);
        KeyPair keyPair=generateKeyPair();

        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] cipherbyte = cipher.doFinal(bytes);
        return new String(cipherbyte);
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
