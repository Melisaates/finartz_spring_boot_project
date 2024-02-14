package com.finartz.firebase.springfirebaseproject.mappers.inf;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDto;

public interface IUserMapper {
    UserDto toUserDTO(User userEntity);
    User toUserEntity(UserDto userDTO);
}

