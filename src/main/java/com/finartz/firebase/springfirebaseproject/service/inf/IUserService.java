package com.finartz.firebase.springfirebaseproject.service.inf;

import com.finartz.firebase.springfirebaseproject.models.UserDto;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    public List<UserDto> listUsers() ;
    public UserDto getUserByName(String name) ;
    public UserDto getUserById(UUID userId) ;

    public UserDto deleteUser(UUID userId) ;
    public UserDto updateUser(UUID userId, CreateUserRequest userRequest) ;

}
