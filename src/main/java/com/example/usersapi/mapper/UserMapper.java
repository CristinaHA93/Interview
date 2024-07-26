package com.example.usersapi.mapper;

import com.example.usersapi.dto.UserDTO;
import com.example.usersapi.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    UserDTO toDto(User product);

    User toUser (UserDTO userDTO);

}
