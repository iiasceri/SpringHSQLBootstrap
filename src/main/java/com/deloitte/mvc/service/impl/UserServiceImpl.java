package com.deloitte.mvc.service.impl;

import com.deloitte.mvc.dao.UserDao;
import com.deloitte.mvc.dto.UserDto;
import com.deloitte.mvc.model.User;
import com.deloitte.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public Optional<User> getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public boolean validateUser(UserDto userDto) {
        return userDao.getAllUsers().stream()
                .anyMatch(u -> userDto.getUsername().equals(u.getUsername()) && userDto.getPassword().equals(u.getPassword()));
    }

    @Override
    public void add(User user) {
        userDao.persist(user);
    }

    @Override
    public void deleteUserById(int userId) {
        userDao.deleteUserById(userId);
    }

    @Override
    public Optional<User> getUserByName(String username) {
        return userDao.getAllUsers().stream()
                .filter(u -> username.equals(u.getUsername()))
                .findFirst();
    }
}
