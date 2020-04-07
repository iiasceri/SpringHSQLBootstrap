package com.deloitte.mvc.service;

import com.deloitte.mvc.dto.UserDto;
import com.deloitte.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    boolean validateUser(UserDto userDto);

    void add(User user);

    void deleteUserById(int userId);

    Optional<User> getUserByName(String username);
}
