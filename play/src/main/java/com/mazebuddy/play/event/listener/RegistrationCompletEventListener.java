package com.mazebuddy.play.event.listener;

import com.mazebuddy.play.entity.User;
import com.mazebuddy.play.event.RegistrationPublishEvent;
import com.mazebuddy.play.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompletEventListener implements ApplicationListener<RegistrationPublishEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationPublishEvent event){
//        create the verification token for the user with link
        User user = event.getUser();
        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);

//        send mail to user
        String url = event.getApplicationUrl() + "verifyRegistration?token="+token;

//        send verificationEmail()
        log.info("Click the link to verify your account: {}", url);

    }
}
