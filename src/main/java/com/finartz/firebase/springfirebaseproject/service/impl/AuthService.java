package com.finartz.firebase.springfirebaseproject.service.impl;

import com.finartz.firebase.springfirebaseproject.entity.User;
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
import org.springframework.stereotype.Service;

import java.security.KeyPair;
import java.util.Date;

import static com.finartz.firebase.springfirebaseproject.service.impl.RSAEncryptorDecryptor.generateKeyPair;


@Getter
@Setter
@Service
public class AuthService implements IAuthService {

    private final UserRepo userRepo;
    private final IUserDao userDao;
    private final RSAEncryptorDecryptor rsaEncryptorDecryptor;




    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private Long jwtExpiration;


    public AuthService(UserRepo userRepo, IUserDao userDao, RSAEncryptorDecryptor rsaEncryptorDecryptor) {
        this.userRepo = userRepo;
        this.userDao = userDao;
        this.rsaEncryptorDecryptor = rsaEncryptorDecryptor;
    }

    @Override
    public CreateUserResponse createUser(CreateUserRequest createUserRequest) throws Exception {
        // Kullanıcı adının daha önceden alınıp alınmadığını kontrol et
        if (userRepo.findByUserName(createUserRequest.getUserName()).isPresent()) {
            throw new Exception("Kullanıcı adı zaten alınmış.");
        }

        // Yeni kullanıcı oluştur
        User userEntity = new User();
        userEntity.setUserName(createUserRequest.getUserName());


        KeyPair keyPair = generateKeyPair();
        System.out.println("oluştu keypair : " + keyPair);


        // Şifreleme
        String encryptedPassword = RSAEncryptorDecryptor.encrypt(createUserRequest.getPassword(), keyPair.getPublic());
        System.out.println("Encrypted Password: " + encryptedPassword);


        userEntity.setPassword(encryptedPassword);
        userDao.save(userEntity);


        CreateUserResponse response = new CreateUserResponse();
        response.setMessage("Kullanıcı başarıyla oluşturuldu.");
        return response;

    }

@Override
    public LogInResponse authenticateUser(LogInRequest logInRequest) throws Exception {

        KeyPair keypair = generateKeyPair();

        // Kullanıcı adını kullanarak veritabanından kullanıcıyı bul
        User userEntity = userDao.getByUserName(logInRequest.getUserName())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        // Girilen şifreyi kontrol et
        if (RSAEncryptorDecryptor.encrypt(logInRequest.getPassword()) != RSAEncryptorDecryptor.encrypt(userEntity.getPassword())) {
            throw new RuntimeException("Hatalı şifre");
        }

        // JWT oluştur
        String token = Jwts.builder()
                .setSubject(userEntity.getUserName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(DigitallySigned.SignatureAlgorithm.HS256, jwtSecret)
                .compact();

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setMessage("Giriş başarıyla gerçekleşti.");

        return response;
    }
}

























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
