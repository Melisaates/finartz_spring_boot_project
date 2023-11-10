package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.LogInRequest;
import com.finartz.firebase.springfirebaseproject.entity.LogInResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class LogIn implements ILogIn {

    // SLF4J Logger to log messages
    private static final Logger logger = LoggerFactory.getLogger(LogIn.class);

    // Firebase Authentication instance
    private FirebaseAuth firebaseAuth;

    // Establish a connection with Firebase
    private void fireBaseConnector() {
        logger.info("Connecting to Firebase...");
        firebaseAuth = FirebaseAuth.getInstance();
    }

    // Validate user login credentials and retrieve a token
    @Override
    public LogInResponse validateLoginRequest(LogInRequest logInRequest) {
        fireBaseConnector(); // Establish Firebase connection

        try {
            logger.info("Validating email and password...");
            firebaseAuth.getUserByEmail(logInRequest.getEmail());
        } catch (FirebaseAuthException e) {
            logger.error("User not found or authentication issue", e);
            return new LogInResponse("-", "Error: User not found or authentication issue");
        }

        RestTemplate restTemplate = new RestTemplate(); // Create a RestTemplate
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>(); // Prepare parameters for the POST request
        params.add("email", logInRequest.getEmail());
        params.add("password", logInRequest.getPassword());
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, null); // Create HTTP entity
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=AIzaSyD4JovPeA6oZwRefVAeBi5DYEADL58J0p4",
                HttpMethod.POST, requestEntity, String.class); // Execute POST request

        String responseBody = responseEntity.getBody(); // Get the response body

        JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject(); // Parse the response
        String token = jsonObject.get("idToken").getAsString(); // Extract the ID token

        return new LogInResponse(token, "Login successful"); // Return a response with the obtained token
    }
}
