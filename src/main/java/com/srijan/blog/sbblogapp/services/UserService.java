package com.srijan.blog.sbblogapp.services;

import com.srijan.blog.sbblogapp.entities.User;
import com.srijan.blog.sbblogapp.payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
