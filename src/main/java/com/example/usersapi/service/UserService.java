package com.example.usersapi.service;

import com.example.usersapi.model.User;

public interface UserService {

    User create(User user);

    User getById(Integer id);

}
