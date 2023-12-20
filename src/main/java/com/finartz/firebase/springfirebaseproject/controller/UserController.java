package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDTO;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.responses.UserResponse;
import com.finartz.firebase.springfirebaseproject.service.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


public class UserController {

    private IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> listUsers(){
        List<UserDTO> listUsers= userService.listUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById (@PathVariable UUID id){
        UserResponse userResponse =new UserResponse(userService.getUserById(id)) ;
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id,@RequestBody CreateUserRequest updatedUser) {
        UserDTO updatedUserInfo = userService.updateUser(id,updatedUser);
        UserResponse userResponse=new UserResponse(updatedUserInfo);
        if (updatedUserInfo != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            // Belirtilen ID ile bir kullanıcı bulunamazsa 404 Not Found dönebilirsiniz.
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable UUID id) {
        return new ResponseEntity<>(new UserResponse(userService.deleteUser(id)), HttpStatus.CREATED);

    }

}
