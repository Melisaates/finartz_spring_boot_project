package com.finartz.firebase.springfirebaseproject.repository;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
User findByUserName(String name);

}
/*
    @Autowired
    
    private final CollectionReference usersCollection;
    private final Firestore firestore;


    private FirebaseApp firebaseApp;

    // Establish a connection with Firebase
        private void fireBaseConnector() {
        firebaseApp.getInstance();
    }


    public UserRepo() {
        try {
           firestore=FirestoreClient.getFirestore();



            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            this.usersCollection = firestore.collection("Users");
        } catch (Exception e) {
            // Log the exception for debugging purposes
            e.printStackTrace();
            // Rethrow the exception or handle it appropriately based on your needs
            throw new RuntimeException("Error initializing UserRep*************************************************o", e);
        }
    }

    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            ApiFuture<QuerySnapshot> query = usersCollection.get();

            for (QueryDocumentSnapshot document : query.get().getDocuments()) {
                userList.add(document.toObject(User.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public Optional<User> findById(java.util.UUID id) {
        try {
            DocumentSnapshot document = usersCollection.document(id.toString()).get().get();

            if (document.exists()) {
                return Optional.of(document.toObject(User.class));
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }


    public void delete(User user) {

            usersCollection.document(String.valueOf(user.getId())).delete();

    }

    public User findByName(String name) {
        try {
            DocumentSnapshot document = usersCollection.whereEqualTo("name", name).get().get().getDocuments().get(0);

            if (document.exists()) {
                return document.toObject(User.class);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User save(User user) {
        DocumentReference documentReference = null;
        try {
            documentReference = usersCollection.add(user).get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        //user.setId(java.util.UUID.fromString(documentReference.getId()));
        user.setId(Integer.valueOf(documentReference.getId()));
        return user;
    }
}*/