package com.finartz.firebase.springfirebaseproject.mappers;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Component
public class UserMapper implements IUserMapper {
    @Override
    public UserDTO toUserDTO(User user) {
        if (user == null)
            return null;

        UserDTO userDTO = UserDTO.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .userInterests(user.getUserInterests())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        return userDTO;
    }

    @Override
    public User toUserEntity(UserDTO userDTO) {
        if (userDTO == null)
            return null;
        
        User userEntity = User.builder()
                .id(userDTO.getUserId())
                .userName(userDTO.getName())
                .phoneNumber(userDTO.getPhoneNumber())
                .email(userDTO.getEmail())
                .password(userDTO.getPassword())
                .userInterests(userDTO.getUserInterests())
                .build();


        return userEntity;
    }




}


