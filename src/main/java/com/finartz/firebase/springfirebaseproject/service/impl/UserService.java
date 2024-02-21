package com.finartz.firebase.springfirebaseproject.service.impl;

import com.finartz.firebase.springfirebaseproject.models.UserDto;
import com.finartz.firebase.springfirebaseproject.repository.dao.inf.IUserDao;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import com.finartz.firebase.springfirebaseproject.service.inf.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    //private final List<User> userList = new ArrayList<>();
    private final IUserDao userDao;


    @Autowired
    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public List<UserDto> listUsers() {
        return userDao.getAll();
    }


    @Override
    @Transactional
    public UserDto getUserByName(String name) {
        UserDto user = userDao.get(name);
        if(user==null)
            throw new NullPointerException();
        return user;
    }


    @Override
    @Transactional
    public UserDto getUserById(int userId) {
        /*return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();*/
        return userDao.getById(userId);
    }

    @Override
    @Transactional
    public UserDto deleteUser(int userId) {
       UserDto user = getUserById(userId);
       return userDao.delete(user);
    }


    @Override
    @Transactional
    public UserDto updateUser(int userId, CreateUserRequest userRequest) {
        UserDto user = getUserById(userId);
        if (userRequest.getUserName() != null && !userRequest.getUserName().equals(""))
            user.setUserName(userRequest.getUserName());
        if (userRequest.getPhoneNumber() != null)
            user.setPhoneNumber(userRequest.getPhoneNumber());
        if (userRequest.getPassword() != null && !userRequest.getPassword().equals(""))
            user.setPassword(userRequest);
        if (userRequest.getEmail() != null)
            user.setEmail(userRequest.getEmail());
        return userDao.update(user);
    }

}
