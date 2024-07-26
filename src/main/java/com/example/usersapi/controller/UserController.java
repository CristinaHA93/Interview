package com.example.usersapi.controller;

import com.example.usersapi.dto.UserDTO;
import com.example.usersapi.mapper.UserMapper;
import com.example.usersapi.model.User;
import com.example.usersapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping
    public ResponseEntity<UserDTO> createProduct(@Valid @RequestBody UserDTO userDto){
        User userRequest = userMapper.toUser(userDto);
        User newUser = userService.create(userRequest);
        return new ResponseEntity<>(userMapper.toDto(newUser), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id){
        User user = userService.getById(id);
        return new ResponseEntity<>(userMapper.toDto(user), HttpStatus.OK);
    }

}
