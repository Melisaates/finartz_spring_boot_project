package com.finartz.firebase.springfirebaseproject.repository.dao.inf;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDto;

import java.util.List;

public interface IUserDao {
    public List<UserDto> getAll();

    public UserDto getById(int id);

    public UserDto delete(UserDto user);

    public UserDto getByUserName(String name);

    public UserDto update(UserDto user);

    public UserDto get(String name);


    public UserDto save(User userEntity);
}
