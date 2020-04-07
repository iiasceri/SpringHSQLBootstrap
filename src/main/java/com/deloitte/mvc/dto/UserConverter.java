package com.deloitte.mvc.dto;

import com.deloitte.mvc.model.User;

public class UserConverter {

    public static UserDto convert(User user) {
        return new UserDto(user.getUsername(), user.getPassword());
    }
}
