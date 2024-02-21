package com.finartz.firebase.springfirebaseproject.mappers.impl;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.mappers.inf.IUserMapper;
import com.finartz.firebase.springfirebaseproject.models.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper implements IUserMapper {
    @Override
    public UserDto toUserDTO(User user) {
        if (user == null)
            return null;

        UserDto userDTO = UserDto.builder()
                .userId(user.getId())
                .userName(user.getUserName())
                .userInterests(user.getUserInterests())
                .phoneNumber(user.getPhoneNumber())
                .email(user.getEmail())
                .password(user.getEncryptedPassword())
                .build();

        return userDTO;
    }

    @Override
    public User toUserEntity(UserDto userDTO) {
        if (userDTO == null)
            return null;
        
        User userEntity = User.builder()
                .id(userDTO.getUserId())
                .userName(userDTO.getName())
                .phoneNumber(userDTO.getPhoneNumber())
                .email(userDTO.getEmail())
                .encryptedPassword(userDTO.getPassword())
                .userInterests(userDTO.getUserInterests())
                .build();


        return userEntity;
    }




}


