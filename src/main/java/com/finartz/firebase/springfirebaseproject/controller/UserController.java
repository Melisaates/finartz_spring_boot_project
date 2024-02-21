package com.finartz.firebase.springfirebaseproject.controller;
import com.finartz.firebase.springfirebaseproject.models.UserDto;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.responses.UserResponse;
import com.finartz.firebase.springfirebaseproject.service.inf.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class UserController {

    private IUserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> listUsers(){
        List<UserDto> listUsers= userService.listUsers();
        return new ResponseEntity<>(listUsers, HttpStatus.OK);

    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUserById (@PathVariable int id){
        UserResponse userResponse =new UserResponse(userService.getUserById(id)) ;
        return new ResponseEntity<>(userResponse,HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable int id,@RequestBody CreateUserRequest updatedUser) {
        UserDto updatedUserInfo = userService.updateUser(id,updatedUser);
        UserResponse userResponse=new UserResponse(updatedUserInfo);
        if (updatedUserInfo != null) {
            return ResponseEntity.ok(userResponse);
        } else {
            // Belirtilen ID ile bir kullanıcı bulunamazsa 404 Not Found dönebilirsiniz.
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable int id) {
        return new ResponseEntity<>(new UserResponse(userService.deleteUser(id)), HttpStatus.CREATED);

    }

}
