package com.finartz.firebase.springfirebaseproject.repository.dao;

import com.finartz.firebase.springfirebaseproject.mappers.UserMapper;
import com.finartz.firebase.springfirebaseproject.models.UserDTO;
import com.finartz.firebase.springfirebaseproject.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;



public class UserDAO {



    private final UserRepo userRepo;
    private final UserMapper userMapper;
    private final ResourceBundleMessageSource source;



    public UserDAO(UserRepo userRepo, UserMapper userMapper, ResourceBundleMessageSource source) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
        this.source = source;
    }

    public List<UserDTO> getAll() {
        //return list user
        return userRepo.findAll()
                .stream().map(userMapper::toUserDTO)
                .collect(Collectors.toList());
    }


    public UserDTO getById(UUID id) {
        //return optionaş
        return userMapper.toUserDTO(userRepo.findById(id)
                .orElseThrow(() -> new NullPointerException(
                        source.getMessage("user.notfound", null, LocaleContextHolder.getLocale()))));


    }

    public UserDTO delete(UserDTO user) {
        userRepo.delete(userMapper.toUserEntity(user));
        return user;    }

    public UserDTO update(UserDTO user) {
        return userMapper.toUserDTO(userRepo.save(userMapper.toUserEntity(user)));
    }

    public UserDTO get(String name) {
        return userMapper.toUserDTO(userRepo.findByName(name));

    }
}
