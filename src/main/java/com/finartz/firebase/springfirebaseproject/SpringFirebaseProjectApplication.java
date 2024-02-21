package com.finartz.firebase.springfirebaseproject;

import com.finartz.firebase.springfirebaseproject.firebase.FirebaseInitialization;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringFirebaseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringFirebaseProjectApplication.class, args);
	}

	@EnableAutoConfiguration
	public static class Config {}

	/*@Bean
	public FirebaseInitialization firebaseInitialization() {
		FirebaseInitialization firebaseInitialization = new FirebaseInitialization();
		firebaseInitialization.initialization();
		return firebaseInitialization;
	}*/
}




/*@SpringBootApplication
public class SpringFirebaseProjectApplication {



	public static void main(String[] args) {
		SpringApplication.run(SpringFirebaseProjectApplication.class, args);
		//System.out.println("99999999999999999999999999999999999999999999999999999999");
		FirebaseInitialization firebaseInitialization = new FirebaseInitialization();
		firebaseInitialization.initialization();
		System.out.println("my notification");
	}

}
*/
