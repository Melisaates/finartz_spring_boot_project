package com.finartz.firebase.springfirebaseproject.service.impl;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.AuthenticatedUserDto;
import com.finartz.firebase.springfirebaseproject.models.UserDto;
import com.finartz.firebase.springfirebaseproject.repository.UserRepo;
import com.finartz.firebase.springfirebaseproject.repository.dao.inf.IUserDao;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.requests.LogInRequest;
import com.finartz.firebase.springfirebaseproject.responses.CreateUserResponse;
import com.finartz.firebase.springfirebaseproject.responses.LogInResponse;
import com.finartz.firebase.springfirebaseproject.service.inf.IAuthService;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Value;
import org.conscrypt.ct.DigitallySigned;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.Base64;
import java.util.Date;

import static com.finartz.firebase.springfirebaseproject.service.impl.RSAEncryptorDecryptor.generateKeyPair;


/*
@Service
public class AuthService implements IAuthService {

    private final UserRepo userRepo;
    private final IUserDao userDao;
    private final RSAEncryptorDecryptor rsaEncryptorDecryptor;



    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;
*/

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthenticatedUserDto register(UserDto user) {
        //TODO cant since a real FCM token is needed
        String token = jwtService.generateToken((UserDetails) user);
        return AuthenticatedUserDto.builder()
                .userName(user.getName())
                .id(user.getUserId())
                .userInterests(user.getUserInterests())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .jwt(token)
                .build();
    }

    public String generateJTW(UserDto user) {
        return jwtService.generateToken((UserDetails) user);
    }

    //validate
    public AuthenticatedUserDto authenticate(LogInRequest loginRequest, UserDto user) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),
                        loginRequest.getPassword()
                )
        );
        String token = jwtService.generateToken((UserDetails) user);
        return AuthenticatedUserDto.builder()
                .userName(user.getName())
                .jwt(token)
                .userInterests(user.getUserInterests())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .id(user.getUserId())
                .build();
    }
}
/*
    public AuthService(UserRepo userRepo, IUserDao userDao, RSAEncryptorDecryptor rsaEncryptorDecryptor) {
        this.userRepo = userRepo;
        this.userDao = userDao;
        this.rsaEncryptorDecryptor = rsaEncryptorDecryptor;
    }
        //notificationService.subscribeToTopic("All",userDTO.getUserToken());

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) throws Exception {
        // Kullanıcı adının daha önceden alınıp alınmadığını kontrol et
        if (userRepo.findByUserName(createUserRequest.getUserName()).isPresent()) {
            throw new Exception("Kullanıcı adı zaten alınmış.");
        }


        KeyPair keyPair = generateKeyPair();
        System.out.println("oluştu keypair : " + keyPair);


        // Yeni kullanıcı oluştur
        User userEntity = new User();
        userEntity.setUserName(createUserRequest.getUserName());
        userEntity.setPublicKey(Base64.getEncoder().encodeToString(keyPair.getPublic().getEncoded()));
        userEntity.setPrivateKey(Base64.getEncoder().encodeToString(keyPair.getPrivate().getEncoded()));

        // Şifreyi şifreleyerek kaydet
        userEntity.setEncryptedPassword(RSAEncryptorDecryptor.encrypt(createUserRequest.getPassword(), keyPair.getPublic()));

        userRepo.save(userEntity);
        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("Kullanıcı başarıyla oluşturuldu.");
        return response;
    }

      /*  // Şifreleme
        String encryptedPassword = RSAEncryptorDecryptor.encrypt(createUserRequest.getPassword(), keyPair.getPublic());
        System.out.println("Encrypted Password: " + encryptedPassword);


        userEntity.setPassword(encryptedPassword);
        userDao.save(userEntity);


        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("Kullanıcı başarıyla oluşturuldu.");
        return response;

    }*/
/*

    @Override
    public LogInResponse authenticateUser(LogInRequest logInRequest) throws Exception {
        // Kullanıcı adını kullanarak veritabanından kullanıcıyı bul
        User userEntity = userDao.getByUserName(logInRequest.getUserName())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        // Girilen şifreyi kontrol et
        if (!RSAEncryptorDecryptor.encrypt(logInRequest.getPassword(), userEntity.getPublicKey())
                .equals(userEntity.getEncryptedPassword())) {
            throw new RuntimeException("Hatalı şifre");
        }

        LogInResponse response = new LogInResponse();
        response.setMessage("Giriş başarıyla gerçekleşti.");

        return response;
    }


}
*/
























/*    private FirebaseAuth auth;

    private void fireBaseConnector(){
        auth=FirebaseAuth.getInstance();
    }

    @Override
    public CreateUserRequest createUser(CreateUserRequest createUserRequest) throws Exception {
        fireBaseConnector();
        UserRecord.CreateRequest createRequest=new UserRecord.CreateRequest();
        createRequest.setEmail(createUserRequest.getEmail());
        createRequest.setPassword(createUserRequest.getPassword());
        createRequest.setDisplayName(createUserRequest.getUserName());
        createRequest.setPhoneNumber(createUserRequest.getPhoneNumber());
        return buildUserRecord(auth.createUser(createRequest));
    }

    private CreateUserRequest buildUserRecord(UserRecord userRecord) {
        return CreateUserRequest.builder()
                .email(userRecord.getEmail())
                .userName(userRecord.getDisplayName())
                .phoneNumber(userRecord.getPhoneNumber())
                .build();

    }
}*/
