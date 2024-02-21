package com.finartz.firebase.springfirebaseproject.repository.dao.impl;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.mappers.impl.UserMapper;
import com.finartz.firebase.springfirebaseproject.models.UserDto;
import com.finartz.firebase.springfirebaseproject.repository.UserRepo;
import com.finartz.firebase.springfirebaseproject.repository.dao.inf.IUserDao;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import java.util.List;
import java.util.stream.Collectors;



public class UserDao implements IUserDao {

    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final ResourceBundleMessageSource source;

    private final UserDto userDto;



    public UserDao(UserRepo userRepo, UserMapper userMapper, ResourceBundleMessageSource source, UserDto userDto) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.source = source;
        this.userDto = userDto;
    }

    public List<UserDto> getAll() {
        //return list user
        return userRepo.findAll()
                .stream().map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }

    public UserDto getByUserName(String name) {

        return userMapper.toUserDTO(userRepo.findByUserName(name));

    }
    public UserDto getByEmail(String email) {

        return userMapper.toUserDTO(userRepo.findByEmail(email));

    }



    public UserDto getById(int id) {
        //return optional
        return userMapper.toUserDTO(userRepo.findById(id)
                .orElseThrow(() -> new NullPointerException(
                        source.getMessage("user.notfound", null, LocaleContextHolder.getLocale()))));


    }

    public UserDto delete(UserDto user) {
        userRepo.delete(userMapper.toUserEntity(user));
        return user;    }

    public UserDto update(UserDto user) {
        return userMapper.toUserDTO(userRepo.save(userMapper.toUserEntity(user)));
    }

    public UserDto get(String name) {
        return userMapper.toUserDTO(userRepo.findByUserName(name));

    }

    @Override
    public UserDto save(User userEntity) {
        return userMapper.toUserDTO(userRepo.save(userMapper.toUserEntity(userDto)));

    }
}



