package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDTO;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IUserService {
    public List<UserDTO> listUsers() ;
    public UserDTO getUserByName(String name) ;
    public UserDTO getUserById(UUID userId) ;

    public UserDTO deleteUser(UUID userId) ;
    public UserDTO updateUser(UUID userId, CreateUserRequest userRequest) ;

}
