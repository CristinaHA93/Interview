package com.example.usersapi.service;

import com.example.usersapi.exception.NoFoundException;
import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import com.sun.jdi.request.DuplicateRequestException;
import lombok.NonNull;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @NonNull
    public final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(User user) {

        try {
            return userRepository.save(user);
        }catch (DataIntegrityViolationException e){
            throw  new DuplicateRequestException(e.getMessage());
        }

    }

    @Override
    public User getById(Integer id) {
        return userRepository.findById(id).orElseThrow(()->new NoFoundException(id));
    }

}
