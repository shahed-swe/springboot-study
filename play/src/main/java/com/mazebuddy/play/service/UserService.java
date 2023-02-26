package com.mazebuddy.play.service;

import com.mazebuddy.play.dto.UserDto;
import com.mazebuddy.play.entity.User;

public interface UserService {
    User registerUser(UserDto userDetails);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerification(String token);
}
