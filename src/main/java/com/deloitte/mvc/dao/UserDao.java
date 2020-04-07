package com.deloitte.mvc.dao;

import com.deloitte.mvc.model.Gender;
import com.deloitte.mvc.model.Status;
import com.deloitte.mvc.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    List<User> getAllUsers();

    Optional<User> getUserById(int id);

    void persist(User user);

    void deleteUserById(int userId);

}
