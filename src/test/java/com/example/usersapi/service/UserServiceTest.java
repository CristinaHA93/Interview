package com.example.usersapi.service;

import com.example.usersapi.exception.NoFoundException;
import com.example.usersapi.model.User;
import com.example.usersapi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;


    @Test
    void when_create_expect_userSaved(){
        User user = new User();

        Mockito.when(this.userRepository.save(any(User.class))).thenReturn(new User());

        User returned = this.userService.create(user);
        assertThat(returned, notNullValue());
    }

    @Test
    void when_create_expect_userSavedOnce(){
        User user = new User();

        this.userService.create(user);

        Mockito.verify(this.userRepository, Mockito.times(1)).save(any(User.class));
    }

    @Test
    void when_getById_expect_userFound(){
        Mockito.when(this.userRepository.findById(2)).thenReturn(Optional.of(new User()));

        User user = this.userService.getById(2);

        assertThat(user, notNullValue());
    }

    @Test
    void when_getById_expect_userNotFound(){
       RuntimeException exception = assertThrows(NoFoundException.class, ()-> this.userService.getById(1));

       assertEquals("Result with id 1 not found",exception.getMessage());
    }

}
