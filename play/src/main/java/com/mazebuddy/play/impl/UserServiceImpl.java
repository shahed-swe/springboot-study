package com.mazebuddy.play.impl;

import com.mazebuddy.play.dto.UserDto;
import com.mazebuddy.play.entity.User;
import com.mazebuddy.play.entity.VerificationToken;
import com.mazebuddy.play.repository.UserRepository;
import com.mazebuddy.play.repository.VerificationTokenRepository;
import com.mazebuddy.play.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Override
    public User registerUser(UserDto userDetails) {
        User user = new User();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setRole(userDetails.getRole());
        user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
        return userRepository.save(user);

    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken = new VerificationToken(user, token);
        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerification(String token) {
        VerificationToken verificationToken = verificationTokenRepository.findByToken(token);
        if(verificationToken == null){
            return "invalid";
        }
        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();
        if((verificationToken.getExpirationTime().getTime() - cal.getTime().getTime()) <= 0){
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        }else{
            user.setActivated(true);
            userRepository.save(user);
            return "valid";
        }
    }

    @Override
    public User sendTokenAgain(String email) {
        return userRepository.findByEmail(email);
    }
}
