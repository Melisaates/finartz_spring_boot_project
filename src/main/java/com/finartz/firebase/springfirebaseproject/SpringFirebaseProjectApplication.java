package com.finartz.firebase.springfirebaseproject;

import com.finartz.firebase.springfirebaseproject.firebase.FirebaseInitialization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringFirebaseProjectApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringFirebaseProjectApplication.class, args);
		//System.out.println("99999999999999999999999999999999999999999999999999999999");
		FirebaseInitialization firebaseInitialization = new FirebaseInitialization();
		firebaseInitialization.initialization();
		System.out.println("my notification");
	}

}
