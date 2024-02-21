package com.finartz.firebase.springfirebaseproject.service.inf;

import com.finartz.firebase.springfirebaseproject.models.UserDto;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;

import java.util.List;

public interface IUserService {
    public List<UserDto> listUsers() ;
    public UserDto getUserByName(String name) ;
    public UserDto getUserById(int userId) ;

    public UserDto deleteUser(int userId) ;
    public UserDto updateUser(int userId, CreateUserRequest userRequest) ;

}
