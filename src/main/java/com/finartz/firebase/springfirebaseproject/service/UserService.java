package com.finartz.firebase.springfirebaseproject.service;

import com.finartz.firebase.springfirebaseproject.entity.User;
import com.finartz.firebase.springfirebaseproject.models.UserDTO;
import com.finartz.firebase.springfirebaseproject.repository.dao.UserDAO;
import com.finartz.firebase.springfirebaseproject.requests.CreateUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService implements  IUserService{

    //private final List<User> userList = new ArrayList<>();
    private final UserDAO userDAO;


    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public List<UserDTO> listUsers() {
        return userDAO.getAll();
    }


    public UserDTO getUserByName(String name) {
        UserDTO user = userDAO.get(name);
        if(user==null)
            throw new NullPointerException();
        return user;
    }


    public UserDTO getUserById(UUID userId) {
        /*return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst();*/
        return userDAO.getById(userId);
    }
    public UserDTO deleteUser(UUID userId) {
       UserDTO user = getUserById(userId);
       return userDAO.delete(user);
    }

    public UserDTO updateUser(UUID userId, CreateUserRequest userRequest) {
        UserDTO user = getUserById(userId);
        if (userRequest.getUserName() != null && !userRequest.getUserName().equals(""))
            user.setUserName(userRequest.getUserName());
        if (userRequest.getPhoneNumber() != null)
            user.setPhoneNumber(userRequest.getPhoneNumber());
        if (userRequest.getPassword() != null && !userRequest.getPassword().equals(""))
            user.setPassword(userRequest);
        if (userRequest.getEmail() != null)
            user.setEmail(userRequest.getEmail());
        return userDAO.update(user);
    }

}
