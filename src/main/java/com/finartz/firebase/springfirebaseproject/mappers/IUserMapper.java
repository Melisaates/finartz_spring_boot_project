package com.finartz.firebase.springfirebaseproject.mappers;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDTO;

public interface IUserMapper {
    UserDTO toUserDTO(User userEntity);
    User toUserEntity(UserDTO userDTO);
}

